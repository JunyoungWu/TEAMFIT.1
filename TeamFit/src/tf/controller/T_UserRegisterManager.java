package tf.controller;

import java.util.Scanner;

import tf.model.ExerciseVO;
import tf.model.T_UserVO;

public class T_UserRegisterManager {

	public void registerUser() {
		Scanner input = new Scanner(System.in);
		T_UserDAO userDAO = new T_UserDAO();
		T_UserVO uVo = new T_UserVO();

		
		String t_name;
		String t_pnum;
		String t_id;
		String t_password;
		
		System.out.print("이름 : ");
		t_name = input.nextLine();
		System.out.print("전화번호 : ");
		t_pnum = input.nextLine();
		System.out.print("아이디 : ");
		t_id = input.nextLine();
		System.out.print("비밀번호 : ");
		t_password = input.nextLine();
		uVo.setT_name(t_name);
		uVo.setT_pnum(t_pnum);
		uVo.setT_id(t_id);
		uVo.setT_password(t_password);
		userDAO.setRegisterUser(t_id, t_password, t_name, t_pnum);
		
		
		
		
		
	}
	
	public void addUserTeacher (T_UserVO user) {
		 T_UserDAO userDAO = new T_UserDAO();
		Scanner input = new Scanner(System.in);
		System.out.print("신청할 강사의 이름을 입력해주세요 : ");
		String teacherName = input.nextLine();
		userDAO.setAddUserTeacher(user.getT_user_code(), teacherName);
		
	}
	 public void changeUserInfo(T_UserVO user) {
	        Scanner input = new Scanner(System.in);
	        T_UserDAO userDAO = new T_UserDAO();

	        System.out.print("새 전화번호를 입력하세요: ");
	        String newPhoneNumber = input.nextLine();

	        System.out.print("새 비밀번호를 입력하세요: ");
	        String newPassword = input.nextLine();

	        boolean success = userDAO.updateUserInfo(user.getT_user_code(), newPhoneNumber, newPassword);
	        if (success) {
	            // 변경 성공
	            user.setT_pnum(newPhoneNumber);
	            user.setT_password(newPassword);
	        } 
	    }

	public T_UserVO login() {
	    Scanner input = new Scanner(System.in);
	    T_UserDAO userDAO = new T_UserDAO();
	    
	    System.out.println("아이디를 입력하세요: ");
	    String userID = input.nextLine();

	    System.out.println("비밀번호를 입력하세요: ");
	    String password = input.nextLine();

	    T_UserVO loggedInUser = userDAO.setLoginUser(userID, password);

	    return loggedInUser;
	}
	
	public void userPage (T_UserVO user) {
		  T_UserDAO userDAO = new T_UserDAO();
		  userDAO.setUserData(user.getT_id(), user.getT_password());
		  
	}

}
