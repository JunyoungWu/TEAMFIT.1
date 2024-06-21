<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="projectMyPage.*, java.util.*"%>
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
<title>운동 신청</title>
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
			<input type="button" value="로그인" onclick="location.href='login.jsp'" />
 
			<input type="button" value="강사 로그인" onclick="location.href='inslogin.jsp'" />
			
			<input type="button" value="회원가입" onclick="location.href='regForm.jsp'" />
		</div>
		<% } %>
		
	</header>
		<div id="addApp">
		<h1>운동 신청 메뉴</h1>
        <div id="exerciseTableWrapper">
            <table id="exerciseTable">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>운동명</th>
                        <th>장소</th>
                        <th>날짜</th>
                        <th>운동인원</th>
                        <th>가격</th>
                    </tr>
                </thead>
                <tbody>
                    <% ExerciseDAO dao = ExerciseDAO.getInstance();
                       List<ExerciseVO> exerciseList = dao.getAllExercises();
                       for (ExerciseVO vo : exerciseList) { %>
                        <tr>
                            <td><%= vo.getE_no() %></td>
                            <td><%= vo.getE_name() %></td>
                            <td><%= vo.getE_location() %></td>
                            <td><%= vo.getE_date() %></td>
                            <td><%= vo.getE_memnum() %></td>
                            <td><%= vo.getE_price() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
     <br>
    <!-- 유저 운동 신청 양식 -->
    <form id="addApplicationProc" action="addApplicationProc.jsp" method="post"><br>
        <label for="e_no">신청할 운동의 번호를 입력해주세요</label><br><br>
        <input  placeholder="운동번호" type="text" id="e_no" name="e_no" required>
        <br><br>
        <input type="submit" value="신청">
    </form>
    <br>
    </div>
		</div>
    
   
   
</body>
</html>
