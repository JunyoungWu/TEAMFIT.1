<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="projectMyPage.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>운동 삭제</title>
</head>
<body>
    <center>
        <h2>운동 삭제</h2>
				  <!-- 운동 리스트 테이블 -->
        <table border="1">
            <tr>
                <th>번호</th>
                <th>운동명</th>
                <th>장소</th>
                <th>날짜</th>
                <th>운동인원</th>
                <th>가격</th>
            </tr>
            <%
                ExerciseDAO dao = ExerciseDAO.getInstance();
                List<ExerciseVO> exerciseList = dao.getAllExercises();
                for (ExerciseVO vo : exerciseList) {
            %>
            <tr>
                <td><%= vo.getE_no() %></td>
                <td><%= vo.getE_name() %></td>
                <td><%= vo.getE_location() %></td>
                <td><%= vo.getE_date() %></td>
                <td><%= vo.getE_memnum() %></td>
                <td><%= vo.getE_price() %></td>
            </tr>
            <%
                }
            %>
        </table>
        <br>
        <!-- 운동 삭제 -->
        <form action="deleteExerciseProc.jsp" method="post">
            <label for="e_no">삭제할 운동 번호 (e_no):</label>
            <input type="text" id="e_no" name="e_no" required>
            <input type="submit" value="삭제">
        </form>

        <h2>운동 목록</h2>

      
    </center>
</body>
</html>
