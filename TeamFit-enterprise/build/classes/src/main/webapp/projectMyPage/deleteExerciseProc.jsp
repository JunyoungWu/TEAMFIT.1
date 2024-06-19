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
  	<script type="text/javascript">
			alert("운동 삭제 완료");
			window.location.href = "index.jsp";
		</script> 
  
</body>
</html>
