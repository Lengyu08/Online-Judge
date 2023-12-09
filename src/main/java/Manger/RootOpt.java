package Manger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import Mysql.Base;
import Login_And_Register.CheckRegister;

public class RootOpt extends Base {
    private static final List<User> userList = new ArrayList<>();

    public int getUserListSize() {
        return userList.size();
    }

    public int getUserId(int index) {
        return userList.get(index).getId();
    }

    public String getUserName(int index) {
        return userList.get(index).getUsername();
    }

    public String getUserPassword(int index) {
        return userList.get(index).getPassword();
    }

    public String getUserLevel(int index) {
        return userList.get(index).getLevel();
    }

    public void queryUserList() {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            loadDrive();
            // 创建数据库连接
            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            // 创建SQL查询语句 // 占位防止 SQL 注入
            String sql = "select user_id, username, password, right_level from user order by user_id";
            stmt = conn.prepareStatement(sql);

            // 执行查询
            rs = stmt.executeQuery();

            // 检查是否存在匹配的用户
            userList.clear();
            while (rs.next()) {
                userList.add(new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("right_level")
                ));
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
    }

    public void addUser(String username, String password, int right_level) {
        System.out.println("addUser: " + username + " " + password + " " + right_level);
        if (new CheckRegister().checkRepeatName(username) || username == null || password == null || username.isEmpty() || password.isEmpty()) {
            System.out.println("exit because of invalid input");
            return;
        }
        if (right_level < 0 || right_level > 2) {
            System.out.println("right_level is invalid");
            return;
        }
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            loadDrive();
            // 创建数据库连接
            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            // 创建SQL查询语句 // 占位防止 SQL 注入
            String sql = "insert into user (username, password, right_level) values (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setInt(3, right_level);

            // 执行插入
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteUser(String username) {
        if (!new CheckRegister().checkRepeatName(username) || username == null || username.isEmpty()) {
            return;
        }
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            loadDrive();
            // 创建数据库连接
            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            // 创建SQL查询语句 // 占位防止 SQL 注入
            String sql = "delete from user where username = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);

            // 执行插入
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void modifyUser(String username, String password, int right_level) {
        System.out.println("modifyUser: " + username + " " + password + " " + right_level);
        if (!new CheckRegister().checkRepeatName(username) || username == null || password == null || username.isEmpty() || password.isEmpty()) {
            System.out.println("modify user exit because of invalid input and checkRepeatName" + new CheckRegister().checkRepeatName(username));
            return;
        }

        if (right_level < 0 || right_level > 2) {
            System.out.println("modifyUser: right_level is invalid");
            return;
        }

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            loadDrive();
            // 创建数据库连接
            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            // 创建SQL查询语句 // 占位防止 SQL 注入
            String sql = "update user set password = ?, right_level = ? where username = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, password);
            stmt.setInt(2, right_level);
            stmt.setString(3, username);

            // 执行插入
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
