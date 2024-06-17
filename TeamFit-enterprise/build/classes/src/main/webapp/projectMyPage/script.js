function idCheck(id) {
	if (id == "") {
		alert("아이디를 입력해 주세요.");
		document.regForm.id.focus();
	} else {
		console.log("idCheck 함수 호출됨, ID:", id);  // 디버깅을 위한 로그
		url = "idCheck.jsp?id=" + id;
		window.open(url, "post", "width=300,height=150");
	}
}


function zipCheck() {
	url = "zipCheck.jsp?check=y";
	window.open(url, "post", "toolbar=no ,width=500 ,height=300 , directories = no, status = yes, scrollbars = yes, menubar = no");
}
 function writeSave(){
 if(document.writeForm.writer.value==""){
  alert("작성자를 입력하십시요.");
  document.writeForm.writer.focus();
  return false;
 }
 if(document.writeForm.subject.value==""){
  alert("제목을 입력하십시요.");
  document.writeForm.subject.focus();
  return false;
 }
 if(document.writeForm.content.value==""){
  alert("내용을 입력하십시요.");
  document.writeForm.content.focus();
  return false;
 }
        
if(document.writeForm.pass.value==""){
  alert(" 비밀번호를 입력하십시요.");
  document.writeForm.pass.focus();
  return false;
 }
 }   
function updateCheck() {
	if (document.regForm.pass.value == "") {
		alert("비밀번호를 입력해 주세요.");
		document.regForm.pass.focus();
		return;
	}
	if (document.regForm.repass.value == "") {
		alert("비밀번호를 확인해 주세요");
		document.regForm.repass.focus();
		return;
	}
	if (document.regForm.pass.value !=
		document.regForm.repass.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.regForm.repass.focus();
		return;
	}
	if (document.regForm.phone1.value == "") {
		alert("통신사를 입력해 주세요.");
		document.regForm.phone1.focus();
		return;
	}
	if (document.regForm.phone2.value == "") {
		alert("전화번호을 입력해 주세요.");
		document.regForm.phone2.focus();
		return;
	}
	if (document.regForm.phone3.value == "") {
		alert("전화번호을 입력해 주세요.");
		document.regForm.phone3.focus();
		return;
	}
	if (document.regForm.email.value == "") {
		alert("이메일을 입력해 주세요.");
		document.regForm.email.focus();
		return;
	}
	var str = document.regForm.email.value;
	var atPos = str.indexOf('@');
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;
	if (atPos > 1 && atPos == atLastPos &&
		dotPos > 3 && spacePos == -1 && commaPos == -1
		&& atPos + 1 < dotPos && dotPos + 1 < eMailSize);
	else {
		alert('E-mail주소 형식이 잘못되었습니다.\n\r다시 입력해 주세요!');
		document.regForm.email.focus();
		return;
	}
	if (document.regForm.zipcode.value == "") {
		alert("우편번호를 입력해 주세요.");
		document.regForm.zipcode.focus();
		return;
	}
	if (document.regForm.address1.value == "") {
		alert("주소를 입력해 주세요.");
		document.regForm.address1.focus();
		return;
	}
	if (document.regForm.address2.value == "") {
		alert("세부주소를 입력해 주세요.");
		document.regForm.address2.focus();
		return;
	}
	document.regForm.submit();
}

