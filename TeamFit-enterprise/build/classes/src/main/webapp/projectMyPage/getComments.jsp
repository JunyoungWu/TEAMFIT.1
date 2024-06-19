<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="projectMyPage.CommentsDAO"%>
<%@ page import="projectMyPage.CommentsVO"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.List"%>

<%
int num = Integer.parseInt(request.getParameter("num"));
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
List<CommentsVO> commentList = CommentsDAO.getInstance().getComments(num);
String check = (String) session.getAttribute("check");
%>

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
                    <input type="hidden" name="num" value="<%=num%>">
                    <button type="submit">삭제</button>
                </form>
                <% } %>
            </td>
        </tr>
    </table>
</div>
<% } %>
