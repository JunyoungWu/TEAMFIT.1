package tf.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tf.model.T_UserVO;

public class InstructorDAO {

    public boolean setCheckInstructor(T_UserVO user) {
        String sql = "SELECT * FROM INSTRUCTOR WHERE t_user_code = ?";
    	//String sql = "SELECT * FROM INSTRUCTOR";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean flag = false;

        try {
            con = DBUtil.makeConnections();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, user.getT_user_code());
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                System.out.println("강사로 등록되어 있습니다.");
                flag = true;
            } else {
                System.out.println("강사로 등록되어 있지 않습니다.");
                flag = false;
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
        return flag;
    }
}

