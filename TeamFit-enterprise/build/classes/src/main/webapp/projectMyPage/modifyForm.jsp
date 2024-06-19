
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="projectMyPage.*"%>
<%
StudentDAO dao = StudentDAO.getInstance();
%>

<script language="javascript" src="script.js"></script>

<%
String loginID = (String) session.getAttribute("loginID");
StudentVO vo = dao.getMember(loginID);
%>
<head>
<title>회원 정보 수정</title>
<style type="text/css">
body {
    background-color: #1473d3;
    text-align: center; /* 추가 */
}

table {
    width: 60%;
    border-collapse: collapse;
    margin: 0 auto; /* 중앙 정렬 */
    background-color: #f9f9f9;
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

td {
    padding: 10px;
}

td[colspan="2"] {
    background-color: #569ee6;
    color: #fff;
    font-weight: bold;
    border-radius: 10px 10px 0 0;
}

input[type="submit"] {
    width: 30%;
    padding: 10px;
    background-color: #1473d3;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
}

input[type="button"] {
    background-color: #007acc;
    color: #ffffff;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    margin: 5px;
}

input[type="text"] {
    width: 30%;
    height: 50px;
    border: none;
    border: 2px solid #80c1ff;
    border-radius: 5px;
    font-size: 16px;
    background-color: #e0f7fa;
}

input[type="password"] {
    width: 30%;
    height: 50px;
    border: none;
    border: 2px solid #80c1ff;
    border-radius: 5px;
    font-size: 16px;
    background-color: #e0f7fa;
}

input[type="submit"]:hover {
    background-color: #105a9d;
}
</style>

</head>
<form name="regForm" method="post" action="modifyProc.jsp">
	<table style="margin-left: 5%; margin: 0 auto;" border="1">

		<tr>
			<td colspan="2" align="center">회원 수정 정보 입력</td>
		</tr>
		<tr>
			<td align="right">아이디 :</td>
			<td><%=vo.getId()%></td>
		</tr>
		<tr>
			<td align="right">패스워드 :</td>
			<td><input type="password" name="pass" value="<%=vo.getPass()%>" /></td>
		</tr>
		<tr>
			<td align="right">패스워드 확인:</td>
			<td><input type="password" name="repass"
				value="<%=vo.getPass()%>" /></td>
		</tr>
		<tr>
			<td align="right">이름 :</td>
			<td><%=vo.getName()%></td>
		</tr>
		<tr>
			<td align="right">전화번호 :</td>
			<td><input type="text" name="phone1" size="4"
				value="<%=vo.getPhone1()%>" /> - <input type="text" name="phone2"
				size="5" value="<%=vo.getPhone2()%>" /> - <input type="text"
				name="phone3" size="5" value="<%=vo.getPhone3()%>" /></td>
		</tr>
		<tr>
			<td align="right">이메일 :</td>
			<td><input type="text" name="email" value="<%=vo.getEmail()%>" /></td>
		</tr>
		<tr>
			<td align="right">우편번호 :</td>
			<td><input type="text" name="zipcode"
				value="<%=vo.getZipcode()%>" /> <input type="button" value="찾기"
				onClick="zipCheck()" /></td>
		</tr>
		<tr>
			<td align="right">주소1 :</td>
			<td><input type="text" name="address1" size="50"
				value="<%=vo.getAddress1()%>" /></td>
		</tr>
		<tr>
			<td align="right">주소2 :</td>
			<td><input type="text" name="address2" size="30"
				value="<%=vo.getAddress2()%>" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button" value="정보수정"
				onClick="updateCheck()" />&nbsp;&nbsp; <input type="button"
				value="취소" onClick="javascript:window.location='index.jsp'" /></td>
		</tr>
	</table>
</form>

