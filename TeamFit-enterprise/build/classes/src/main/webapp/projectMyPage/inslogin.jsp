<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
    body {
        
        background-color: #1473d3;
    }

    .login-container {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
        text-align: center;
    }

    table {
        width: 60%;
        border-collapse: collapse;
        margin: 0 auto;
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

    input[type="text"], input[type="password"] {
        width: calc(100% - 20px);
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #1473d3;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #105a9d;
    }
</style>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
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
</body>
</html>
