<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="color.jsp"%>
 <%
  int num = Integer.parseInt(request.getParameter("num").trim());
  String pageNum = request.getParameter("pageNum");
  String loginID = (String) session.getAttribute("loginID");
  String check = (String) session.getAttribute("check");
 %>
 <html>
 <head>
 <title>게시판</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/projectMyPage/css/style.css">
 <script language="JavaScript">      
<!--      
  function deleteSave(){
 if(document.delForm.pass.value==''){
 alert("비밀번호를 입력하십시요.");
 document.delForm.pass.focus();
 return false;
 }
 }    
// -->      
</script>
 </head>
 <body bgcolor="<%=bodyback_c%>">
 <header>
		<img onclick="location.href = 'index.jsp';" src="./image/TeamFit.png" style="width: 150px; height: 80px;" alt="" />
		<%System.out.println("체크 : "+check); %>
		<%
		if (loginID != null && ("강사".equals(check))) {
		%>
		<div class="mid">
            <a href="instMenu.jsp" >강사 메뉴</a>&nbsp;&nbsp;
           
            <a href="list.jsp" >문의 게시판</a>&nbsp;&nbsp;
           
        </div>
		<div class="right">
			<span><%=loginID%>님 환영합니다.</span> 
			<span><a href="modifyForm.jsp" >정보수정</a></span> 
			<span><a href="deleteForm.jsp" >회원탈퇴</a></span> 
			<span><a href="logout.jsp">로그아웃</a></span>
		</div>
		<%
		} else if (loginID != null && ("회원".equals(check))) {
		%>
			<div class="mid">
           
            <a href="addApplication.jsp" >운동 신청</a>&nbsp;&nbsp;
            <a href="delApplication.jsp"  >운동 삭제</a>&nbsp;&nbsp;
           <a href="list.jsp" >문의 게시판</a>&nbsp;&nbsp;
        </div>
        		<div class="right">
			<span><%=loginID%>님 환영합니다.</span> 
			<span><a href="modifyForm.jsp" >정보수정</a></span> 
			<span><a href="deleteForm.jsp">회원탈퇴</a></span> 
			<span><a href="logout.jsp">로그아웃</a></span>
		</div>
		<%
		}else {
		%>
		<div>
			<input type="button" value="로그인" onclick="location.href='login.jsp'" />
 
			<input type="button" value="강사 로그인" onclick="location.href='inslogin.jsp'" />
			
			<input type="button" value="회원가입" onclick="location.href='regForm.jsp'" />
		</div>
		<% } %>
		
	</header>
 <center><b>글삭제</b>
<br></br>
 <form method="POST" name="delForm"  action="deleteArticleProc.jsp?pageNum=<%=pageNum%>"onsubmit="return deleteSave()"> 
 <table border="1" align="center" cellspacing="0" cellpadding="0"
 width="360">
  <tr height="30">
     <td align=center  bgcolor="<%=value_c%>">
       <b>비밀번호를 입력해 주세요.</b></td>
  </tr>
  <tr height="30">
     <td align=center >비밀번호 :   
       <input type="password" name="pass" size="8" maxlength="12">
       <input type="hidden" name="num" value="<%=num%>"></td>
 </tr>
 <tr height="30">
    <td align=center bgcolor="<%=value_c%>">
      <input type="submit" value="글삭제" >
      <input type="button" value="글목록" onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'" >     
   </td>
 </tr>  
</table> 
</form>
 </center>
 </body>
 </html> 