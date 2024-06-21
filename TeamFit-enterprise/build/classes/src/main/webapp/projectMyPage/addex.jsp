<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="projectMyPage.*"%>
<%
    ExerciseDAO dao = ExerciseDAO.getInstance();
%>
<%
String loginID = (String) session.getAttribute("loginID");
String check = "게스트";
if(session.getAttribute("check")!=null){
	check = (String) session.getAttribute("check");
}
%>
 <head>
 
<title>운동 추가</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/projectMyPage/css/style.css">
 <script language="javascript" src="script.js"></script>
 <style type="text/css">
 input[type="text"]{
	  width: calc(100% - 20px);
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
}
 </style>
</head>




<form class="addExercise" method="post" action="addexProc.jsp" name="addex" >
		
    <table  style="margin: 0 auto; width: 50%;">
        <tr>
            <td colspan="2" align="center">운동 정보 입력</td>
        </tr>
        <tr>
            <td align="right">운동명 :</td>
            <td>
                <input type="text" name="e_name" id="e_name" />&nbsp; 
            </td>
        </tr>
        <tr>
            <td align="right">장소 :</td>
            <td><input type="text" name="e_location" id="e_location" /></td>
        </tr>
       
        <tr>
            <td align="right">날짜 :</td>
            <td><input type="text" name="e_date" id="e_date" /></td>
        </tr>
        <tr>
            <td align="right">운동인원 :</td>
            <td><input type="text" name="e_memnum" id="e_memnum" /></td>
        </tr>
        <tr>
            <td align="right">가격 :</td>
            <td><input type="text" name="e_price" id="e_price" /></td>
        </tr>
       
        <tr>
            <td colspan="2" align="center"><input type="button" value="운동등록" onclick="e_inputCheck()" /></td>
        </tr>
    </table>
</form>



