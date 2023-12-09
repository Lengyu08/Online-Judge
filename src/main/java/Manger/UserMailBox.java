package Manger;

import java.sql.ResultSet;          // 用于存储查询结果
import java.sql.Connection;         // 用于连接数据库
import java.sql.SQLException;       // 用于处理异常
import java.sql.DriverManager;      // 用于加载驱动
import java.sql.PreparedStatement;  // 用于执行SQL语句

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

import Mysql.Base;
import Manger.UserMessage;

public class UserMailBox extends Base {
    private final List<UserMessage> messageList = new ArrayList<>();

    public int getMessageListSize() {
        return messageList.size();
    }

    public int getMessageId(int index) {
        return messageList.get(index).getId();
    }

    public String getMessageTime(int index) {
        Date messageTime = messageList.get(index).getTime();

        // 使用 SimpleDateFormat 进行日期格式化
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormatter.format(messageTime);

        // // 格式化后的日期字符串
        // System.out.println("Message " + index + " was received on " + formattedDate);

        // 如果你还需要返回 Date 对象，可以返回 messageTime
        return formattedDate;
    }

    public String getMessageUsername(int index) {
        return messageList.get(index).getUsername();
    }

    public String getMessageAdminName(int index) {
        return messageList.get(index).getAdminName();
    }

    public String getMessageContent(int index) {
        return messageList.get(index).getContent();
    }

    public void queryList(String username) {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            loadDrive();

            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            String sql = "select id, time, username, admin_name, content from user_mailbox order by time";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            messageList.clear();
            while (rs.next()) {
                int id = rs.getInt("id");
                Date time = rs.getTimestamp("time");
                String user_name = rs.getString("username");
                String admin_name = rs.getString("admin_name");
                String content = rs.getString("content");
                if (user_name.equals(username)) {
                    messageList.add(new UserMessage(id, time, user_name, admin_name, content));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭连接
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void raiseQuestion(String username, String type, String content) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            loadDrive();

            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            String sql = "insert into admin_mailbox (username, type, email) values (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, type);
            stmt.setString(3, content);

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

    public void clearMail(String username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            loadDrive();

            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            String sql = "delete from user_mailbox where username = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);

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
