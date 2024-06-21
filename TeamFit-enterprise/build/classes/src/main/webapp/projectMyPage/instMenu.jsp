<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%String loginID = (String) session.getAttribute("loginID");
	String check = "게스트";
	if(session.getAttribute("check")!=null){
		check = (String) session.getAttribute("check");
	}
 %>
<!DOCTYPE html>
<html>
<head>

 <link rel="stylesheet" href="${pageContext.request.contextPath}/projectMyPage/css/style.css">

<meta charset="UTF-8">
<style>


h1 {
	margin-left: 10px;
	margin-top: 10px;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
	function loadPage(page) {
		$.ajax({
			url : page,
			method : 'GET',
			success : function(data) {
				$('#icontent').html(data);
			},
			error : function() {
				$('#icontent').html('<p>Error loading page</p>');
			}
		});
	}
</script>
<title>Insert title here</title>
</head>
<body>
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
			<input type="button" value="로그인" onclick="loadPage('login.jsp')" />
 
			<input type="button" value="강사 로그인" onclick="loadPage('inslogin.jsp')" />
			
			<input type="button" value="회원가입" onclick="location.href='regForm.jsp'" />
		</div>
		<% } %>
		
	</header>
	<br>
	<hr>
	<br>
	<div id="navbar-container">
	<h1>강사 메뉴</h1>
	<div id="navbar">
		<span><a href="#" onclick="loadPage('listExercises.jsp')">운동 리스트</a></span> 
		<span><a href="#" onclick="loadPage('addex.jsp')">운동 추가</a></span> 
		<span><a href="#" onclick="loadPage('deleteExerciseForm.jsp')">운동 삭제</a></span> 
		<span><a href="#" onclick="loadPage('manageMembers.jsp')">회원 관리</a></span>
	</div>
</div>
	<br>
		<br>
	
	<div id="icontent">
	
	</div>


</body>
</html>