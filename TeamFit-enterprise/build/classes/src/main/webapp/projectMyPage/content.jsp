<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="projectMyPage.BoardDAO"%>
<%@ page import="projectMyPage.BoardVO"%>
<%@ page import="projectMyPage.CommentsDAO"%>
<%@ page import="projectMyPage.CommentsVO"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.List"%>

<%
String loginID = (String) session.getAttribute("loginID");
String check = "게스트";
if(session.getAttribute("check")!=null){
	check = (String) session.getAttribute("check");
}

int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
int currentPage = Integer.parseInt(pageNum);
BoardDAO dbPro = BoardDAO.getInstance();
BoardVO article = dbPro.getArticle(num);
CommentsVO vo = new CommentsVO();
CommentsDAO dao = new CommentsDAO();
String comContent = (String)(request.getParameter("comContent"));
if(comContent!=null){
	vo.setComContent(comContent);
	vo.setNum(num);
	dao.insertComment(vo);
}
List<CommentsVO> commentList = CommentsDAO.getInstance().getComments(num);
%>

<%@ include file="color.jsp"%>
<html>
<head>
 
<title>게시판</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/projectMyPage/css/style.css">
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
	<br><br><hr><br>
<center id="post" >
    <b></b><br><br>
    <div>
     <table   >
        <tr>
            <td  bgcolor="<%=value_c%>">글번호</td>
            <td><%=article.getNum()%></td>
            <td >조회수</td>
            <td ><%=article.getReadcount()%></td>
        </tr>
        <tr >
            <td >작성자</td>
            <td ><%=article.getWriter()%></td>
            <td>작성일</td>
            <td><%=sdf.format(article.getRegdate())%></td>
        </tr>
        <tr >
            <td>글제목</td>
            <td colspan="3"><%=article.getSubject()%></td>
        </tr>
        <tr>
            <td>글내용</td>
            <td  colspan="3"><pre><%=article.getContent()%></pre></td>
        </tr>
        <tr >
            <td colspan="4" align="right">
<input type="button" value="글수정" onclick="window.location.href = 'updateForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
                &nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="글삭제" onclick="window.location.href = 'deleteArticle.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
                &nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="글목록" onclick="window.location.href = 'list.jsp'">
            </td>
        </tr>
    </table>
    
    </div>
   
    <!-- 댓글 출력 -->
    <% for (CommentsVO comment : commentList) { %>
    <div class="comments">
        <table>
            <tr>
                <td>작성자:</td>
                <td><%=comment.getComWriter()%></td>
            </tr>
            <tr>
                <td>댓글 내용:</td>
                <td><%=comment.getComContent()%></td>
            </tr>
            <tr>
                <td>작성 날짜:</td>
                <td><%=sdf.format(comment.getRegdate())%></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: right;">
                    <% if (check.equals("강사")) { %>
                    <form action="delCommentProc.jsp" method="post" style="display: inline;">
                        <input type="hidden" name="comNum" value="<%=comment.getComNum()%>">
                        <input type="hidden" name="num" value="<%=article.getNum()%>">
                        <button type="submit">삭제</button>
                    </form>
                    <% } %>
                </td>
            </tr>
        </table>
    </div>
    <% } %>

    <!-- 댓글 작성 폼 -->
    <% if (check.equals("강사")) { %>
    <div class="commentWrite">
        <form action="content.jsp?num=<%=article.getNum()%>&pageNum=<%=currentPage%>" method="post">
            <input type="hidden" name="num" value="<%=num%>">
            <table>
                <tr>
                    <td>
                        <textarea name="comContent" placeholder="댓글 내용"></textarea>
                    </td>
                </tr>
                <tr>
                    <td style="text-align: right;">
                    <input type="hidden" name="num" value="<%=article.getNum()%>">
                        <button onclick="loadPage('content.jsp?num=<%=article.getNum()%>&pageNum=<%=currentPage%>')"  type="submit">댓글 작성</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
     
    <% } %>
</center>
</body>
</html>
