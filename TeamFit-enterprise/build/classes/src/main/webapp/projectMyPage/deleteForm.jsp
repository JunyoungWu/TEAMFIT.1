 <%@ page contentType="text/html;charset=utf-8"%>
 <html>
 <head>
 <title>회원탈퇴</title>
 <style type="text/css">
body {
    background-color: #1473d3;
    text-align: center; /* 추가 */
}

table {
    width: 30%;
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



input[type="password"] {
    width: 100%;
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
 <script language="javascript">
 function begin(){
 document.myForm.pass.focus();
 }
 function checkIt(){
 if(!document.myForm.pass.value){
 alert("비밀번호를 입력하지 않았습니다");
 document.myForm.pass.focus();
 return false;
 }
 }
 </script>
 <body onload="begin()">
 <form name="myForm" method="post" 
action="deleteProc.jsp" onsubmit="return checkIt()">
 <table width="260" border="1" align="center">
 <tr>
 <td colspan="2" align="center">
 <b>회원 탈퇴</b>
 </td>
 </tr>
 <tr>
 <td width="150"><b>비밀번호</b></td>
 <td width="110">
 <input type="password" name="pass" size="15"></td>
 </tr>
 <tr>
 <td colspan="2" align="center">
 <input type="submit" value="회원탈퇴">
 <input type="button" value="취  소"
 onclick="javascript:window.location='index.jsp'">
 </td>
 </tr>
 </table>
 </form>
 </body>
 </html>