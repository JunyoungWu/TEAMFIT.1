<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="projectMyPage.*"%>
<%InstructorDAO dao = InstructorDAO.getInstance(); %>
<% String iid = request.getParameter("id");
 String ipass = request.getParameter("pass");
 int check = dao.loginCheck(iid,ipass); 
%>     
 <%
 if(check == 1){//로그인 성공
session.setAttribute("loginID", iid);
session.setAttribute("check", "강사");
 response.sendRedirect("index.jsp");
 }else if(check == 0){//아이디는 있는데 비밀번호 오류
%>
 <script>
 alert("비밀번호가 틀렸습니다");
 history.go(-1);
 </script>
 <% } else{//아이디 자체가 존재하지 않는 경우
%>
 <script>
 alert("아이디가 존재하지 않습니다");
 history.go(-1);
 </script>
 <%} %>