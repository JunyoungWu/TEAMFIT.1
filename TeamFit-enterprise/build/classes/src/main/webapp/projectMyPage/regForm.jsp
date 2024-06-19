<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="projectMyPage.*"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style>
    body {
        font-family: Arial, sans-serif;
        
        margin: 0;
        padding: 20px;
    }
    
    .container {
        max-width: 55%;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
	
    .form-table {
        width: 100%;
        margin-left: auto;
        margin-right: auto;
        border-collapse: collapse;
        border: 1px solid #ddd;
        border-radius: 5px;
        box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    }

    .form-table th, .form-table td {
        padding: 10px;
        border-bottom: 1px solid #ddd;
    }

    .form-table th {
        background-color: #f2f2f2;
        text-align: center;
    }

    .form-table td {
        text-align: left;
    }
	.submit {
    
   	width: 80%
    color: black; /* 폰트 색상을 흰색으로 설정 */
    font-size: 16px; /* 폰트 크기 설정 */
    padding: 50px; /* 내부 패딩 설정 */
    border-radius: 5px; /* 모서리 둥글게 */
}


    .form-table input[type="text"], .form-table input[type="password"], .form-table select {
        width: calc(100% - 10px);
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 3px;
        box-sizing: border-box;
    }

    .form-table input[type="button"], .form-table input[type="submit"], .form-table input[type="reset"] {
        padding: 8px 16px;
        background-color: #1473d3;
        color: #fff;
        border: none;
        border-radius: 3px;
        cursor: pointer;
        font-size: 14px;
    }

    .form-table input[type="button"]:hover, .form-table input[type="submit"]:hover, .form-table input[type="reset"]:hover {
        background-color: #105a9d;
    }

    .form-table input[type="button"]:focus, .form-table input[type="submit"]:focus, .form-table input[type="reset"]:focus {
        outline: none;
    }
</style>
<script language="javascript" src="script.js"></script>
</head>
<body>
<div class="container">
    <form method="post" action="regProc.jsp" name="regForm">
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
                <td>
                    <select name="phone1">
                        <option value="02">02</option>
                        <option value="010">010</option>
                    </select> - <input type="text" name="phone2" size="5" /> - <input type="text" name="phone3" size="5" />
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
                   &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; <input type="button" value="회원가입" onclick="inputCheck()" />&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; 
                    <input type="reset" value="다시입력" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
