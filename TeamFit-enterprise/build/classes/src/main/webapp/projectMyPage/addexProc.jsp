 <%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" import="projectMyPage.*" %>
 <% request.setCharacterEncoding("utf-8");%>
 <% ExerciseDAO dao = ExerciseDAO.getInstance(); %>
 <jsp:useBean id="vo" class="projectMyPage.ExerciseVO" />
 <jsp:setProperty name="vo" property="*" />
 <% 
	boolean flag = dao.exerciseInsert(vo);
 %>
 <html>
 <head>
 <title>회원가입 확인</title></head>
 <link href="style.css" rel="stylesheet" type="text/css">
 <body bgcolor="#FFFFCC">
 <br></br>
 <center>
 <%
 if(flag){
	 
	 %>
	    <script type="text/javascript">
	        alert("운동 등록 완료");
	        window.location.href = "index.jsp";
	    </script>
	<%

 }else{
  out.println("<b>다시 입력하여 주십시오.</b><br/>");
  out.println("<a href=regForm.jsp>다시 가입</a>");
 }
 %>
 </center>
 </body>
 </html>