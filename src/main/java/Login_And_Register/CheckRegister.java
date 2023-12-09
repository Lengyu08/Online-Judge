package Login_And_Register; 

//导入与数据库连接和SQL操作相关的Java包和类
import java.sql.Connection;         // 数据库连接接口
import java.sql.DriverManager;      // 数据库驱动管理类
import java.sql.PreparedStatement;  // 预编译SQL语句执行类
import java.sql.ResultSet;          // 查询结果集类
import java.sql.SQLException;       // 数据库操作异常类

import java.util.HashMap;           // 哈希表

import Mysql.Base;                  // 数据库的基类

public class CheckRegister extends Base {
    // 初始化
    ResultSet rs = null;
    Connection conn = null;
    PreparedStatement pstmt = null;

	public void referToMysql(
        String username, String password, String email,
        String phoneNumber, String hobby, String gender,
        String loginTime_result,
        int morning_cnt, int afternoon_cnt, int evening_cnt 
    ) {
        try {
            loadDrive();
            // 创建数据库连接
            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            // 准备SQL语句模板
            String sql = "UPDATE `function_user` " +
                        "SET `count` = `count` + ? " +
                        "WHERE `function_name` = ?";

            HashMap<String, Integer> functionMap = new HashMap<>();

            functionMap.put("morning", morning_cnt);
            functionMap.put("afternoon", afternoon_cnt);
            functionMap.put("evening", evening_cnt);

            String[] functions = {"morning", "afternoon", "evening"};

            // 准备PreparedStatement对象
            PreparedStatement pstmt = conn.prepareStatement(sql);

            for (String function_name : functions) {
                pstmt.setInt(1, functionMap.get(function_name));
                pstmt.setString(2, function_name);
                // 执行更新操作
                pstmt.executeUpdate();
            }

            // 插入用户表
            sql = "INSERT INTO user (username, password, email, phone_number, interests, gender, login_time, right_level) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, phoneNumber);
            pstmt.setString(5, hobby);
            pstmt.setString(6, gender);
            pstmt.setString(7, loginTime_result);
            pstmt.setInt(8, 2);

            // 执行插入操作
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	public boolean checkRepeatName(String username) {
		boolean isValidRepeat = false;
		
        try {
        	// 创建数据库连接
            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            // 创建 SQL 查询语句
            String query = "select count(*) from user where username = ?";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1); 	//  rs 中获取第一列的整数值，并将其存储在变量 count 
                if (count > 0) {
                	isValidRepeat = true; 	// 如果用户名已存在，将 isRepeat 设置为true
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("查询用户名重复成功, 结果是 " + isValidRepeat);
        
		return isValidRepeat;
	}
}
