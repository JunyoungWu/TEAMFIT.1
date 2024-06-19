<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="projectMyPage.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
 body {
        
        background-color: #1473d3;
    }

 

  table {
        width: 60%;
       border-collapse: collapse;
        margin: 0 auto;
        background-color: #f9f9f9;
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

td {
        padding: 10px;
    } 

td[colspan="2"] {
        background-color: #569ee6;
        color: #fff;
        font-weight: bold;
        border-radius: 10px 10px 0 0;
    }



input[type="submit"] {
        width: 30%;
        padding: 10px;
        background-color: #1473d3;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }
input[type="text"]{
	width: 30%;
	height: 50px;
	border: none;
        border-radius: 5px;
           font-size: 16px;
}
 input[type="submit"]:hover {
        background-color: #105a9d;
    } 
</style>
<meta charset="UTF-8">
<title>운동 신청</title>
</head>
<body>
    <h1>운동 신청 메뉴</h1>
    <table border="1"; >
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
    <form action="addApplicationProc.jsp" method="post"><br>
        <label for="e_no">신청할 운동의 번호를 입력해주세요</label><br><br>
        <input  placeholder="운동번호" type="text" id="e_no" name="e_no" required>
        <br><br>
        <input type="submit" value="신청">
    </form>
    <br>
</body>
</html>
