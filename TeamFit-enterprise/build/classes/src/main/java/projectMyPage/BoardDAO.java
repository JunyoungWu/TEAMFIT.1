package projectMyPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	private static BoardDAO instance = null;

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		if (instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}
	
	

	// 이곳에 게시판 작업의 기능 메서드로 추가 할 예정.
	
	public BoardVO updateGetArticle(int num) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    BoardVO article = null;
	    try {
	 conn = ConnUtil.getConnection();
	 pstmt = conn.prepareStatement(
	 "select * from board where num = ?");
	 pstmt.setInt(1, num);
	 rs = pstmt.executeQuery();
	 if (rs.next()) {
	 article = new BoardVO();
	 article.setNum(rs.getInt("num"));
	 article.setWriter(rs.getString("writer"));
	 article.setEmail(rs.getString("email"));
	 article.setSubject(rs.getString("subject"));
	 article.setPass(rs.getString("pass"));
	 article.setRegdate(rs.getTimestamp("regdate"));
	 article.setReadcount(rs.getInt("readcount"));
	 article.setRef(rs.getInt("ref"));
	 article.setStep(rs.getInt("step"));
	 article.setDepth(rs.getInt("depth"));
	 article.setContent(rs.getString("content"));
	 article.setIp(rs.getString("ip"));
	 }
	    } catch (Exception ex) {
	 ex.printStackTrace();
	    } finally {
	 if (rs != null)try { rs.close();} catch (SQLException ex) {}
	 if (pstmt != null) try {pstmt.close(); } catch (SQLException ex) {}
	 if (conn != null) try { conn.close(); } catch (SQLException ex) {}
	    }
	    return article;
	 }
	 public int updateArticle(BoardVO article) {
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    String dbpasswd = "";
		    String sql = "";
		    int result = -1;//결과값
		    try {
		 conn = ConnUtil.getConnection();
		 pstmt = conn.prepareStatement(
		 "select pass from board where num = ?");
		 pstmt.setInt(1, article.getNum());
		 rs = pstmt.executeQuery();
		 if (rs.next()) {
		 dbpasswd = rs.getString("pass");//비밀번호 비교
		if (dbpasswd.equals(article.getPass())) {
		   sql = "update board set writer=?,email=?,subject=?";
		   sql += ",content=? where num=?";
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, article.getWriter());
		   pstmt.setString(2, article.getEmail());
		   pstmt.setString(3, article.getSubject());
		   pstmt.setString(4, article.getContent());
		   pstmt.setInt(5, article.getNum());
		   pstmt.executeUpdate();
		   result = 1;//수정성공
		} else {
		   result = 0;//수정실패
		}
		 }
		    } catch (Exception ex) {
		 ex.printStackTrace();
		    } finally {
		 if (rs != null) try { rs.close(); } catch (SQLException ex) {}
		 if (pstmt != null) try { pstmt.close();} catch (SQLException ex) {}
		 if (conn != null) try { conn.close(); } catch (SQLException ex) {}
		    }
		    return result;
		 }
	 
	 public int deleteArticle(int num, String pass) {
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    String dbpasswd = "";
		    int result = -1;

		    try {
		        conn = ConnUtil.getConnection();
		        pstmt = conn.prepareStatement("select pass from board where num = ?");
		        pstmt.setInt(1, num);
		        rs = pstmt.executeQuery();

		        if (rs.next()) {
		            dbpasswd = rs.getString("pass");
		            System.out.println("데이터베이스 비밀번호: " + dbpasswd); // 디버깅 출력 추가
		            System.out.println("제공된 비밀번호: " + pass); // 디버깅 출력 추가

		            if (dbpasswd.equals(pass)) {
		                pstmt = conn.prepareStatement("delete from board where num=?");
		                pstmt.setInt(1, num);
		                pstmt.executeUpdate();
		                result = 1; // 글 삭제 성공
		            } else {
		                result = 0; // 비밀번호 틀림
		            }
		        }
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    } finally {
		        if (rs != null) try { rs.close(); } catch (SQLException ex) {}
		        if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) {}
		        if (conn != null) try { conn.close(); } catch (SQLException ex) {}
		    }

		    System.out.println("result의 값 : " + result);
		    return result;
		}

	public void insertArticle(BoardVO article){
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    int num = article.getNum();
		    int ref = article.getRef();
		    int step = article.getStep();
		    int depth = article.getDepth();
		    int number = 0;
		    String sql = "";
		    try {
		 conn = ConnUtil.getConnection();
		 pstmt = conn.prepareStatement("select max(num) from board");
		 rs = pstmt.executeQuery();
		 if (rs.next()) number = rs.getInt(1) + 1;
		 else number = 1;
		 if (num != 0) {//답변글일경우
		    sql = 
		    "update board set step=step+1 where ref= ? and step> ?";
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, ref);
		    pstmt.setInt(2, step);
		    pstmt.executeUpdate();
		    step = step + 1;
		    depth = depth + 1;
		 } else {//새 글일 경우
		    ref = number;
		    step = 0;
		    depth = 0;
		 }// 쿼리를 작성
		sql = "insert into board(num, writer, email, subject, pass, regdate, ref, step, depth, content, ip) values(board_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
		 pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1, article.getWriter());
		 pstmt.setString(2, article.getEmail());
		 pstmt.setString(3, article.getSubject());
		 pstmt.setString(4, article.getPass());
		 pstmt.setTimestamp(5, article.getRegdate());
		 pstmt.setInt(6, ref);
		 pstmt.setInt(7, step);
		 pstmt.setInt(8, depth);
		 pstmt.setString(9, article.getContent());
		 pstmt.setString(10, article.getIp());
		 pstmt.executeUpdate();
		    } catch (Exception ex) {
		 ex.printStackTrace();
		    } finally {
		 if (rs != null) try { rs.close(); } catch (SQLException ex) {}
		 if (pstmt != null) try { pstmt.close(); } catch (SQLException ex) {}
		 if (conn != null) try { conn.close(); } catch (SQLException ex) {}
		    }
		 }

	public int getArticleCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}
	
	
	 public BoardVO getArticle(int num){
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    BoardVO article=null;
		    try {
		 conn = ConnUtil.getConnection();
		 pstmt = conn.prepareStatement(
		  "update board set readcount=readcount+1 where num = ?");
		 pstmt.setInt(1, num);
		 pstmt.executeUpdate();
		 pstmt = conn.prepareStatement(
		 "select * from board where num = ?");
		 pstmt.setInt(1, num);
		 rs = pstmt.executeQuery();
		 if (rs.next()) {
		 article = new BoardVO();
		 article.setNum(rs.getInt("num"));
		 article.setWriter(rs.getString("writer"));
		 article.setEmail(rs.getString("email"));
		 article.setSubject(rs.getString("subject"));
		 article.setPass(rs.getString("pass"));
		 article.setRegdate(rs.getTimestamp("regdate"));
		 article.setReadcount(rs.getInt("readcount"));
		 article.setRef(rs.getInt("ref"));
		 article.setStep(rs.getInt("step"));
		 article.setDepth(rs.getInt("depth"));
		 article.setContent(rs.getString("content"));
		 article.setIp(rs.getString("ip"));     
		}
		    } catch(Exception ex) {
		 ex.printStackTrace();
		    } finally {
		 if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		 if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		 if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		    }
		 return article;
		 }
	
	public List<BoardVO> getArticles(/* 수정<1> */) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> articleList = null;
		try {
			conn = ConnUtil.getConnection();
			/* <수정2> */
			pstmt = conn.prepareStatement("select * from board order by num desc");// 수정 <3>
			rs = pstmt.executeQuery();
			if (rs.next()) {
				articleList = new ArrayList<BoardVO>();// 수정<4>
				do {
					BoardVO article = new BoardVO();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					articleList.add(article);
				} while (rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return articleList;
	}
	
	public List<BoardVO> getArticleList( int start, int end) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> articleList = null;
		try {
			conn = ConnUtil.getConnection();
			/* <수정2> */
			pstmt = conn.prepareStatement(" select * from (select rownum rnum, num, writer, email, subject, pass,\r\n"+ " regdate, readcount, ref, step, depth, content, ip from (select * from board \r\n"	+ "order by ref desc, step asc)) where rnum>=? and rnum<=?");
			pstmt.setInt(1, start); 
		    pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				articleList = new ArrayList<BoardVO>(end-start+1);// 수정<4>
				do {
					BoardVO article = new BoardVO();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					articleList.add(article);
				} while (rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return articleList;
	}

}