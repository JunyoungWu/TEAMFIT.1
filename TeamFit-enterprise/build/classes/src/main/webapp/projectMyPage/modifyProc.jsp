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
 <font size="5" face="바탕체">
 입력하신 내용대로 <b>회원정보가 수정 되었습니다.</b><br></br>
 3초후에 메인 페이지로 이동합니다</font>
 </center>
 </body>
 </html>