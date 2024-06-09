<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, projectMyPage.*" %>
<%
    ExerciseDAO dao = ExerciseDAO.getInstance();
    List<ExerciseVO> exerciseList = dao.getAllExercises();
%>

<html>
<head>
    <title>운동 목록</title>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <center>
        <h2>운동 목록</h2>
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
    </center>
</body>
</html>
