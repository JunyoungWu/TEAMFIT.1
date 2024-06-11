package projectMyPage;
import java.sql.*;
import javax.sql.*;
import java.util.*;
import jdbc.DBPoolUtil;
import javax.naming.*;
public class Exercise_ApplicationDAO {
	private static Exercise_ApplicationDAO instance = null;// 멤버필드
	
	public static Exercise_ApplicationDAO getInstance() {// 메소드
		if (instance == null) {
			synchronized (Exercise_ApplicationDAO.class) {
				instance = new Exercise_ApplicationDAO();
			}
		}
		return instance;
	}
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/myOracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.err.println("Connection 생성실패");
		}
		return conn;
	}
	
	 public boolean insertApplication(Exercise_ApplicationVO vo) {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        boolean result = false;

	        try {
	            conn = getConnection();
	            String sql = "INSERT INTO EXERCISE_APPLICATION (APNUMBER, E_NO, ID) VALUES (exercise_application_seq.NEXTVAL, ?, ?)";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, vo.getE_no());
	            pstmt.setString(2, vo.getId());
	            int rows = pstmt.executeUpdate();

	            if (rows > 0) {
	                result = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
					conn.close();
					  pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          
	        }

	        return result;
	    }
	 public boolean deleteApplication(String userId, int e_no) {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        boolean result = false;

	        try {
	            conn = getConnection();
	            String sql = "DELETE FROM EXERCISE_APPLICATION WHERE ID = ? AND E_NO = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, userId);
	            pstmt.setInt(2, e_no);
	            int rows = pstmt.executeUpdate();

	            if (rows > 0) {
	                result = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	try {
					conn.close();
					  pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	        }

	        return result;
	    }
	 
	
}
