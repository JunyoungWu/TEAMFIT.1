<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="projectMyPage.*"%>
<%
    // DAO 인스턴스 가져오기
    ExerciseDAO dao = ExerciseDAO.getInstance();

    // 삭제할 운동 번호 가져오기
    String eNoStr = request.getParameter("e_no");
    int e_no = Integer.parseInt(eNoStr);

    // 운동 삭제
    boolean flag = dao.deleteExercise(e_no);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>운동 삭제 결과</title>
    <meta http-equiv="Refresh" content="3;url=index.jsp">
</head>
<body>
    <center>
        <%
            if (flag) {
        %>
            <font size="5">운동 정보가 삭제되었습니다.<br>3초 후에 메인 페이지로 이동합니다.</font>
        <%
            } else {
        %>
            <font size="5">운동 정보 삭제에 실패했습니다.<br>3초 후에 다시 시도해 주세요.</font>
        <%
            }
        %>
    </center>
</body>
</html>
