<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="projectMyPage.StudentDAO" %>

<%

String[] selectedMembers = request.getParameterValues("selectedMembers");


if (selectedMembers != null && selectedMembers.length > 0) {
 
    StudentDAO studentDAO = StudentDAO.getInstance();
    
 
    for (String memberId : selectedMembers) {
        studentDAO.deleteMemberByAdmin(memberId);
    }
    
    %>
    <script>
    alert("선택된 회원이 삭제되었습니다.");
	window.location.href = "index.jsp";
    </script>
    <%
    
} else {
   
    response.sendRedirect("manageMembers.jsp?error=noSelection");
}
%>
