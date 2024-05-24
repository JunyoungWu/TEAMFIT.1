package tf.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import tf.controller.ExerciseDAO;
import tf.model.ExerciseVO;

public class ExerciseRegisterManager {
	public static Scanner input = new Scanner(System.in);
	public void exerciseList() {
		ExerciseDAO ed = new ExerciseDAO();
		System.out.println("전체 운동 리스트 ");
		ed.getExerciseTotalList();
		System.out.println();
	}

	public void exerciseDelete() {
		
		ExerciseDAO ed = new ExerciseDAO();
		
		
		System.out.println("전체 운동 리스트");
		ed.getExerciseTotalList();
		System.out.println();
		System.out.println("삭제할 운동 일련 번호 입력");
		System.out.print("일련 번호 : ");
		int e_no = input.nextInt();
		
		ed.deleteExercise(e_no);
		
		System.out.println("전체 운동 리스트");
		ed.getExerciseTotalList();
		System.out.println();
		
		
	}

	public void exerciseApply() {
		Scanner input = new Scanner(System.in);
		ExerciseDAO ed = new ExerciseDAO();
		ExerciseVO evo = new ExerciseVO();
		int e_no;
		String e_classCode;
		String e_name;
		String e_location;
		Date e_date = null;
		int e_memNum;
		String e_teacherName;
		int e_price;
		System.out.println("전체 리스트");
		ed.getExerciseTotalList();
		System.out.println();
		System.out.println("운동 정보 입력");
		System.out.print("운동코드 : ");
		e_classCode = input.nextLine();
		System.out.print("운동명 : ");
		e_name = input.nextLine();
		System.out.print("운동장소 : ");
		e_location = input.nextLine();
		System.out.print("운동명(YYYY/MM/DD) : ");
		String dateString = input.nextLine();
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			e_date = format.parse(dateString); // 문자열을 Date 객체로 변환
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("잘못된 형식의 날짜입니다.");
			return; // 날짜 형식이 잘못되면 함수 종료
		}
		System.out.print("운동인원수 : ");
		e_memNum = input.nextInt();
		input.nextLine();
		System.out.print("강사명 : ");
		e_teacherName = input.nextLine();
		System.out.print("가격 : ");
		e_price = input.nextInt();
		evo.setE_classCode(e_classCode);
		evo.setE_name(e_name);
		evo.setE_location(e_location);
		evo.setE_date(e_date);
		evo.setE_memNum(e_memNum);
		evo.setE_teacherName(e_teacherName);
		evo.setE_price(e_price);
		ed.setExerciseApply(evo);
		System.out.println();
		System.out.println("학과 전체 리스트");
		ed.getExerciseTotalList();
		System.out.println();
	}
}
