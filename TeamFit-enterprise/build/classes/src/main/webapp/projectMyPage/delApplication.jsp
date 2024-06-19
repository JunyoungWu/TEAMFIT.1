<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="projectMyPage.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 운동 목록</title>
<script type="text/javascript">
    function checkAll(box) {
        var checkboxes = document.getElementsByName('e_no');
        for (var i = 0; i < checkboxes.length; i++) {
            checkboxes[i].checked = box.checked;
        }
    }
</script>
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
</head>
<body>
    <h1>내 운동 목록</h1>
    <form action="delApplicationProc.jsp" method="post">
        <table border="1">
            <tr>
                <th><input type="checkbox" onclick="checkAll(this)"></th>
                <th>번호</th>
                <th>운동명</th>
                <th>장소</th>
                <th>날짜</th>
                <th>운동인원</th>
                <th>가격</th>
            </tr>
            <%
                // 세션에서 사용자 ID 가져오기
                String userId = (String) session.getAttribute("loginID");
                if (userId == null) {
                    response.sendRedirect("login.jsp");
                    return;
                }

                ExerciseDAO dao = ExerciseDAO.getInstance();
                List<ExerciseVO> exerciseList = dao.getExercisesByUserId(userId);
                for (ExerciseVO vo : exerciseList) {
            %>
            <tr>
                <td><input type="checkbox" name="e_no" value="<%= vo.getE_no() %>"></td>
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
        <input type="submit" value="선택된 운동 삭제">
    </form>
</body>
</html>
