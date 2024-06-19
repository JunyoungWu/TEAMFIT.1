<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ page import="projectMyPage.CommentsDAO"%>
<%@ page import="projectMyPage.CommentsVO"%>

 <% CommentsDAO dao = CommentsDAO.getInstance(); %>
  <jsp:useBean id="vo" class="projectMyPage.CommentsVO" />
 <jsp:setProperty name="vo" property="*" />
  <% 
boolean flag = dao.insertComment(vo);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <center>
 <%
 String pageNum = request.getParameter("pageNum");
 String num = request.getParameter("num");
 if(flag){
%>	

	    
 <% 
 }else{
  out.println("<b>다시 입력하여 주십시오.</b><br/>");

 }
 %>
 </center>
</body>
</html>