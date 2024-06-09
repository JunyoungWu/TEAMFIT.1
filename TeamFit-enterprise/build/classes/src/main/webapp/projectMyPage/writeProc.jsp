<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


 <%@ page import="projectMyPage.*, java.util.*"%>
 <%@ page import = "java.sql.Timestamp" %>
 <% request.setCharacterEncoding("UTF-8");%>
 <jsp:useBean id="article" scope="page" class="projectMyPage.BoardVO">
   <jsp:setProperty name="article" property="*"/>
 </jsp:useBean>
 <%
    article.setRegdate(new Timestamp(System.currentTimeMillis()) );
    article.setIp(request.getRemoteAddr());
    BoardDAO dbPro = BoardDAO.getInstance();
    dbPro.insertArticle(article);
    response.sendRedirect("list.jsp");
 %>