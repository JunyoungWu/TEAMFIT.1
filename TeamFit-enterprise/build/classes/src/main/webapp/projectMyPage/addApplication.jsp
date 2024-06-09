<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="projectMyPage.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운동 신청</title>
</head>
<body>
    <h1>운동 신청 메뉴</h1>
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
    <!-- 유저 운동 신청 양식 -->
    <form action="addApplicationProc.jsp" method="post">
        <label for="e_no">신청할 운동 번호 (e_no):</label>
        <input type="text" id="e_no" name="e_no" required>
        <input type="submit" value="신청">
    </form>
</body>
</html>
