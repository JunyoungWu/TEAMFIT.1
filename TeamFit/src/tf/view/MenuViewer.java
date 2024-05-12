package tf.view;

import java.util.Scanner;

public class MenuViewer {
	
	public static Scanner choice = new Scanner(System.in);

	public static void logIn() {
		
	}
	public static void mainMenuView() {
		
		System.out.println("1. 마이페이지 2. 강사 메뉴 3. 운동 신청 4.운동 삭제 5. 정보수정 6. 종료");
		System.out.println();
		System.out.print("메뉴 번호를 선택해주세요 : ");
	}
	public static void myPageView() {
		System.out.println();
        System.out.println("1. 정보수정 2. 내 운동 리스트 3.담당 강사 정보  4. 계정삭제 5. 메인 메뉴로 돌아가기");
        System.out.print("메뉴를 선택해주세요 : ");
	}
	
	public static void myPageEditView() {
		System.out.println();
		System.out.println("수정할 정보를 선택해주세요");
		System.out.println();
		System.out.print("1.연락처 2. 비밀번호 3. 종료");
	}
	
	public static void exerciseMenuView() {
		System.out.println("1. 운동리스트 2. 운동추가 3. 운동 삭제 4.종료");
		System.out.println();
		System.out.print("메뉴 번호를 선택해주세요 : ");
	}
}
