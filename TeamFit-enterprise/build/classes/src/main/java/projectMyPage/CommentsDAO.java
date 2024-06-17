package projectMyPage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentsDAO {
    private static CommentsDAO instance = new CommentsDAO();

    public static CommentsDAO getInstance() {
        return instance;
    }

    public CommentsDAO() {}
    
    public boolean deleteComment(int comNum) throws SQLException {
        boolean flag = false;
    	ConnectionPool cp = ConnectionPool.getInstance();
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM comments WHERE com_num = ?";

        try {
            conn = cp.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, comNum);
           int a = pstmt.executeUpdate();
            System.out.println("a값" + a);
            if( a==1) {
            	flag = true;
            }
        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) cp.releaseConnection(conn);
        }
        return flag;
    }
    
    // 댓글 추가
    public boolean insertComment(CommentsVO comment) throws SQLException {
    	boolean flag = false;
    	System.out.println("메서드 진입 1");
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO comments (com_num, com_writer, num, com_content, regdate) VALUES (comments_seq.NEXTVAL, '강사', ?, ?, SYSTIMESTAMP)";

        try {
        	System.out.println("메서드 진입 2");
        	System.out.println("comment.getComWriter()"+comment.getComWriter());
        	System.out.println("comment.getComContent()"+comment.getComContent());
        	
            conn = cp.getConnection();
            pstmt = conn.prepareStatement(sql);
           
            pstmt.setInt(1, comment.getNum());
            pstmt.setString(2, comment.getComContent());
            System.out.println("메서드 진입 2.5");
      
          	
          	if(pstmt.executeUpdate()==1) {
          		flag = true;
          	}
            System.out.println("메서드 진입 3");
        } finally {
        	System.out.println("메서드 진입 4");
            if (pstmt != null) {
            	System.out.println("메서드 진입 2");
            	pstmt.close();
            }
            if (conn != null) {
            	cp.releaseConnection(conn);
            }
        }
        return  flag;
    }

    // 특정 글의 댓글 리스트 가져오기
    public List<CommentsVO> getComments(int num) throws SQLException {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<CommentsVO> commentList = new ArrayList<>();
        String sql = "SELECT * FROM comments WHERE num = ? ORDER BY regdate ASC";

        try {
            conn = cp.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();

            while (rs.next()) {
            	CommentsVO comment = new CommentsVO();
                comment.setComNum(rs.getInt("com_num"));
                comment.setComWriter(rs.getString("com_writer"));
                comment.setNum(rs.getInt("num"));
                comment.setComContent(rs.getString("com_content"));
                comment.setRegdate(rs.getTimestamp("regdate"));
                commentList.add(comment);
            }
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) cp.releaseConnection(conn);
        }
        return commentList;
    }
}
