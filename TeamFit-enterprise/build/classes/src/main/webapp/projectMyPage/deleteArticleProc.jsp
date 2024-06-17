<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="projectMyPage.*"%>
<%@ page import="java.sql.Timestamp"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%
int num = Integer.parseInt(request.getParameter("num").trim());
String pageNum = request.getParameter("pageNum");
String pass = request.getParameter("pass").trim(); // 비밀번호 트리밍 추가
BoardDAO dbPro = BoardDAO.getInstance();
int check = dbPro.deleteArticle(num, pass);
System.out.println("check의 값 : " + check);
if (check == 1) {
%>
<meta http-equiv="Refresh" content="0;url=list.jsp?pageNum=<%=pageNum%>">
<%
} else {
    System.out.println("비밀번호 불일치: 제공된 비밀번호: " + pass); // 디버깅 출력 추가
%>
<script language="JavaScript">
<!--
    alert("비밀번호가 맞지 않습니다");
    history.go(-1);
-->
</script>
<%
}
%>
