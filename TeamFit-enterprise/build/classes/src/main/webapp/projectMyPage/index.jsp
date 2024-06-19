<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%
String loginID = (String) session.getAttribute("loginID");
String check = (String) session.getAttribute("check");

%>
<html>
<head>
<script language="javascript" src="script.js"></script>
 <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://kit.fontawesome.com/dd1c09ef10.js" crossorigin="anonymous"></script>
<title>Main Site</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	var insloginID = '<%= loginID %>';
	var check = '<%= check %>';
	
	   function loadPage(page) {
	        $.ajax({
	            url: page,
	            method: 'GET',
	            success: function(data) {
	                $('#content').html(data);
	                $('#slideshow').hide(); // 슬라이드쇼 숨기기
	            },
	            error: function() {
	                $('#content').html('<p>Error loading page</p>');
	            }
	        });
	    }
	function handleInstructorMenuClick() {
        if (insloginID != null) {
          	var checkins = insloginID;
            loadPage('instMenu.jsp', '.middle');
        } else {
        	  alert("강사만 이용할 수 있는 메뉴입니다.");
        }
    }
</script>

<style>
.slideshow {
	border-radius:15px;
	background-color: #569ee6;
	height: 465px;
	width : 90%;
	margin-left:5%;
	min-width: 900px;
	position: relative;
	 overflow: hidden; 
}
 .footer {
            text-align: center;
        }
.slideshow_slides {
	position: absolute;
	width: 100%;
	height: 100%;
}
/* 4장의 이미지를 기준점으로 모두 이동 */
.slideshow_slides a {
	border-radius: 15px;
	position: absolute;
	width: 100%;
	height: 100%;
	text-align: center;
	display: inline-block;
}
/*네비게이션네브바를 중앙에 배치*/
.slideshow_nav a {
	position: absolute;
	left: 50%;
	top: 50%;
	color: #fff;
	font-size: 62px;
	transform: translateY(-50%);
	opacity: 0.5;
}
/* 중앙을기점으로 좌우 이동 */
.slideshow_nav a.prev {
	margin-left: -462px;
}

.slideshow_nav a.next {
	margin-left: 400px;
}
/* 인디게이터를 슬라이드쇼 아래 중앙위치 배치 */
.indicator {
	position: absolute;
	left: 0;
	right: 0;
	bottom: 20px;
	text-align: center;
}

.indicator a {
	display: inline-block;
	padding: 5px;
	font-size: 24px;
	color: #1473d3;
	opacity: 0.8;
}

.indicator a.active {
	color: rgb(255, 162, 0);
}

html, body {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	box-sizing: border-box;
	background-color: #1473d3;
}

header {
	display: flex;
	justify-content: space-between;
	padding: 10px;
	background-color: #569ee6; /* 예시 배경색 */
	width: 90%;
	margin-left: 5%;
	margin-top: 1%;
	box-sizing: border-box;
	border-radius: 10px;
}

.mid {
	margin-right: 580px;
	
}
.right {
font-size: 13px;
	display: flex;
	align-items: center;
}

.right span {
	margin-left: 10px;
	margin-bottom: 60px;
}
.mid a {
  border: 2px solid rgb(138, 175, 231);
  border-radius: 30px;
  color: black;
  font-size: 15px;
  text-decoration: none;
  padding: 10px 20px; /* 상하 10px, 좌우 20px의 패딩을 설정 */
  display: inline-block; /* a 요소를 블록 요소처럼 취급하되, 줄바꿈은 일어나지 않도록 설정 */
  box-sizing: border-box; /* 패딩과 보더를 포함하여 크기를 계산 */
}
#content {
    background-color: #569ee6;
    text-align: center;
    width: 90%;
    margin-left: 5%;
    margin-right: 5%; /* 추가 */
    border-radius: 10px;
    padding: 20px;
    box-sizing: border-box; /* 추가 */
}
.middle {
	width: 90%;
	background-color: #1473d3; 
	margin-left:5%; 
}

