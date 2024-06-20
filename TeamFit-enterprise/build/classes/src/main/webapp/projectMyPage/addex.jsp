<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="projectMyPage.*"%>
<%
    ExerciseDAO dao = ExerciseDAO.getInstance();
%>
<%
String loginID = (String) session.getAttribute("loginID");
String check = "게스트";
if(session.getAttribute("check")!=null){
	check = (String) session.getAttribute("check");
}
%>
 <head>
 
<title>운동 추가</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/projectMyPage/css/style.css">
 <script language="javascript" src="script.js"></script>
 <style type="text/css">
 input[type="text"]{
	  width: calc(100% - 20px);
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
}
 </style>
</head>


<header>
		<img onclick="location.href = 'index.jsp';" src="./image/TeamFit.png" style="width: 150px; height: 80px;" alt="" />
		<%System.out.println("체크 : "+check); %>
		<%
		if (loginID != null && ("강사".equals(check))) {
		%>
		<div class="mid">
            <a href="instMenu.jsp" >강사 메뉴</a>&nbsp;&nbsp;
            <a href="addApplication.jsp"  >운동 신청</a>&nbsp;&nbsp;
            <a href="deleteExerciseForm.jsp" >운동 삭제</a>&nbsp;&nbsp;
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


<form class="addExercise" method="post" action="addexProc.jsp" name="addex" >
		
    <table  style="margin: 0 auto; width: 50%;">
        <tr>
            <td colspan="2" align="center">운동 정보 입력</td>
        </tr>
        <tr>
            <td align="right">운동명 :</td>
            <td>
                <input type="text" name="e_name" id="e_name" />&nbsp; 
            </td>
        </tr>
        <tr>
            <td align="right">장소 :</td>
            <td><input type="text" name="e_location" id="e_location" /></td>
        </tr>
       
        <tr>
            <td align="right">날짜 :</td>
            <td><input type="text" name="e_date" id="e_date" /></td>
        </tr>
        <tr>
            <td align="right">운동인원 :</td>
            <td><input type="text" name="e_memnum" id="e_memnum" /></td>
        </tr>
        <tr>
            <td align="right">가격 :</td>
            <td><input type="text" name="e_price" id="e_price" /></td>
        </tr>
       
        <tr>
            <td colspan="2" align="center"><input type="button" value="운동등록" onclick="e_inputCheck()" /></td>
        </tr>
    </table>
</form>



