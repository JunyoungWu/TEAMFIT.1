package tf.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import oracle.jdbc.OracleTypes;
import tf.controller.DBUtil;
import tf.model.ExerciseVO;

public class ExerciseDAO {
	
	public void getExerciseTotalList() {
		 Connection con = null;
	        CallableStatement cstmt = null;
	        ResultSet rs = null;
	        try {
	            con = DBUtil.makeConnections(); // 적절한 DB 연결 메소드를 사용하세요
	            cstmt = con.prepareCall("{call PRINT_EXERCISE_LIST(?)}");
	            cstmt.registerOutParameter(1, OracleTypes.CURSOR); // Oracle JDBC 드라이버 사용

	            cstmt.execute();

	            rs = (ResultSet) cstmt.getObject(1);
	            while (rs.next()) {
	                // Exercise 테이블의 각 열을 출력합니다.
	                // 예시로 모든 열을 출력합니다. 실제로는 필요한 열만 출력하도록 수정할 수 있습니다.
	                int eNo = rs.getInt("e_no");
	                String eClassCode = rs.getString("e_classCode");
	                String eName = rs.getString("e_name");
	                String eLocation = rs.getString("e_location");
	                String eTeacherName = rs.getString("e_teacherName");
	                int ePrice = rs.getInt("e_price");

	                System.out.println("운동 코드: " + eNo);
	                System.out.println("운동 클래스 코드: " + eClassCode);
	                System.out.println("운동 이름: " + eName);
	                System.out.println("운동 장소: " + eLocation);
	                System.out.println("강사 이름: " + eTeacherName);
	                System.out.println("신청 비용: " + ePrice);
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

	public void setExerciseApply(ExerciseVO eVo) {
		String sql = "{call ADD_EXERCISE(?, ?, ?, ?, ?, ?, ?)}";
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DBUtil.makeConnections(); // 적절한 DB 연결 메소드를 사용하세요
            cstmt = con.prepareCall(sql);
            cstmt.setString(1, eVo.getE_classCode());
            cstmt.setString(2, eVo.getE_name());
            cstmt.setString(3, eVo.getE_location());
            java.util.Date utilDate = eVo.getE_date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            cstmt.setDate(4, sqlDate);
            cstmt.setInt(5, eVo.getE_memNum());
            cstmt.setString(6, eVo.getE_teacherName());
            cstmt.setInt(7, eVo.getE_price());
            
            cstmt.execute();
            
            System.out.println(eVo.getE_name() + " 운동 등록 완료.");

        } catch (SQLException e) {
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

    public void deleteExercise(String e_classcode) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DBUtil.makeConnections(); 
            cstmt = con.prepareCall("call DELETE_EXERCISE_BY_CLASSCODE(?)");
            cstmt.setString(1, e_classcode);

            cstmt.execute();

            System.out.println("운동 삭제 완료");

        } catch (SQLException e) {
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

}
