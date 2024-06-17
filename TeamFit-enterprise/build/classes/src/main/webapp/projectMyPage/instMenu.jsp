<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style >

  .navbar {
            display: flex;
            justify-content: center;
            gap: 20px;
            padding: 10px; 
            
            border-bottom: 1px solid #ccc; 
        }

        .navbar a {
            text-decoration: none;
            color: #333;
            padding: 10px 20px; 
           
            border: 1px solid #ccc; 
            border-radius: 4px;
        }

        .navbar a:hover {
            background-color: #ddd; /* 호버 시 버튼 배경색 */
        }
        h1 {
        	margin-left: 10px;
        	margin-top: 10px;
        }
</style>
<script type="text/javascript">
	
	function loadPage(page) {
		$.ajax({
			url : page,
			method : 'GET',
			success : function(data) {
				$('#content').html(data);
			},
			error : function() {
				$('#content').html('<p>Error loading page</p>');
			}
		});
	}
	
</script>
<title>Insert title here</title>
</head>
<body>	
	<h1>강사 메뉴</h1>
	<br>
 <div class="navbar">
        <span><a href="#" onclick="loadPage('listExercises.jsp')">운동 리스트</a></span>
        <span><a href="#" onclick="loadPage('addex.jsp')">운동 추가</a></span>
        <span><a href="#" onclick="loadPage('deleteExerciseForm.jsp')">운동 삭제</a></span>
        <span><a href="#" onclick="loadPage('manageMembers.jsp')">회원 관리</a></span>
        <span><a href="#" onclick="loadPage('deleteExerciseForm.jsp')">게시판 관리</a></span>
       <br> <br> <br>
    </div>
<br>
			
        <div id="content" >
        
        </div>
        
                
</body>
</html>