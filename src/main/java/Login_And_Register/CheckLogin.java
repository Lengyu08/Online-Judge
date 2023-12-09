package Login_And_Register;

//导入与数据库连接和SQL操作相关的Java包和类
import java.sql.Connection;         // 数据库连接接口
import java.sql.DriverManager;      // 数据库驱动管理类
import java.sql.PreparedStatement;  // 预编译SQL语句执行类
import java.sql.ResultSet;          // 查询结果集类
import java.sql.SQLException;       // 数据库操作异常类

import Mysql.Base;

import java.util.Set;
import java.util.HashSet;

public class CheckLogin extends Base {
    private static Set<String> globalSet = new HashSet<>();

    // 验证用户登录的方法
    public boolean checkUser(String username, String password) {
        boolean isValidUser = false;  
        // 初始化
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            loadDrive();
            // 创建数据库连接
            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            // 创建SQL查询语句 // 占位防止 SQL 注入
            String sql = "select * from user where username = ? and password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            // 执行查询
            rs = stmt.executeQuery();

            // 检查是否存在匹配的用户
            if (rs.next()) {
                isValidUser = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // log
        System.out.println("用户的账号和密码 " + isValidUser);

        // 返回是否验证通过的布尔值
        return isValidUser;
    }

    public boolean checkRepeatedLogin(String username) {
        if (globalSet == null) {
            return true;
        } else {
            return !globalSet.contains(username);
        }
    }

    public void loginUser(String username) {
        if (globalSet == null) {
            globalSet = new HashSet<>();
        }
        globalSet.add(username);
    }

    public void logoutUser(String username) {
        if (globalSet == null) {
            globalSet = new HashSet<>();
        }
        globalSet.remove(username);
    }
}

