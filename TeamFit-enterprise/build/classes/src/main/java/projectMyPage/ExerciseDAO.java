package projectMyPage;

import java.sql.*;
import javax.sql.*;
import java.util.*;
import jdbc.DBPoolUtil;

import javax.naming.*;

public class ExerciseDAO {
	private static ExerciseDAO instance = null;// 멤버필드
	
	public static ExerciseDAO getInstance() {// 메소드
		if (instance == null) {
			synchronized (ExerciseDAO.class) {
				instance = new ExerciseDAO();
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
	public boolean exerciseInsert(ExerciseVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = getConnection();
			
			
			String strQuery = "insert into Exercise values(exercise_seq.nextval,?,?,?,?,?)";
			pstmt = conn.prepareStatement(strQuery);
		
			pstmt.setString(1, vo.getE_name());
			pstmt.setString(2, vo.getE_location());
			pstmt.setString(3, vo.getE_date());
			pstmt.setInt(4, Integer.parseInt(vo.getE_memnum()));
			pstmt.setInt(5, Integer.parseInt(vo.getE_price()));
			System.out.println(vo.toString());
			int count = pstmt.executeUpdate();
			if (count > 0)
				flag = true;
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException sqle1) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle2) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle3) {
				}
		}
		return flag;
	}
	
	public boolean deleteExercise(int e_no) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    boolean flag = false;

	    try {
	        conn = getConnection();
	        String query = "DELETE FROM EXERCISE WHERE E_NO = ?";
	        pstmt = conn.prepareStatement(query);
	        pstmt.setInt(1, e_no);

	        int count = pstmt.executeUpdate();
	        if (count > 0) {
	            flag = true;
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (pstmt != null) try { pstmt.close(); } catch (SQLException sqle) {}
	        if (conn != null) try { conn.close(); } catch (SQLException sqle) {}
	    }

	    return flag;
	}
	 public List<ExerciseVO> getExercisesByUserId(String userId) {
	        List<ExerciseVO> list = new ArrayList<>();
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        try {
	            conn = getConnection();
	            String sql = "SELECT e.* FROM EXERCISE e JOIN EXERCISE_APPLICATION ea ON e.E_NO = ea.E_NO WHERE ea.ID = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, userId);
	            rs = pstmt.executeQuery();

	            while (rs.next()) {
	                ExerciseVO vo = new ExerciseVO();
	                vo.setE_no(rs.getInt("E_NO"));
	                vo.setE_name(rs.getString("E_NAME"));
	                vo.setE_location(rs.getString("E_LOCATION"));
	                vo.setE_date(rs.getString("E_DATE"));
	                vo.setE_memnum(rs.getString("E_MEMNUM"));
	                vo.setE_price(rs.getString("E_PRICE"));
	                list.add(vo);
	            }
	        } catch (Exception e) {
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

	        return list;
	    }
	
	public List<ExerciseVO> getAllExercises() {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<ExerciseVO> list = new ArrayList<>();
	    try {
	        conn = getConnection();
	        String query = "SELECT * FROM EXERCISE";
	        pstmt = conn.prepareStatement(query);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            ExerciseVO vo = new ExerciseVO();
	            vo.setE_no(rs.getInt("E_NO"));
	            vo.setE_name(rs.getString("E_NAME"));
	            vo.setE_location(rs.getString("E_LOCATION"));
	            vo.setE_date(rs.getString("E_DATE"));
	            vo.setE_memnum(rs.getString("E_MEMNUM"));
	            vo.setE_price(rs.getString("E_PRICE"));
	            list.add(vo);
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (rs != null) try { rs.close(); } catch (SQLException sqle1) {}
	        if (pstmt != null) try { pstmt.close(); } catch (SQLException sqle2) {}
	        if (conn != null) try { conn.close(); } catch (SQLException sqle3) {}
	    }
	    return list;
	}

	
	public int deleteExercise(int e_no, String e_name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbPass = "";// 데이터베이스에 실제 저장된 패스워드
		int result = -1;// 결과치
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select e_no from exercise where e_no = ? ");
			pstmt.setInt(1, e_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbPass = rs.getString("e_name");
				if (dbPass.equals(e_name)) {// true - 본인 확인
					pstmt = conn.prepareStatement("delete from student where id = ?");
					pstmt.setInt(1, e_no);
					pstmt.executeUpdate();
					result = 1;// 회원탈퇴 성공
				} else { // 본인확인 실패 - 비밀번호 오류
					result = 0;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException sqle1) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle2) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle3) {
				}
		}
		return result;
	}
	public ExerciseVO getExercise(int e_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ExerciseVO vo = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from exercise where e_no = ?");
			pstmt.setInt(1, e_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {// 해당 아이디에 대한 회원이 존재
				vo = new ExerciseVO();
				vo.setE_no(rs.getInt("e_no"));
				vo.setE_name(rs.getString("e_name"));
				vo.setE_location(rs.getString("E_LOCATION"));
				vo.setE_date(rs.getString("E_DATE"));
				vo.setE_memnum(rs.getString("E_MEMNUM"));
				vo.setE_price(rs.getString("E_PRICE"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException sqle1) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle2) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle3) {
				}
		}
		return vo;
	}
}
