<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="projectMyPage.*, java.util.*"%>
<%  String loginID = (String) session.getAttribute("loginID");
String check = (String) session.getAttribute("check"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>운동 삭제</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/projectMyPage/css/style.css">
 
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
    <center>
        <h2>운동 삭제</h2>
				  <!-- 운동 리스트 테이블 -->
        <table border="1">
            <tr>
                <th>번호</th>
                <th>운동명</th>
                <th>장소</th>
                <th>날짜</th>
                <th>운동인원</th>
                <th>가격</th>
            </tr>
            <%
                ExerciseDAO dao = ExerciseDAO.getInstance();
                List<ExerciseVO> exerciseList = dao.getAllExercises();
                for (ExerciseVO vo : exerciseList) {
            %>
            <tr>
                <td><%= vo.getE_no() %></td>
                <td><%= vo.getE_name() %></td>
                <td><%= vo.getE_location() %></td>
                <td><%= vo.getE_date() %></td>
                <td><%= vo.getE_memnum() %></td>
                <td><%= vo.getE_price() %></td>
            </tr>
            <%
                }
            %>
        </table>
        <br>
        <!-- 운동 삭제 -->
        <form action="deleteExerciseProc.jsp" method="post">
            <label for="e_no">삭제할 운동 번호 (e_no):</label>
            <input type="text" id="e_no" name="e_no" required>
            <input type="submit" value="삭제">
        </form>

    <br>

      
    </center>
</body>
</html>
