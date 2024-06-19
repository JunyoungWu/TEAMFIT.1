<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "projectMyPage.BoardDAO" %>
<%@ page import = "projectMyPage.*" %>
<%@ include file="color.jsp" %>
<html>
<head>
<title>게시판</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/projectMyPage/css/style.css">

<script language="JavaScript" src="script.js"></script>
</head>
<body bgcolor="<%=bodyback_c%>">
<%
    try {
    	String loginID = (String) session.getAttribute("loginID");
    	String check = (String) session.getAttribute("check");
        int num = Integer.parseInt(request.getParameter("num").trim());
        String pageNum = request.getParameter("pageNum");
        BoardDAO dbPro = BoardDAO.getInstance();
        BoardVO article = dbPro.updateGetArticle(num);
%>
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
<center><b>글수정</b>
<br>
<form class="updateArticle" method="post" name="writeform" action="updateProc.jsp?pageNum=<%=pageNum%>" onsubmit="return writeSave()">
<table width="400" border="1" cellspacing="0" cellpadding="0" bgcolor="<%=bodyback_c%>" align="center">
<tr>
    <td width="70" bgcolor="<%=value_c%>" align="center">이 름</td>
    <td align="left" width="330">
        <input type="text" size="10" maxlength="10" name="writer" value="<%=article.getWriter()%>">
        <input type="hidden" name="num" value="<%=article.getNum()%>">
    </td>
</tr>
<tr>
    <td width="70" bgcolor="<%=value_c%>" align="center">제 목</td>
    <td align="left" width="330">
        <input type="text" size="40" maxlength="50" name="subject" value="<%=article.getSubject()%>">
    </td>
</tr>
<tr>
    <td width="70" bgcolor="<%=value_c%>" align="center">Email</td>
    <td align="left" width="330">
        <input type="text" size="40" maxlength="30" name="email" value="<%=article.getEmail()%>">
    </td>
</tr>
<tr>
    <td width="70" bgcolor="<%=value_c%>" align="center">내 용</td>
    <td align="left" width="330">
        <textarea name="content" rows="13" cols="40"><%=article.getContent()%></textarea>
    </td>
</tr>
<tr>
    <td width="70" bgcolor="<%=value_c%>" align="center">비밀번호</td>
    <td align="left" width="330">
        <input type="password" size="8" maxlength="12" name="pass">
    </td>
</tr>
<tr>
    <td colspan=2 bgcolor="<%=value_c%>" align="center">
        <input type="submit" value="글수정">
       
        <input type="button" value="목록보기" onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'">
    </td>
</tr>
</table>
</form>
</center>
<%
    } catch (Exception e) {
        out.println("<h3>오류가 발생했습니다: " + e.getMessage() + "</h3>");
        
    }
%>
</body>
</html>
