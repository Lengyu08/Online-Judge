package Mysql;

import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.assertNotNull;

public class BaseTest extends Base {
    ResultSet rs = null;
    Connection conn = null;
    PreparedStatement stmt = null;

    @Test
    public void test_connect() {
        try {
            conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
            assertNotNull(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
