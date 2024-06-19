<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="projectMyPage.*"%>
<%
 StudentDAO dao = StudentDAO.getInstance();
 %>
<html>
<head>
<title>회원탈퇴</title>
</head>
<%
String id = (String) session.getAttribute("loginID");
String pass = request.getParameter("pass");
int check = dao.deleteMember(id, pass);
if (check == 1) {
	session.invalidate();
%>
<meta http-equiv="Refresh" content="3;url=index.jsp">
<body>
	<script type="text/javascript">
			alert("운동 삭제 완료");
			window.location.href = "index.jsp";
		</script> 
	<%
	} else {
	%>
	<script>
		alert("비밀번호가 맞지 않습니다");
		history.go(-1);
	</script>
	<%
	}
	%>
</body>
</html>