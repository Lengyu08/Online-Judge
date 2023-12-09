package Mysql;

public class Base {
    protected String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/zwh";   // 数据库连接URL
    protected String jdbcUsername = "root";                         // 数据库用户名
    protected String jdbcPassword = "123456";                       // 数据库密码

    public void loadDrive() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Load Driver Successful");
        } catch (ClassNotFoundException e) {
            System.out.println("Load Driver Failed");
            e.printStackTrace();
        }
    }
}
