<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="projectMyPage.*"%>
<%
String loginID = (String) session.getAttribute("loginID");
String check = "게스트";
if(session.getAttribute("check")!=null){
	check = (String) session.getAttribute("check");
}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/projectMyPage/css/style.css">

<meta charset="UTF-8">
<title>회원 가입</title>
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script language="javascript" src="script.js"></script>
</head>
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
	<br><hr><br>
	<div id="loadPage"></div>
    <form  id="reg-container" method="post" action="regProc.jsp" name="regForm">
        <table class="form-table">
            <tr>
                <th colspan="2">회원 가입 정보 입력</th>
            </tr>
            <tr>
                <td align="right">아이디 :</td>
                <td>
                    <input type="text" name="id" id="id" />&nbsp; 
                    <input type="button" value="중복확인" onClick="idCheck(this.form.id.value)" />
                </td>
            </tr>
            <tr>
                <td align="right">패스워드 :</td>
                <td><input type="password" name="pass" /></td>
            </tr>
            <tr>
                <td align="right">패스워드 확인 :</td>
                <td><input type="password" name="repass" /></td>
            </tr>
            <tr>
                <td align="right">이름 :</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td align="right">전화번호 :</td>
                <td id="pNum">
                    <select name="phone1">
                        <option value="02">02</option>
                        <option value="010">010</option>
                    </select> - <br><br><input type="text" name="phone2" size="5" /> - <br><br><input type="text" name="phone3" size="5" />
                </td>
            </tr>
            <tr>
                <td align="right">이메일 :</td>
                <td><input type="text" name="email" /></td>
            </tr>
            <tr class="zipcode">
                <td align="right">우편번호 :</td>
              
                <td>
                    <input type="text" name="zipcode" /> 
                    <input type="button" value="찾기" onClick="zipCheck()" />
                </td>
            </tr>
            <tr>
                <td align="right">주소1 :</td>
                <td><input type="text" name="address1" size="50" /></td>
            </tr>
            <tr>
                <td align="right">주소2 :</td>
                <td><input type="text" name="address2" size="30" /></td>
            </tr>
            <tr class = "submit">
                <td  colspan="2" >
              <input type="button" value="회원가입" onclick="inputCheck()" />
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
