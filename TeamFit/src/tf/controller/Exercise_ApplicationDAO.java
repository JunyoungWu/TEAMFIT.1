package tf.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import tf.model.Exercise_ApplicationVO;

public class Exercise_ApplicationDAO {

    public void addExerciseApplication(int userCode, String eClassCode) {
        String sql = "{call ADD_EXERCISE_APPLICATION(?, ?)}";
        Connection con = null;
        CallableStatement cstmt = null;

        try {
            con = DBUtil.makeConnections();
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, userCode);
            cstmt.setString(2, eClassCode);

            cstmt.execute();
            System.out.println("Exercise Application이 추가되었습니다.");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (cstmt != null)
                    cstmt.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setDeleteExerciseApplication(int userCode, String eClassCode) {
        String sql = "{call DELETE_EXERCISE_APPLICATION(?, ?)}";
        Connection con = null;
        CallableStatement cstmt = null;

        try {
            con = DBUtil.makeConnections();
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, userCode);
            cstmt.setString(2, eClassCode);

            cstmt.execute();
            System.out.println("Exercise Application이 삭제되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cstmt != null)
                    cstmt.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setPrintUserExerciseList(int userCode) {
    	System.out.println("유저코드 : "+ userCode);
        String sql = "{call PRINT_USER_EXERCISE_LIST(?,?)}";
        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Exercise_ApplicationVO eaVo= new Exercise_ApplicationVO();

        try {
            con = DBUtil.makeConnections();
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, userCode);
            cstmt.registerOutParameter(2, Types.INTEGER);
            cstmt.execute();
            int number = cstmt.getInt(2);
            System.out.println("number의 값 : "+number);
            eaVo.setE_no(rs.getInt("e_no"));
            eaVo.setApplication_id(rs.getInt("application_id"));
            eaVo.setUser_code(rs.getInt("user_code"));
            System.out.println(eaVo.toString());
           int i = cstmt.executeUpdate();
           if (i == 1) {
				System.out.println( " 운동 출력 완료.");

			} else {
				System.out.println("운동 출력 실패");
			}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cstmt != null)
                	cstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
