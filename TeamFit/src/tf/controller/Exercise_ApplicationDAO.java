package tf.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tf.model.ExerciseVO;

public class Exercise_ApplicationDAO {
	
	 public void addExerciseApplication(int userCode, String eClassCode) {
	        String sql = "INSERT INTO Exercise_Application (application_id, user_code, e_classCode) VALUES (application_id_seq.nextval, ?, ?)";
	                   
	        Connection con = null;
			PreparedStatement pstmt = null;
			
			
				
			try {
				con = DBUtil.makeConnections();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, userCode);
	            pstmt.setString(2, eClassCode);
	            
	            int i = pstmt.executeUpdate();
	            if (i > 0) {
	                System.out.println("Exercise Application이 추가되었습니다.");
	            } else {
	                System.out.println("Exercise Application 추가에 실패하였습니다.");
	            }
			}catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	       
	      
	    }
	 
	 public void setDeleteExerciseApplication(int userCode, String eClassCode) {
		    String sql = "DELETE FROM Exercise_Application WHERE user_code = ? AND e_classCode = ?";
		    Connection con = null;
		    PreparedStatement pstmt = null;

		    try {
		        con = DBUtil.makeConnections();
		        pstmt = con.prepareStatement(sql);
		        pstmt.setInt(1, userCode);
		        pstmt.setString(2, eClassCode);

		        int i = pstmt.executeUpdate();
		        if (i > 0) {
		            System.out.println("Exercise Application이 삭제되었습니다.");
		        } else {
		            System.out.println("Exercise Application 삭제에 실패하였습니다.");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (pstmt != null)
		                pstmt.close();
		            if (con != null)
		                con.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}

	 public void setPrintUserExerciseList(int userCode) {
	        String sql = "SELECT ea.e_classCode, e.e_name, e.e_location, e.e_date, e.e_memNum, e.e_teacherName, e.e_price FROM Exercise_Application ea JOIN EXERCISE e ON ea.e_classCode = e.e_classCode WHERE ea.user_code = ?";
	        Connection con = null;
			PreparedStatement pstmt = null;

	        try 
	            
	        {	
	        	con = DBUtil.makeConnections();
	            pstmt = con.prepareStatement(sql);
	            pstmt.setInt(1, userCode);

	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                String eClassCode = rs.getString("e_classCode");
	                String eName = rs.getString("e_name");
	                String eLocation = rs.getString("e_location");
	                String eTeacher = rs.getString("e_teacherName");
	                int ePrice = rs.getInt("e_price");
	           	    System.out.println("내가 신청한 운동 리스트 ");
	           	    System.out.println();
	                System.out.println("운동 코드: " + eClassCode);
	                System.out.println("운동 이름: " + eName);
	                System.out.println("운동 장소: " + eLocation);
	                System.out.println("강사 이름: " + eTeacher);
	                System.out.println("신청 비용: " + ePrice);
	                // 필요한 정보들 출력
	                
	                System.out.println();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	
}
