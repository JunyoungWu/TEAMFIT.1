package tf.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tf.model.T_UserVO;

public class T_UserDAO {
    
	public boolean setRegisterUser(String userID, String password, String name, String phoneNumber) {
	    String sql = "{call REGISTER_USER(?, ?, ?, ?)}";
	    Connection con = null;
	    CallableStatement cstmt = null;
	    try {
	        con = DBUtil.makeConnections(); // 적절한 DB 연결 메소드를 사용하세요
	        cstmt = con.prepareCall(sql);
	        cstmt.setString(1, name);
	        cstmt.setString(2, phoneNumber);
	        cstmt.setString(3, userID);
	        cstmt.setString(4, password);
	        
	        cstmt.execute();
	        System.out.println("가입 성공");
	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (cstmt != null) cstmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public void setAddUserTeacher (int userCode,String teacherName) {
		String sql = "CALL ADD_USER_TEACHER (?,?)";
		Connection con = null;
	    CallableStatement cstmt = null;
		 try {	
		        con = DBUtil.makeConnections(); // 적절한 DB 연결 메소드를 사용하세요
		        cstmt = con.prepareCall(sql);
		        cstmt.setInt(1, userCode);
		        cstmt.setString(2, teacherName);
		      
		        
		        cstmt.execute();
		        System.out.println("정보가 성공적으로 변경되었습니다.");
		       
		    }catch (SQLException e) {
		        e.printStackTrace();
		       
		    } finally {
		        try {
		            if (cstmt != null) cstmt.close();
		            if (con != null) con.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		
	}

	public boolean updateUserInfo(int userCode, String newPhoneNumber, String newPassword) {
	    String sql = "{call UPDATE_USER_INFO(?, ?, ?)}";
	    Connection con = null;
	    CallableStatement cstmt = null;
	    try {
	        con = DBUtil.makeConnections(); // 적절한 DB 연결 메소드를 사용하세요
	        cstmt = con.prepareCall(sql);
	        cstmt.setInt(1, userCode);
	        cstmt.setString(2, newPhoneNumber);
	        cstmt.setString(3, newPassword);
	        
	        cstmt.execute();
	        System.out.println("정보가 성공적으로 변경되었습니다.");
	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (cstmt != null) cstmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


	public void setUserData(String userID, String password) {
	    String sql = "SELECT * FROM T_USER WHERE t_id = ? AND t_password = ?";
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    T_UserVO user = null;

	    try {
	        con = DBUtil.makeConnections();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, userID);
	        pstmt.setString(2, password);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            user = new T_UserVO();
	            user.setT_user_code(rs.getInt("t_user_code"));
	            user.setT_name(rs.getString("t_name"));
	            user.setT_pnum(rs.getString("t_pnum"));
	            user.setT_id(rs.getString("t_id"));
	            user.setT_password(rs.getString("t_password"));
	            user.setT_teacherName(rs.getString("t_teacherName"));
	            System.out.println(user.toString());
	        } else {
	            System.out.println("유저정보 출력에 오류가 발생하였습니다.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	}
	
	public T_UserVO setLoginUser(String userID, String password) {
	    String sql = "SELECT * FROM T_USER WHERE t_id = ? AND t_password = ?";
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    T_UserVO user = null;

	    try {
	        con = DBUtil.makeConnections();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, userID);
	        pstmt.setString(2, password);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            user = new T_UserVO();
	            user.setT_user_code(rs.getInt("t_user_code"));
	            user.setT_name(rs.getString("t_name"));
	            user.setT_pnum(rs.getString("t_pnum"));
	            user.setT_id(rs.getString("t_id"));
	            user.setT_password(rs.getString("t_password"));
	            user.setT_teacherName(rs.getString("t_teacherName"));
	            System.out.println("로그인 성공: " + user.getT_name() + " 님");
	        } else {
	            System.out.println("로그인 실패: 아이디 또는 비밀번호가 일치하지 않습니다.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return user;
	}

	

	
	

}
