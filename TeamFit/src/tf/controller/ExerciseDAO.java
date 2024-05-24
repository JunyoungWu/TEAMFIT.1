package tf.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import tf.controller.DBUtil;
import tf.model.ExerciseVO;

public class ExerciseDAO {
	
	public void getExerciseTotalList() {
		String sql = "select * from exercise order by e_classCode";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ExerciseVO eVo = null;
		try {
			con = DBUtil.makeConnections();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("일련번호\t운동번호\t운동명\t운동장소\t운동날짜\t\t인원수\t강사명\t가격");
			while (rs.next()) {
				eVo = new ExerciseVO();
				eVo.setE_no(rs.getInt("e_no"));
				eVo.setE_classCode(rs.getString("e_classCode"));
				eVo.setE_name(rs.getString("e_name"));
				eVo.setE_location(rs.getString("e_location"));
				eVo.setE_date(rs.getDate("e_date")); // e_date에 대한 날짜 값 설정
				eVo.setE_memNum(rs.getInt("e_memNum"));
				eVo.setE_teacherName(rs.getString("e_teacherName"));
				eVo.setE_price(rs.getInt("e_price"));
				System.out.println(eVo.getE_no() + "\t" + eVo.getE_classCode() + "\t" + eVo.getE_name() + "\t"
						+ eVo.getE_location() + "\t" + eVo.getE_date() + "\t" + eVo.getE_memNum() + "\t"
						+ eVo.getE_teacherName() + "\t" + eVo.getE_price());

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void setExerciseApply(ExerciseVO eVo) {
		String sql = "insert into exercise(e_no,e_classCode, e_name, e_location, e_date, e_memNum, e_teacherName, e_price) values	(exercise_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.makeConnections(); //
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, eVo.getE_classCode());
			pstmt.setString(2, eVo.getE_name());
			pstmt.setString(3, eVo.getE_location());
			java.util.Date utilDate = eVo.getE_date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			pstmt.setDate(4, sqlDate);
			pstmt.setInt(5, eVo.getE_memNum());
			System.out.println(eVo.getE_teacherName());
			pstmt.setString(6, eVo.getE_teacherName());
			pstmt.setInt(7, eVo.getE_price());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println(eVo.getE_name() + " 운동 등록 완료.");

			} else {
				System.out.println("등록 실패");
			}

		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public void deleteExercise(int e_no) {
		
		String sql ="delete from exercise where e_no = ?"; 
		String sql1 = "DELETE FROM Exercise_Application WHERE e_no = ?";
		Connection con = null;
	    PreparedStatement pstmt = null;
	    Connection con1 = null;
	    PreparedStatement pstmt1 = null;

	    try {
	        con = DBUtil.makeConnections();
	        pstmt1 = con.prepareStatement(sql1);
	        pstmt1.setInt(1, e_no);
	        

	        int i = pstmt1.executeUpdate();
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
		
	
		try {
			
			con = DBUtil.makeConnections();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, e_no);
		
			
			int i = pstmt.executeUpdate();
			
			if (i > 0) {
				System.out.println("운동 삭제 완료");
				
			} else {
				System.out.println("운동 삭제 실패 ");
				
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
}
