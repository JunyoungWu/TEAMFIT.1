<%@ page contentType="text/html;charset=utf-8"%>
 <%@ page import ="projectMyPage.*"%>
 <% request.setCharacterEncoding("utf-8"); %>
 
 <%
 StudentDAO dao = StudentDAO.getInstance();
 %>

 <jsp:useBean id="vo" class="projectMyPage.StudentVO">
     <jsp:setProperty name="vo" property="*"/>
 </jsp:useBean>
 <%
 String loginID = (String)session.getAttribute("loginID");
 vo.setId(loginID);
 dao.updateMember(vo);
 %>
 <html>
 <head><title>Update Process</title></head>
 <meta http-equiv="Refresh" content="3;url=index.jsp">
 <body>
 <center>
  <script>
    alert("수정 완료.");
	window.location.href = "index.jsp";
    </script>
 </center>
 </body>
 </html>