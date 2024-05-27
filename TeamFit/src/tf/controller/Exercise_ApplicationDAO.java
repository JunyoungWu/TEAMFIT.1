package tf.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jdbc.OracleTypes;
import tf.model.Exercise_ApplicationVO;

public class Exercise_ApplicationDAO {

    public void addExerciseApplication(int userCode, String eClassCode) {
        String sql = "call ADD_EXERCISE_APPLICATION(?, ?)";
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
    	  Connection con = null;
          CallableStatement cstmt = null;
          ResultSet rs = null;
          try {
              con = DBUtil.makeConnections(); // 적절한 DB 연결 메소드를 사용하세요
              cstmt = con.prepareCall("{call PRINT_USER_EXERCISE_LIST(?, ?)}");
              cstmt.setInt(1, userCode); // 사용자 코드 설정
              cstmt.registerOutParameter(2, OracleTypes.CURSOR); // Oracle JDBC 드라이버 사용

              cstmt.execute();

              rs = (ResultSet) cstmt.getObject(2);
              while (rs.next()) {
                  System.out.println("운동 코드: " + rs.getInt("e_no"));
                  System.out.println("운동 이름: " + rs.getString("e_name"));
                  System.out.println("운동 장소: " + rs.getString("e_location"));
                  System.out.println("강사 이름: " + rs.getString("e_teacherName"));
                  System.out.println("신청 비용: " + rs.getInt("e_price"));
                  System.out.println();
              }
          } catch (SQLException e) {
              e.printStackTrace();
          } finally {
              try {
                  if (rs != null) rs.close();
                  if (cstmt != null) cstmt.close();
                  if (con != null) con.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
      
    }
}
