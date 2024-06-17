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
