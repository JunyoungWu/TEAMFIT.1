<%@ page contentType="text/html;charset=UTF-8"  import="projectMyPage.*" %>
<%StudentDAO dao = StudentDAO.getInstance(); %>
 <% String id = request.getParameter("id");
 String pass = request.getParameter("pass");
 System.out.println("ID: " + id); // ID 값 출력
 System.out.println("Password: " + pass); // 비밀번호 값 출력


 int check = dao.loginCheck(id, pass);
 System.out.println("Check result: " + check); // 로그인 체크 결과 출력
%>
 <%
 if(check == 1){//로그인 성공
session.setAttribute("loginID", id);
session.setAttribute("check", "회원");
 response.sendRedirect("index.jsp");
 }else if(check == 0){//아이디는 있는데 비밀번호 오류
%>
 <script>
 alert("비밀번호가 틀렸습니다");
 history.go(-1);
 </script>
 <% } else{//아이디 자체가 존재하지 않는 경우
%>
 <script>
 alert("아이디가 존재하지 않습니다");
 history.go(-1);
 </script>
 <%} %>