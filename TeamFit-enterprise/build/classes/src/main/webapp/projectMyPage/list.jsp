<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="projectMyPage.BoardVO"%>
<%@ page import="projectMyPage.*, java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ include file="color.jsp"%>
<%
String loginID = (String) session.getAttribute("loginID");
String check = "게스트";
if(session.getAttribute("check")!=null){
	check = (String) session.getAttribute("check");
}


%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">


function loadPage(page) {
    $.ajax({
        url : page,
        method : 'GET',
        success : function(data) {
            $('#loadPage').html(data).show(); // 콘텐츠를 보이게 함
       
        },
        error : function() {
            $('#loadPage').html('<p>Error loading page</p>').show(); // 에러 메시지를 보이게 함
          
        }
    });
}
	

</script>
<style>
	header {
	display: flex;
	justify-content: space-between;
	padding: 10px;
	background-color: #569ee6; /* 예시 배경색 */
	width: 90%;
	margin-left: 5%;
	margin-top: 1%;
	box-sizing: border-box;
	border-radius: 10px;
}

</style>

<%!// 수정 <1>
int pageSize = 10;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
<%
//<수정 2>
String pageNum = request.getParameter("pageNum");
if (pageNum == null) {
    pageNum = "1";
}
int currentPage = Integer.parseInt(pageNum);
int startRow = (currentPage - 1) * pageSize + 1;
int endRow = currentPage * pageSize;
int count = 0;
int number = 0;

List<BoardVO> articleList = null;
BoardDAO dbPro = BoardDAO.getInstance();
count = dbPro.getArticleCount();//전체 글수
if (count > 0) {
	articleList = dbPro.getArticleList(startRow, endRow);//수정<3>
}
number=count-(currentPage-1)*pageSize;//수정<4>
%>
<html>
<head>
<title>게시판</title>
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
	<center id="list">
		
		<table>
			<tr>
				
				<td style="text-decoration: none;" align="right" ><a
					 href="writeForm.jsp">글쓰기</a>
				</td>
		</table>
		<%
		if (count == 0) {
		%>
		<table>
			<tr>
				<td align="center">게시판에 저장된 글이 없습니다.</td>
		</table>
		<%
		} else {
		%>
		<table >
			<tr >
				<td align="center" >번 호</td>
				<td align="center">제 목</td>
				<td align="center" >작성자</td>
				<td align="center">작성일</td>
				<td align="center" >조 회</td>
				<td align="center" >IP</td>
			</tr>
			<%
			for (int i = 0; i < articleList.size(); i++) {
				BoardVO article = (BoardVO) articleList.get(i);
			%>
			<tr>
				<td align="center" ><%=number--%></td>
				<td >
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
				<td align="center" ><a
					href="mailto:<%=article.getEmail()%>"> <%=article.getWriter()%></a></td>
				<td align="center"><%=sdf.format(article.getRegdate())%></td>
				<td align="center"><%=article.getReadcount()%></td>
				<td align="center"><%=article.getIp()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
		<!-- 수정 <7> -->
		 <%
    if (count > 0) {
        int pageBlock = 5;
        int imsi = count % pageSize == 0 ? 0 : 1;
        int pageCount = count / pageSize + imsi;
        int startPage = (int)((currentPage-1)/pageBlock)*pageBlock + 1;
        int endPage = startPage + pageBlock - 1;
        if (endPage > pageCount) endPage = pageCount;  
        if (startPage > pageBlock) {    
        %> <a href="list.jsp?pageNum=<%=startPage-pageBlock%>">[이전]</a>
 <%
        }
        for (int i = startPage ; i <= endPage ; i++) {  %>
         <a href="list.jsp?pageNum=<%= i %>">[<%= i %>]</a>
         <%
        }
        if (endPage < pageCount) {  %>
        <a href="list.jsp?pageNum=<%=startPage+pageBlock%>">[다음]</a>
         <%
        }
    }
		 %>
        
	</center>
</body>
</html>

