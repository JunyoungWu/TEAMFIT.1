package projectMyPage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBPoolUtil {
	public static Connection makeConnection() {

		ConnectionPool pool = ConnectionPool.getInstance();

		Connection con = null;
		try {
			con = pool.getConnection();
			System.out.println("데이타베이스 접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이타베이스 연결 실패");
		}
		return con;
	}

	public static void dbReleaseClose(ResultSet rs,Statement stmt,Connection con) {
        try {
                if (rs != null) {
                    rs.close();
                }
        } catch (SQLException ex) {    }
        
        try {
                if (stmt != null) {
                    stmt.close();
                }
        } catch (SQLException ex) {}
        try {
                if (con != null) {
                    ConnectionPool pool = ConnectionPool.getInstance();
                    pool.releaseConnection(con);
                }
        } catch (Exception ex) {}
    }
	
	public static void dbReleaseClose(Statement stmt,Connection con) {
        
        try {
                if (stmt != null) {
                    stmt.close();
                }
        } catch (SQLException ex) {}
        try {
                if (con != null) {
                    ConnectionPool pool = ConnectionPool.getInstance();
                    pool.releaseConnection(con);
                }
        } catch (Exception ex) {}
    }
}
