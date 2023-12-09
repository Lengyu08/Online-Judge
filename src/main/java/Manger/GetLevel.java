package Manger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Mysql.Base;

public class GetLevel extends Base {
    public int getLevel(String username) {
        // 初始化
        int level = -1;  // 默认值或错误指示
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            loadDrive();

            // 创建数据库连接
            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            // 创建SQL查询语句 // 用于防止SQL注入的占位符
            String sql = "SELECT right_level FROM user WHERE username = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);

            // 执行查询
            rs = stmt.executeQuery();

            // 处理结果
            if (rs.next()) {
                // 假设right_level是一个整数列
                level = rs.getInt("right_level");
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

        return level;
    }
}
