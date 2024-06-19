<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="projectMyPage.*, java.util.*"%>
<%
// DAO 인스턴스 가져오기
Exercise_ApplicationDAO dao = Exercise_ApplicationDAO.getInstance();

// 세션에서 사용자 ID 가져오기 (로그인 구현이 되어 있고 세션에 사용자 ID가 저장되어 있다고 가정)
String userId = (String) session.getAttribute("loginID");
if (userId == null) {
	response.sendRedirect("login.jsp");
	return;
}

// 요청에서 운동 번호 가져오기
String[] eNos = request.getParameterValues("e_no");

boolean allDeleted = true;
if (eNos != null) {
	for (String eNoStr : eNos) {
		int e_no = Integer.parseInt(eNoStr);
		boolean flag = dao.deleteApplication(userId, e_no);
		if (!flag) {
	allDeleted = false;
		}
	}
} else {
	allDeleted = false;
}
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
		if (allDeleted) {
		%>
		<script type="text/javascript">
			alert("운동 삭제 완료");
			window.location.href = "index.jsp";
		</script>
		<%
		} else {
		%>
		<font size="5">운동 신청 삭제에 실패했습니다.<br>
		</font>
		<%
		}
		%>
	</center>
</body>
</html>
