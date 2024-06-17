<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="projectMyPage.*"%>
<%
    ExerciseDAO dao = ExerciseDAO.getInstance();
%>
<link href="style.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="script.js"></script>



<form method="post" action="addexProc.jsp" name="addex" >
		
    <table style="margin-left: 5%">
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
            <td colspan="2" align="center"><input type="button" value="운동등록" onclick="e_inputCheck()" />&nbsp;&nbsp; <input type="reset" value="다시입력" /></td>
        </tr>
    </table>
</form>


