<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="projectMyPage.BoardDAO"%>
<%@ page import="projectMyPage.BoardVO"%>
<%@ page import="projectMyPage.CommentsDAO"%>
<%@ page import="projectMyPage.CommentsVO"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.List"%>

<%
String check = (String) session.getAttribute("check");
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

BoardDAO dbPro = BoardDAO.getInstance();
BoardVO article = dbPro.getArticle(num);
List<CommentsVO> commentList = CommentsDAO.getInstance().getComments(num);
%>

<%@ include file="color.jsp"%>
<html>
<head>
<title>게시판</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="<%=bodyback_c%>">
<img onclick="location.href = 'index.jsp';" src="./image/TeamFit.png" style="width: 150px; height: 80px;" alt="" />
<center>
    <b>글내용 보기</b><br><br>
    <table width="500" border="1" cellspacing="0" cellpadding="0" bgcolor="<%=bodyback_c%>" align="center">
        <tr height="30">
            <td align="center" width="125" bgcolor="<%=value_c%>">글번호</td>
            <td align="center" width="125"><%=article.getNum()%></td>
            <td align="center" width="125" bgcolor="<%=value_c%>">조회수</td>
            <td align="center" width="125"><%=article.getReadcount()%></td>
        </tr>
        <tr height="30">
            <td align="center" width="125" bgcolor="<%=value_c%>">작성자</td>
            <td align="center" width="125"><%=article.getWriter()%></td>
            <td align="center" width="125" bgcolor="<%=value_c%>">작성일</td>
            <td align="center" width="125"><%=sdf.format(article.getRegdate())%></td>
        </tr>
        <tr height="30">
            <td align="center" width="125" bgcolor="<%=value_c%>">글제목</td>
            <td align="center" width="375" colspan="3"><%=article.getSubject()%></td>
        </tr>
        <tr>
            <td align="center" width="125" bgcolor="<%=value_c%>">글내용</td>
            <td align="left" width="375" colspan="3"><pre><%=article.getContent()%></pre></td>
        </tr>
        <tr height="30">
            <td colspan="4" bgcolor="<%=value_c%>" align="right">
                <input type="button" value="글수정" onclick="document.location.href='updateForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button" value="글삭제" onclick="document.location.href='deleteArticle.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button" value="글목록" onclick="document.location.href='list.jsp'">
            </td>
        </tr>
    </table>

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
        <form action="commentProc.jsp" method="post">
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
                        <button type="submit">댓글 작성</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <% } %>
</center>
</body>
</html>
