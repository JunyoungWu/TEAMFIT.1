package TeamFit2;

import java.util.ArrayList;



public interface ExerciseInterface {
	void printExerciseList(ArrayList<Exercise> exerciselist);
	boolean isCartInExercise(String id);	//장바구니에담긴 개수를 1씩 증가
	void insertExercise(Exercise p);			//CartItem에 도서 정보를 등록
	void removeCart(String classCode);			//장바구니 클래스코드 항목을 삭제 
	void delAllExercise();					//장바구니의 모든항목 삭제
}
