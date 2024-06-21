<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="projectMyPage.*, java.util.*"%>
<%
String loginID = (String) session.getAttribute("loginID");
String check = "게스트";
if(session.getAttribute("check")!=null){
	check = (String) session.getAttribute("check");
}
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">


function loadPage(page) {
    $.ajax({
        url : page,
        method : 'GET',
        success : function(data) {
            $('#loadPage').html(data).show(); // 콘텐츠를 보이게 함
            $('#slideshow').hide(); // 슬라이드쇼 숨기기
        },
        error : function() {
            $('#loadPage').html('<p>Error loading page</p>').show(); // 에러 메시지를 보이게 함
            $('#slideshow').hide(); // 슬라이드쇼 숨기기
        }
    });
}
	

</script>
<meta charset="UTF-8">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/projectMyPage/css/style.css">

<title>내 운동 목록</title>
<script type="text/javascript">
    function checkAll(box) {
        var checkboxes = document.getElementsByName('e_no');
        for (var i = 0; i < checkboxes.length; i++) {
            checkboxes[i].checked = box.checked;
        }
    }
</script>
   <style type="text/css">


</style>
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
	
	<div id="loadPage"></div>
    <form id="delEx" action="delApplicationProc.jsp" method="post">
        <h1>내 운동 목록</h1>
        <table border="1">
            <tr>
                <th><input type="checkbox" onclick="checkAll(this)"></th>
                <th>번호</th>
                <th>운동명</th>
                <th>장소</th>
                <th>날짜</th>
                <th>운동인원</th>
                <th>가격</th>
            </tr>
            <%
                // 세션에서 사용자 ID 가져오기
                String userId = (String) session.getAttribute("loginID");
                if (userId == null) {
                    response.sendRedirect("login.jsp");
                    return;
                }

                ExerciseDAO dao = ExerciseDAO.getInstance();
                List<ExerciseVO> exerciseList = dao.getExercisesByUserId(userId);
                for (ExerciseVO vo : exerciseList) {
            %>
            <tr>
                <td><input type="checkbox" name="e_no" value="<%= vo.getE_no() %>"></td>
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
        <input type="submit" value="선택된 운동 삭제">
    </form>
</body>
</html>
