<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ page import="projectMyPage.CommentsDAO"%>
<%@ page import="projectMyPage.CommentsVO"%>
<%@ page import="projectMyPage.BoardVO"%>
 <% CommentsDAO dao = CommentsDAO.getInstance(); %>
  <jsp:useBean id="vo" class="projectMyPage.CommentsVO" />
  <jsp:useBean id="bvo" class="projectMyPage.BoardVO" />
 <jsp:setProperty name="vo" property="*" />
  <% 
boolean flag = dao.deleteComment(vo.getComNum());
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
System.out.println("proc num 값 : " + num);

if (flag == true) {
	System.out.println("성공");
    // 삭제 성공 시 원래 보고 있던 content 페이지로 redirect
    response.sendRedirect("content.jsp?num=" + num + "&pageNum=" + pageNum);
    } 
	else {
    // 삭제 실패 시 메시지를 출력하거나 필요한 처리를 추가할 수 있습니다.
    System.out.println("실패");
    out.println("<b>다시 입력하여 주십시오.</b><br/>");
}
%>

 </center>
</body>
</html>