package tf.view;

import java.sql.Connection;
import java.util.Scanner;

import tf.view.EXERCISE_MENU_CHOICE;
import tf.controller.DBUtil;
import tf.controller.ExerciseRegisterManager;
import tf.controller.Exercise_ApplicationRegisterManager;
import tf.controller.InstructorRegisterManager;
import tf.controller.T_UserDAO;
import tf.controller.T_UserRegisterManager;
import tf.model.T_UserVO;
import tf.view.MAIN_MENU_CHOICE;
import tf.view.MenuViewer;

public class TeamFitMain {
	public static T_UserVO user = null;
	public static boolean instructor = false;
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		Connection con = DBUtil.makeConnections();
		start();
		
		mainMenu();
		

	}

	private static void start() {
		T_UserRegisterManager t_UserRegisterManager = new T_UserRegisterManager();
		InstructorRegisterManager instructorRegisterManager = new InstructorRegisterManager();
		
		
		  for (;;) {
		        System.out.print("기존 회원이십니까? (Y/N) > ");
		        String a = input.nextLine();
		        if (a.toUpperCase().equals("Y")) {
		            user = t_UserRegisterManager.login();
		            if (user != null) {
		                boolean isInstructor = instructorRegisterManager.checkInstructor(user);
		                System.out.println("isInstructor 상태: " + isInstructor);
		                instructor = true;
		                break;
		            }
		        } else if (a.toUpperCase().equals("N")) {
		            t_UserRegisterManager.registerUser();
		        } else {
		            System.out.println("올바른값을 입력해주세요");
		        }
		    }
		
		
		
		
		
	}
	private static void userPage () {
		
	} 

	private static void mainMenu() {
		int choiceNum;
		while (true) {
			try {
				MenuViewer.mainMenuView();
				choiceNum = MenuViewer.choice.nextInt();
				MenuViewer.choice.nextLine();
				switch (choiceNum) {
				case MAIN_MENU_CHOICE.MYPAGE:
					myPageMenu();
					break;
				case MAIN_MENU_CHOICE.INS_MENU:
					exerciseMenu();
					break;
				case MAIN_MENU_CHOICE.APPLY_MENU:
					applyEx();
					break;
				case MAIN_MENU_CHOICE.EDIT_MENU:
					edit();
					break;
					
				case MAIN_MENU_CHOICE.DELETE_MENU:
					delEx();
					break;
				case MAIN_MENU_CHOICE.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;

				default:
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을	다시 시작하세요.");
				return; // ELF PSY KONG GRU
			}
		}

	}

	private static void edit() {
		T_UserRegisterManager turm = new T_UserRegisterManager();
		turm.changeUserInfo(user);
	}

	private static void delEx() {
		Exercise_ApplicationRegisterManager earp = new Exercise_ApplicationRegisterManager();
		earp.pirntUserExerciseList(user);
		earp.deleteExerciseApplication(user);
		
	}

	private static void applyEx() {
		Exercise_ApplicationRegisterManager earm = new Exercise_ApplicationRegisterManager();
		earm.applyExercise(user);
	}

	private static void exerciseMenu() {
		if(instructor == true) {
			int choice;
			ExerciseRegisterManager exerciseregistermanager = new ExerciseRegisterManager();
			MenuViewer.exerciseMenuView();
			choice = MenuViewer.choice.nextInt();
			MenuViewer.choice.nextLine();
			switch (choice) {
			case EXERCISE_MENU_CHOICE.LIST:
				System.out.println("");
				exerciseregistermanager.exerciseList();
				break;
			case EXERCISE_MENU_CHOICE.APPLY:
				System.out.println("");
				exerciseregistermanager.exerciseApply();
				break;
				
			case EXERCISE_MENU_CHOICE.DELETE:
				System.out.println("");
				exerciseregistermanager.exerciseDelete();
				break;

			case EXERCISE_MENU_CHOICE.MAIN:
				return;
			default:
				System.out.println("해당 메뉴 번호만 입력하세요.");

			}
		}else {
			System.out.println("강사만 이용 가능합니다");
		}
		
	}

	private static void myPageMenu() {
		T_UserRegisterManager t_UserRegisterManager = new T_UserRegisterManager();
		Exercise_ApplicationRegisterManager earp = new Exercise_ApplicationRegisterManager();
		t_UserRegisterManager.userPage(user);
		earp.pirntUserExerciseList(user);
		
		

	}
	

}
