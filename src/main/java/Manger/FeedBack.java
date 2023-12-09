package Manger;

import java.sql.ResultSet;          // 用于存储查询结果
import java.sql.Connection;         // 用于连接数据库
import java.sql.SQLException;       // 用于处理异常
import java.sql.DriverManager;      // 用于加载驱动
import java.sql.PreparedStatement;  // 用于执行SQL语句

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import Mysql.Base;
import Manger.AdminMessage;

public class FeedBack extends Base {
    private final List<AdminMessage> messageList = new ArrayList<>();

    public int getMessageListSize() {
        return messageList.size();
    }

    public int getMessageId(int index) {
        return messageList.get(index).getId();
    }

    public String getMessageUsername(int index) {
        return messageList.get(index).getUsername();
    }

    public String getMessageType(int index) {
        return messageList.get(index).getType();
    }

    public String getMessageEmail(int index) {
        return messageList.get(index).getEmail();
    }

    public Date getMessageTime(int index) {
        return messageList.get(index).getTime();
    }

    public void refer_to_user(int email_id, String admin_name, String content) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            loadDrive();
            // 创建数据库连接
            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            String sql = "insert into user_mailbox (username, admin_name, content) values ((select username from admin_mailbox where id = ?), ?, ?);";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, email_id);
            stmt.setString(2, admin_name);
            stmt.setString(3, content);

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

    public void delete_mail(int email_id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            loadDrive();
            // 创建数据库连接
            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            String sql = "delete from admin_mailbox where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, email_id);

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

    public void queryList() {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            loadDrive();
            // 创建数据库连接
            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            // 创建SQL查询语句 // 占位防止 SQL 注入
            String sql = "select id, username, type, email, time from admin_mailbox order by id;";
            stmt = conn.prepareStatement(sql);

            // 执行查询
            rs = stmt.executeQuery();

            messageList.clear();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String type = rs.getString("type");
                String email = rs.getString("email");
                Date time = rs.getDate("time");

                AdminMessage adminMessage = new AdminMessage(id, username, type, email, time);
                messageList.add(adminMessage);
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
}


