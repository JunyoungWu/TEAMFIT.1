package projectMyPage;

import java.sql.*;
import javax.sql.*;
import java.util.*;
import jdbc.DBPoolUtil;

import javax.naming.*;

public class StudentDAO {
	private static StudentDAO instance = null;// 멤버필드

	private StudentDAO() {
	}// 생성자

	public static StudentDAO getInstance() {// 메소드
		if (instance == null) {
			synchronized (StudentDAO.class) {
				instance = new StudentDAO();
			}
		}
		return instance;
	}

	private Connection getConnection() {
	    Connection conn = null;
	
	    try {
	        Context init = new InitialContext();
	        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/myOracle");
	        System.out.println("연결성공");
	        conn = ds.getConnection();
	        
	    } catch (Exception e) {
	        e.printStackTrace(); // 구체적인 오류 메시지 출력
	        System.err.println("Connection 생성실패: " + e.getMessage());
	    }
	    return conn;
	}


	public int loginCheck(String id, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = -1;
		try {
			conn = getConnection();
			if(conn!=null) {
			
			}else {
		
			}
			String strQuery = "select pass from student where id = ?";
			pstmt = conn.prepareStatement(strQuery);
			pstmt.setString(1, id);
		
			rs = pstmt.executeQuery();
			if(rs!=null) {
		
			}else {
			
			}
			boolean hasNext = rs.next(); // 결과 행의 존재 여부를 확인
		
			if (hasNext) { // 결과 행이 존재하는 경우에만 진입
			
			    String dbPass = rs.getString("pass");
			 
			    if (pass.equals(dbPass))
			        check = 1;
			    else
			        check = 0;
			} 
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
		
		return check;
		
	}

	public boolean idCheck(String id) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBPoolUtil.makeConnection();
			pstmt = conn.prepareStatement("select * from student where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				result = false;
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			DBPoolUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return result;
	}

	public boolean memberInsert(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = getConnection();
			String strQuery = "insert into student values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(strQuery);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone1());
			pstmt.setString(5, vo.getPhone2());
			pstmt.setString(6, vo.getPhone3());
			pstmt.setString(7, vo.getEmail());
			pstmt.setString(8, vo.getZipcode());
			pstmt.setString(9, vo.getAddress1());
			pstmt.setString(10, vo.getAddress2());
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

	public Vector<ZipCodeVO> zipcodeRead(String dong) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<ZipCodeVO> vecList = new Vector<ZipCodeVO>();
		try {
			conn = getConnection();
			// String strQuery = String.format("select * from zipcode where dong like '%s
			// %'", dong);
			String strQuery = "select * from zipcode where dong like '" + dong + "%'";
			pstmt = conn.prepareStatement(strQuery);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ZipCodeVO tempZipcode = new ZipCodeVO();
				tempZipcode.setZipcode(rs.getString("zipcode"));
				tempZipcode.setSido(rs.getString("sido"));
				tempZipcode.setGugun(rs.getString("gugun"));
				tempZipcode.setDong(rs.getString("dong"));
				tempZipcode.setBunji(rs.getString("bunji"));
				vecList.addElement(tempZipcode);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
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
		return vecList;
	}

	public StudentVO getMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO vo = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from student where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {// 해당 아이디에 대한 회원이 존재
				vo = new StudentVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone1(rs.getString("phone1"));
				vo.setPhone2(rs.getString("phone2"));
				vo.setPhone3(rs.getString("phone3"));
				vo.setEmail(rs.getString("email"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress1(rs.getString("Address1"));
				vo.setAddress2(rs.getString("Address2"));
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
	
	public int deleteMemberByAdmin(String id) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    int result = -1; // 결과치
	    try {
	        conn = getConnection();
	        pstmt = conn.prepareStatement("delete from student where id = ?");
	        pstmt.setString(1, id);
	        pstmt.executeUpdate();
	        result = 1; // 회원 탈퇴 성공
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        // 자원 해제
	        try {
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return result;
	}

	public int deleteMember(String id, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbPass = "";// 데이터베이스에 실제 저장된 패스워드
		int result = -1;// 결과치
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select pass from student where id = ? ");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbPass = rs.getString("pass");
				if (dbPass.equals(pass)) {// true - 본인 확인
					pstmt = conn.prepareStatement("delete from student where id = ?");
					pstmt.setString(1, id);
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

	public int updateMember(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = -1;
		try {
			conn = DBPoolUtil.makeConnection();
			pstmt = conn.prepareStatement(
					"update student set pass=?, phone1=?, phone2=?, phone3=?, email=?, zipcode=?,address1=?, address2=? where id=?");
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getPhone1());
			pstmt.setString(3, vo.getPhone2());
			pstmt.setString(4, vo.getPhone3());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getZipcode());
			pstmt.setString(7, vo.getAddress1());
			pstmt.setString(8, vo.getAddress2());
			pstmt.setString(9, vo.getId());
			count = pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBPoolUtil.dbReleaseClose(pstmt, conn);

		}
		return count;
	}
	
	public List<StudentVO> getAllMembers() {
		Connection conn = null;
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<StudentVO> memberList = new ArrayList<>();
        try {
        	conn = DBPoolUtil.makeConnection();
            String sql = "SELECT * FROM student";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                StudentVO member = new StudentVO();
                member.setId(rs.getString("id"));
                member.setPass(rs.getString("pass"));
                member.setName(rs.getString("name"));
                member.setPhone1(rs.getString("phone1"));
                member.setPhone2(rs.getString("phone2"));
                member.setPhone3(rs.getString("phone3"));
                member.setEmail(rs.getString("email"));
                member.setZipcode(rs.getString("zipcode"));
                member.setAddress1(rs.getString("address1"));
                member.setAddress2(rs.getString("address2"));
                memberList.add(member);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 리소스 해제
        	DBPoolUtil.dbReleaseClose(rs, pstmt, conn);
        }
        return memberList;
    }
}