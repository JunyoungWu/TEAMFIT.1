<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="color.jsp" %>
<%String loginID = (String) session.getAttribute("loginID");
String check = (String) session.getAttribute("check"); %>
 <html>
 <head>
 <title>My Board</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/projectMyPage/css/style.css">

 <script language="javascript" src="script.js"> 
 
</script>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 

 </head>
 <!--// 나중에 새글 답별글 구분하는 코드 추가 <1> -->
 <% 
int num=0, ref=1, step=0, depth=0;
 try{  
if(request.getParameter("num")!=null){
 num = Integer.parseInt(request.getParameter("num"));
 ref = Integer.parseInt(request.getParameter("ref"));
 step = Integer.parseInt(request.getParameter("step"));
 depth = Integer.parseInt(request.getParameter("depth"));
 }
 %>
 <body bgcolor="<%=bodyback_c %>">
  <header >
		<img onclick="location.href = 'index.jsp';" src="./image/TeamFit.png" style="width: 150px; height: 80px;" alt="" />

		<%
		if (loginID != null && ("강사".equals(check))) {
		%>

		<div  class="right">
			<span><%=loginID%>님 환영합니다.</span> 
			<span><a href="modifyForm.jsp">정보수정</a></span> 
			<span><a href="deleteForm.jsp" >회원탈퇴</a></span> 
			<span><a href="logout.jsp">로그아웃</a></span>
		</div>
		<%
		} else if (loginID != null && ("회원".equals(check))) {
		%>
		
        		<div  class="right">
			<span><%=loginID%>님 환영합니다.</span> 
			<span><a href="modifyForm.jsp">정보수정</a></span> 
			<span><a href="deleteForm.jsp" >회원탈퇴</a></span> 
			<span><a href="logout.jsp">로그아웃</a></span>
		</div>
		<%
		}else {
		%>
		<div>
			<input type="button" value="로그인" onclick="loadPage('login.jsp')" />
			<input type="button" value="강사 로그인" onclick="loadPage('inslogin.jsp')" />
			<input type="button" value="회원가입" onclick="loadPage('regForm.jsp')" />
		</div>
		<% } %>
		
	</header>
	<br><hr><br>
 <center><b>글쓰기</b></center><br></br>
 <form id="writeArticle" class="writeArticle" method="post" name="writeForm" action="writeProc.jsp">
<input type="hidden" name="num" value="<%=num%>">
 <input type="hidden" name="ref" value="<%=ref%>">
 <input type="hidden" name="step" value="<%=step%>">
 <input type="hidden" name="depth" value="<%=depth%>">  
 <table width="400" border="1" cellpadding="0" cellspacing="0" 
align="center" bgcolor="<%=bodyback_c %>">
 <tr>
    <td align="right" colspan="2" bgcolor="<%=value_c %>">
 <a href="list.jsp">글목록</a>
    </td>
 </tr>
 <tr>
    <td id="noInput" style="width: 50px">이름</td>
    <td width="330">
 <input type="text" size="12" maxlength="12" name="writer"/>
    </td>
 </tr>
 <tr>
    <td id="noInput" style="width: 50px">이메일</td>
    <td >

   <input type="text" size="50" maxlength="50" name="email"/>
   
    </td>
 </tr>
 <tr>
    <td  id="noInput" style="width: 50px">제목</td>
    <td >
 <input type="text" size="50" maxlength="50" name="subject"/>
    </td>
 </tr>
 <tr>
    <td id="noInput" style="width: 50px">내용</td>
    <td>
 <textarea name="content" rows="13" cols="50"></textarea>
    </td>
 </tr>
 <tr>
    <td id="noInput" style="width: 50px">비밀번호</td>
    <td width="330">
 <input type="password" size="10" maxlength="10" name="pass"/>
    </td>
 </tr>
 <tr>
    <td colspan="2" bgcolor="<%=value_c %>" align="center">
 <input onclick="loadPage('list.jsp')" type="submit" value="글쓰기"/>

 <input type="button" value="목록" 
onClick="window.location='list.jsp'">
    </td>
 </tr>
 </table>
 </form>
 <!-- 예외처리<2> -->
 <%  }catch(Exception e){} %>    
 </body>
 </html>
    