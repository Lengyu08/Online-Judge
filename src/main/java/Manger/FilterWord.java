package Manger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequestWrapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

import java.util.Set;
import java.util.HashSet;

import Manger.CapturingResponseWrapper;

public class FilterWord implements Filter {

    private Set<String> keywords = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 获取当前的绝对路径
        String path = filterConfig.getServletContext().getRealPath("/");
        System.out.println("绝对路径 : " + path);
        // 获取相对路径 /STATIC-RESOURCES/KeyWord/ 下面所有的 txt 文件
        String staticDirectory = path + "/STATIC-RESOURCES/KeyWord/";

        File staticDir = new File(staticDirectory);
        File[] files = staticDir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            // 假设关键词用空格或回车分隔
                            String[] words = line.split("[\\s\\n]+");
                            for (String word : words) {
                                keywords.add(word);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 包装请求
        HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper((HttpServletRequest) request);

        // 使用自定义响应包装器包装响应
        CapturingResponseWrapper responseWrapper = new CapturingResponseWrapper((HttpServletResponse) response);

        // 继续过滤器链
        chain.doFilter(requestWrapper, responseWrapper);

        // 捕获响应内容
        String filteredContent = responseWrapper.getCapturedContent();

        System.out.println("filteredContent :\n" + filteredContent);

        // 所有的关键字替换为 ***
        for (String keyword : keywords) {
            filteredContent = filteredContent.replaceAll(keyword, "***");
        }
        
        response.getWriter().write(filteredContent);
    }
    

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
