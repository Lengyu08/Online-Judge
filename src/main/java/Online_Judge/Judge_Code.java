package Online_Judge;

import java.io.*;
import java.nio.file.Paths;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Judge_Code extends HttpServlet {
    // 全局锁
    public static final Lock lock = new ReentrantLock();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String code = request.getParameter("code");
        String problemId = (String) session.getAttribute("problemId");
        String loggedInUsername = (String) session.getAttribute("loggedInUsername");

        String ans = null;
        String nextPage = "/PROBLEMSET/" + problemId + ".jsp";
        String language = request.getParameter("language");

        if (loggedInUsername == null || loggedInUsername.isEmpty()) {
            ans = "Please_login_first";
        } else if (code == null || code.isEmpty()) {
            ans = "Please_enter_your_code";
        } else {    // 主逻辑
            lock.lock();
            String fileExtension = "";
            if (language.equals("text/x-c++src")) {
                fileExtension = "main.cpp";
            } else if (language.equals("text/x-java")) {
                fileExtension = "Main.java";
            } else if (language.equals("python")) {
                fileExtension = "main.py";
            }
            // 存储为临时的文件
            String completeFileName = fileExtension;
            // 获取 ServletContext 因为需要对服务器的 IO 进行操作
            ServletContext context = getServletContext();
            // 获取文件的真实路径
            String rootPath = context.getRealPath("/");
            // System.out.println("rootPath: " + rootPath);
            String directoryPath = rootPath + "PROBLEMSET/" + problemId + "/";
            File directory = new File(directoryPath);

            // Ensure the directory exists, create it if not
            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    System.out.println("Directory created successfully");
                } else {
                    System.out.println("Failed to create directory");
                }
            }

            File tempFile = new File(directoryPath, completeFileName);

            try {
                FileWriter fileWriter = new FileWriter(tempFile);
                fileWriter.write(code);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ans = judge(language, directoryPath);
            lock.unlock();
        }

        request.setAttribute("ans", ans);
        try {
            request.getRequestDispatcher(nextPage).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String judge(String language, String directoryPath) {
        boolean isCorrect = false;

        int startID = 1;    // 测试数据的起始编号
        int endID = 1;      // 测试数据的结束编号

        // 编译, 输出答案
        if (language.equals("text/x-c++src")) {
            if (!compileCppFile(directoryPath, "main.cpp")) return "Compilation_Error";
            for (int id = startID; id <= endID; id ++ ) {
                try {
                    // 构建编译命令 // Windows一定要加转义符号并且包裹命令 // 但是 Linux 则不能因为内部机制不同
                    // String[] command = {"bash", "-c", "\"./main < " + id + ".in > " + id + ".out\""};
                    String[] command = {"bash", "-c", "./main < " + id + ".in > " + id + ".out"};


                    // 设置工作目录
                    File directory = new File(directoryPath);
                    ProcessBuilder processBuilder = new ProcessBuilder(command);
                    processBuilder.directory(directory);

                    // 启动进程并等待其完成
                    Process process = processBuilder.start();
                    int exitCode = process.waitFor();

                    // 检查是否成功
                    if (exitCode == 0) {
                        System.out.println("File output Successful");
                    } else {
                        System.out.println("File output failed");
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (language.equals("text/x-java")) {
            if (!compileJavaFile(directoryPath, "Main.java")) return "Compilation_Error";
            for (int id = startID; id <= endID; id ++) {
                try {
                    // 构建编译命令 Windows 写法
                    // String[] command = {"bash", "-c", "\"java", "Main", "<", id + ".in", ">", id + ".out\""};
                    String[] command = {"bash", "-c", "java Main < " + id + ".in > " + id + ".out"};

                    // 设置工作目录
                    File directory = new File(directoryPath);
                    ProcessBuilder processBuilder = new ProcessBuilder(command);
                    processBuilder.directory(directory);

                    // 启动进程并等待其完成
                    Process process = processBuilder.start();
                    int exitCode = process.waitFor();

                    // 检查是否成功
                    if (exitCode == 0) {
                        System.out.println("File output Successful");
                    } else {
                        System.out.println("File output failed");
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (language.equals("python")) {
            for (int id = startID; id <= endID; id ++ ) {
                try {
                    // 构建运行命令
                    // String[] command = {"bash", "-c", "python3", "main.py", "<", id + ".in", ">", id + ".out"};
                    String[] command = {"bash", "-c", "python3 main.py < " + id + ".in > " + id + ".out"};

                    // 设置工作目录
                    File directory = new File(directoryPath);
                    ProcessBuilder processBuilder = new ProcessBuilder(command);
                    processBuilder.directory(directory);

                    System.out.println("Start running");

                    // 启动进程并等待其完成
                    Process process = processBuilder.start();
                    int exitCode = process.waitFor();

                    System.out.printf("Exit code: %d\n", exitCode);

                    // 检查是否成功
                    if (exitCode == 0) {
                        System.out.println("File output Successful");
                    } else {
                        System.out.println("File output failed");
                        return "Compilation_Error";
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        for (int id = startID; id <= endID; id ++) {
            // 比较 1.out 和 1.ans 的内容如果相同 isCorrect = true
            // System.out.println("the directoryPath is " + directoryPath);
            String outputFilePath = directoryPath + "/" + id + ".out";
            String answerFilePath = directoryPath + "/" + id + ".ans";
            try {
                String outputContent = new String(java.nio.file.Files.readAllBytes(Paths.get(outputFilePath)));
                String answerContent = new String(java.nio.file.Files.readAllBytes(Paths.get(answerFilePath)));
                isCorrect = outputContent.equals(answerContent);
                if (isCorrect == false) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 清空 out 文件
        for (int id = startID; id <= endID; id ++) {
            String outputFilePath = directoryPath + "/" + id + ".out";
            try {
                FileWriter fileWriter = new FileWriter(outputFilePath);
                fileWriter.write("");
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return isCorrect ? "Accepted" : "Wrong_Answer";
    }

    private boolean compileCppFile(String directoryPath, String cppFileName) {
        try {
            // 构建编译命令
            String[] command = {"g++", cppFileName, "-o", "main"};

            // 设置工作目录
            File directory = new File(directoryPath);
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.directory(directory);

            // 启动进程并等待其完成
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            // 检查编译是否成功
            if (exitCode == 0) {
                System.out.println("Compilation successful");
                return true;
            } else {
                System.out.println("Compilation failed");
                return false;
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean compileJavaFile(String directoryPath, String javaFileName) {
        try {
            // 构建编译命令
            String[] command = {"javac", javaFileName};

            // 设置工作目录
            File directory = new File(directoryPath);
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.directory(directory);

            // 启动进程并等待其完成
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            // 检查编译是否成功
            if (exitCode == 0) {
                System.out.println("Compilation successful");
                return true;
            } else {
                System.out.println("Compilation failed");
                return false;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