function call_js() {
	//화면객체참조변수지정
	let slideshow = document.querySelector('.slideshow');
	let slideshowSlides = document.querySelector('.slideshow_slides');
	let slides = document.querySelectorAll('.slideshow_slides a');
	let prev = document.querySelector('.prev');
	let next = document.querySelector('.next');
	let indicators = document.querySelectorAll('.indicator a');
	let currentIndex = 0;
	let timer = "";
	let slideCount = slides.length;

	for (let i = 0; i < slides.length; i++) {
		let newLeft = i * 100 + '%';
		slides[i].style.left = newLeft;
	}

	function gotoSlide(index) {
		currentIndex = index;
		let newLeft = index * -100 + '%';
		slideshowSlides.style.left = newLeft;
		indicators.forEach((obj) => {
			obj.classList.remove('active');
		});
		indicators[index].classList.add('active');
	}

	gotoSlide(0);

	//3초마다 함수를 부른다.
	function startTimer() {
		timer = setInterval(function() {
			let nextIndex = (currentIndex + 1) % slideCount;
			gotoSlide(nextIndex);
		}, 3000)
	}
	startTimer();

	// 마우스포인터 slideshowSlides 들어오면 타이머를 멈춘다. 
	slideshowSlides.addEventListener('mouseenter', () => {
		clearInterval(timer);
	})
	slideshowSlides.addEventListener('mouseleave', function() {
		startTimer();
	})
	prev.addEventListener('mouseenter', () => {
		clearInterval(timer);
	})
	next.addEventListener('mouseenter', () => {
		clearInterval(timer);
	})
	//prev , next 이벤트설정
	prev.addEventListener('click', (e) => {
		e.preventDefault(); //a tag 가지고 기본기능 막는다.
		currentIndex = currentIndex - 1;
		if (currentIndex < 0) {
			currentIndex = 3;
		}
		gotoSlide(currentIndex);
	});

	next.addEventListener('click', (e) => {
		e.preventDefault(); //a tag 가지고 기본기능 막는다.
		currentIndex = currentIndex + 1;
		if (currentIndex > 3) {
			currentIndex = 0;
		}
		gotoSlide(currentIndex);
	});

	//indicator click 해당화면으로이동
	indicators.forEach((obj) => {
		obj.addEventListener('mouseenter', () => {
			clearInterval(timer);
		});
	});

	for (let i = 0; i < indicators.length; i++) {
		indicators[i].addEventListener('click', (e) => {
			e.preventDefault();
			gotoSlide(i);
		});
	}

}

function e_inputCheck() {
	if (document.addex.e_name.value == "") {
		alert("운동이름을 입력해 주세요.");
		document.addex.e_name.focus();
		return;
	}
	if (document.addex.e_location.value == "") {
		alert("운동 장소를 입력해 주세요.");
		document.addex.e_location.focus();
		return;
	}
	if (document.addex.e_date.value == "") {
		alert("운동 날짜를 입력해 주세요");
		document.addex.e_date.focus();
		return;
	}
	if (document.addex.e_memnum.value !=
		document.addex.e_memnum.value) {
		alert("인원수를 입력해주세요");
		document.addex.e_memnum.focus();
		return;
	}
	if (document.addex.e_price.value == "") {
		alert("가격을 입력해 주세요.");
		document.addex.e_price.focus();
		return;
	}
	
	document.addex.submit();
}
function inputCheck() {
	if (document.regForm.id.value == "") {
		alert("아이디를 입력해 주세요.");
		document.regForm.id.focus();
		return;
	}
	if (document.regForm.pass.value == "") {
		alert("비밀번호를 입력해 주세요.");
		document.regForm.pass.focus();
		return;
	}
	if (document.regForm.repass.value == "") {
		alert("비밀번호를 확인해 주세요");
		document.regForm.repass.focus();
		return;
	}
	if (document.regForm.pass.value !=
		document.regForm.repass.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.regForm.repass.focus();
		return;
	}
	if (document.regForm.name.value == "") {
		alert("이름을 입력해 주세요.");
		document.regForm.name.focus();
		return;
	}
	if (document.regForm.phone1.value == "") {
		alert("통신사를 입력해 주세요.");
		document.regForm.phone1.focus();
		return;
	}
	if (document.regForm.phone2.value == "") {
		alert("전화번호을 입력해 주세요.");
		document.regForm.phone2.focus();
		return;
	}
	if (document.regForm.phone3.value == "") {
		alert("전화번호을 입력해 주세요.");
		document.regForm.phone3.focus();
		return;
	}
	if (document.regForm.email.value == "") {
		alert("이메일을 입력해 주세요.");
		document.regForm.email.focus();
		return;
	}
	var str = document.regForm.email.value;
	var atPos = str.indexOf('@');
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;
	if (atPos > 1 && atPos == atLastPos &&
		dotPos > 3 && spacePos == -1 && commaPos == -1
		&& atPos + 1 < dotPos && dotPos + 1 < eMailSize);
	else {
		alert('E-mail주소 형식이 잘못되었습니다.\n\r다시 입력해 주세요!');
		document.regForm.email.focus();
		return;
	}
	if (document.regForm.zipcode.value == "") {
		alert("우편번호를 입력해 주세요.");
		document.regForm.zipcode.focus();
		return;
	}
	if (document.regForm.address1.value == "") {
		alert("주소를 입력해 주세요.");
		document.regForm.address1.focus();
		return;
	}
	if (document.regForm.address2.value == "") {
		alert("세부주소를 입력해 주세요.");
		document.regForm.address2.focus();
		return;
	}
	document.regForm.submit();
}
