<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="projectMyPage.*, java.util.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%int pageSize = 10;
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
String loginID = (String) session.getAttribute("loginID");
String check = "게스트";
if(session.getAttribute("check")!=null){
	check = (String) session.getAttribute("check");
}

String pageNum = request.getParameter("pageNum");
if (pageNum == null) {
    pageNum = "1";
}
int currentPage = Integer.parseInt(pageNum);
int startRow = (currentPage - 1) * pageSize + 1;
int endRow = currentPage * pageSize;

int number = 0;

List<BoardVO> articleList = null;
int count = 0;
BoardDAO dbPro = BoardDAO.getInstance();
count = dbPro.getArticleCount();
if (count > 0) {
	articleList = dbPro.getArticleList(startRow, endRow);
}
number=count-(currentPage-1)*pageSize;
 %>



<html>
<head>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/projectMyPage/css/style.css">

<script language="javascript" src="script.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://kit.fontawesome.com/dd1c09ef10.js"
	crossorigin="anonymous"></script>
<title>Main Site</title>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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


</head>
<body onload="call_js()">
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
			<input type="button" value="로그인" onclick="loadPage('login.jsp')" />
 
			<input type="button" value="강사 로그인" onclick="loadPage('inslogin.jsp')" />
			
			<input type="button" value="회원가입" onclick="location.href='regForm.jsp'" />
		</div>
		<% } %>
		
	</header>
	
	<hr>
	<div id="loadPage"></div>
	<div id="slideshow" class="slideshow">
		<div class="slideshow_slides">
			<a href="#"><img src="./image/slide-1.jpg" alt="slide1" /></a> <a
				href="#"><img src="./image/slide-2.jpg" alt="slide1" /></a> <a
				href="#"><img src="./image/slide-3.jpg" alt="slide1" /></a> <a
				href="#"><img src="./image/slide-4.jpg" alt="slide1" /></a>
		</div>
		<div class="slideshow_nav">
			<a href="#" class="prev"><i
				class="fa-solid fa-circle-chevron-left"></i></a> <a href="#"
				class="next"><i class="fa-solid fa-circle-chevron-right"></i></a>
		</div>
		<div class="indicator">
			<a href="#" class="active"><i class="fa-solid fa-circle-dot"></i></a>
			<a href="#"><i class="fa-solid fa-circle-dot"></i></a> <a href="#"><i
				class="fa-solid fa-circle-dot"></i></a> <a href="#"><i
				class="fa-solid fa-circle-dot"></i></a>
		</div>
		<br>
	</div>
	<br><hr><br>
	
	<div class="midd" >
		<div>
			<h2>현재 개설된 운동</h2>
			<table id="exList">
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
					<td><%=vo.getE_no()%></td>
					<td><%=vo.getE_name()%></td>
					<td><%=vo.getE_location()%></td>
					<td><%=vo.getE_date()%></td>
					<td><%=vo.getE_memnum()%></td>
					<td><%=vo.getE_price()%></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
		<div>
			 <h2 style="margin-left: 8%">문의 게시판</h2>
			<center id="list">
		
	
		<%
		if (count == 0) {
		%>
		<table class="list" width="700" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">게시판에 저장된 글이 없습니다.</td>
		</table>
		<%
		} else {
		%>
		<table class="list" border="1" width="700" cellpadding="0" cellspacing="0"
			align="center">
			<tr height="30" >
				<td align="center" width="50">번 호</td>
				<td align="center" width="250">제 목</td>
				<td align="center" width="100">작성자</td>
				<td align="center" width="150">작성일</td>
				<td align="center" width="50">조 회</td>
				<td align="center" width="100">IP</td>
			</tr>
			<%
			for (int i = 0; i < articleList.size(); i++) {
				BoardVO article = (BoardVO) articleList.get(i);
			%>
			<tr height="30">
				<td align="center" width="50"><%=number--%></td>
				<td width="250">
					<!-- 수정 <5> -->
					<%
      int wid=0; 
      if(article.getDepth()>0){
        wid=5*(article.getDepth());
 %>
  <img src="images/level.gif" width="<%=wid%>" height="16">
  <img src="images/re.gif">
 <%}else{%>
  <img src="images/level.gif" width="<%=wid%>" height="16">
 <%}%>
					
					 <a 
					href="content.jsp?num=<%=article.getNum()%>&pageNum=<%=currentPage%>"> 
						<%=article.getSubject()%></a> <%
 if (article.getReadcount() >= 20) {
 %> <img
					src="images/hot.gif" border="0" height="16">
					<%
					}
					%>
				</td>
				<td align="center" width="100"><a
					href="mailto:<%=article.getEmail()%>"> <%=article.getWriter()%></a></td>
				<td align="center" width="150"><%=sdf.format(article.getRegdate())%></td>
				<td align="center" width="50"><%=article.getReadcount()%></td>
				<td align="center" width="100"><%=article.getIp()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
		
        
	</center>
		</div>
	</div>
	<hr>
	<footer>
		<div class="footer content1">
			<a href="">다운로드</a> <a href="">개인정보처리방침</a> <a href="">신고</a> <a
				href="">이메일무단수집거부</a>
		</div>
		<div class="footer content2">
			<p>팀피트컴퍼니 : 서울시 성동구 무학로2길 54 신방빌딩 4,5층 tel:012-345-7890</p>
			<p>
				Copyright <span>ⓒ</span> 2018 tmft, Inc. All right reserved. Adress:
				23-455-1234
			</p>
		</div>
	</footer>
</body>
</html>
