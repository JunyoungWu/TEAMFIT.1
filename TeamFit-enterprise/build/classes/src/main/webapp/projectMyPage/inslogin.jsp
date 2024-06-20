<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/projectMyPage/css/style.css">

<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<div id="login-container">
<form method="post" action="insloginProc.jsp" name="inslogin">
    <table border="1"  >
        <tr>
            <td colspan="2" align="center">강사 로그인</td>
        </tr>
        <tr>
            <td align="right" width="100">아이디 :</td>
            <td width="200">&nbsp;&nbsp; <input type="text" name="id" size="20" /></td>
        </tr>
        <tr>
            <td align="right" width="100">비밀번호 :</td>
            <td width="200">&nbsp;&nbsp; <input type="password" name="pass" size="20" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="로그인" /></td>
        </tr>
    </table>
</form>
</div>

</body>
</html>