* {
	box-sizing: border-box;
}
</style>
</head>
<body onload="call_js()">
	<header>
		<img onclick="location.href = 'index.jsp';" src="./image/TeamFit.png" style="width: 150px; height: 80px;" alt="" />

		<%
		if (loginID != null && ("강사".equals(check))) {
		%>
		<div class="mid">
            <a href="#" onclick="handleInstructorMenuClick()">강사 메뉴</a>&nbsp;&nbsp;
            <a href="#" onclick="loadPage('addApplication.jsp')">운동 신청</a>&nbsp;&nbsp;
            <a href="#" onclick="loadPage('deleteExerciseForm.jsp')">운동 삭제</a>&nbsp;&nbsp;
            <a href="list.jsp" >문의 게시판</a>&nbsp;&nbsp;
           
        </div>
		<div class="right">
			<span><%=loginID%>님 환영합니다.</span> 
			<span><a href="#" onclick="loadPage('modifyForm.jsp')">정보수정</a></span> 
			<span><a href="#" onclick="loadPage('deleteForm.jsp')">회원탈퇴</a></span> 
			<span><a href="logout.jsp">로그아웃</a></span>
		</div>
		<%
		} else if (loginID != null && ("회원".equals(check))) {
		%>
			<div class="mid">
           
            <a href="#" onclick="loadPage('addApplication.jsp')">운동 신청</a>&nbsp;&nbsp;
            <a href="#"  onclick="loadPage('delApplication.jsp')" >운동 삭제</a>&nbsp;&nbsp;
           <a href="list.jsp" >문의 게시판</a>&nbsp;&nbsp;
        </div>
        		<div class="right">
			<span><%=loginID%>님 환영합니다.</span> 
			<span><a href="#" onclick="loadPage('modifyForm.jsp')">정보수정</a></span> 
			<span><a href="#" onclick="loadPage('deleteForm.jsp')">회원탈퇴</a></span> 
			<span><a href="logout.jsp">로그아웃</a></span>
		</div>
		<%
		}else {
		%>
		<div>
			<input type="button" value="로그인" onclick="loadPage('login.jsp')" />
			<input type="button" value="강사 로그인" onclick="loadPage('inslogin.jsp')" />
			<input type="button" value="회원가입" onclick="loadPage('regForm.jsp')" />
		</div>
		<% } %>
		
	</header>
	<hr>
	  <div id="content" >
	  
	  </div>
	<div  id="slideshow" class="slideshow">
		<div class="slideshow_slides">
			<a href="#"><img src="./image/slide-1.jpg" alt="slide1" /></a>
			<a href="#"><img src="./image/slide-2.jpg" alt="slide1" /></a>
			<a href="#"><img src="./image/slide-3.jpg" alt="slide1" /></a>
			<a href="#"><img src="./image/slide-4.jpg" alt="slide1" /></a>
		</div>
		<div class="slideshow_nav">
			<a href="#" class="prev"><i class="fa-solid fa-circle-chevron-left"></i></a>
			<a href="#" class="next"><i class="fa-solid fa-circle-chevron-right"></i></a>
		</div>
		<div class="indicator">
			<a href="#" class="active"><i class="fa-solid fa-circle-dot"></i></a>
			<a href="#"><i class="fa-solid fa-circle-dot"></i></a>
			<a href="#"><i class="fa-solid fa-circle-dot"></i></a>
			<a href="#"><i class="fa-solid fa-circle-dot"></i></a>
		</div>
		<br>
	</div>
	<hr>
	  <footer>
            <div class="footer content1">
                <a href="">다운로드</a>
                <a href="">개인정보처리방침</a>
                <a href="">신고</a>
                <a href="">이메일무단수집거부</a>
            </div>
            <div  class="footer content2">
                <p>팀피트컴퍼니 : 서울시 성동구 무학로2길 54 신방빌딩 4,5층 tel:012-345-7890</p>
                <p>
                    Copyright <span>ⓒ</span> 2018 tmft, Inc. All right reserved. 
                    Adress: 23-455-1234
                </p>
            </div>
        </footer>
</body>
</html>
