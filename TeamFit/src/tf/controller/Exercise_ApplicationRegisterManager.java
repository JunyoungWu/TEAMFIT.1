package tf.controller;

import java.util.Scanner;
import tf.model.T_UserVO;

public class Exercise_ApplicationRegisterManager {
    public static Scanner input = new Scanner(System.in);

    public void applyExercise(T_UserVO user) {
        Exercise_ApplicationDAO eaad = new Exercise_ApplicationDAO();
        ExerciseDAO edo = new ExerciseDAO();

        edo.getExerciseTotalList();

        System.out.print("신청할 운동의 코드를 입력해주세요 > ");
        String code = input.nextLine();
        eaad.addExerciseApplication(user.getT_user_code(), code);
    }

    public void pirntUserExerciseList(T_UserVO user) {
        Exercise_ApplicationDAO ead = new Exercise_ApplicationDAO();
        ead.setPrintUserExerciseList(user.getT_user_code());
    }

    public void deleteExerciseApplication(T_UserVO user) {
        Exercise_ApplicationDAO eado = new Exercise_ApplicationDAO();

        int userCode = user.getT_user_code();
        System.out.print("삭제할 운동의 코드를 입력해주세요 > ");
        String eClassCode = input.nextLine();
        eado.setDeleteExerciseApplication(userCode, eClassCode);
    }
}
