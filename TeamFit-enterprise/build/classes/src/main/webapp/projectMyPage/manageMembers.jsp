<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.List, projectMyPage.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Members</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/projectMyPage/css/style.css">

</head>
<body>


<form id="delMem" method="post" action="delSelectProc.jsp"> 
<table border="1">
  <tr>
    <th></th> 
    <th>ID</th>
    <th>이름</th>
    <th>전화번호</th>
    <th>이메일</th>
    <th>주소</th>
  </tr>
  
  <% 
    // StudentDAO 객체 생성
    StudentDAO studentDAO = StudentDAO.getInstance();
    
    // 모든 회원 정보 가져오기
    List<StudentVO> memberList = studentDAO.getAllMembers();
    
    // 회원 정보 출력
    for (StudentVO member : memberList) {
  %>
  <tr>
    <td><input type="checkbox" name="selectedMembers" value="<%= member.getId() %>"></td> 
    <td><%= member.getId() %></td>
    <td><%= member.getName() %></td>
    <td><%= member.getPhone1() %>-<%= member.getPhone2() %>-<%= member.getPhone3() %></td>
    <td><%= member.getEmail() %></td>
    <td><%= member.getAddress1() %> <%= member.getAddress2() %></td>
    <% } %>
     </tr>
     <tr>     <td colspan="6"><input  type="submit" value="선택된 회원 삭제"> </td></tr>

 
 
</table>

</form>

</body>
</html>
