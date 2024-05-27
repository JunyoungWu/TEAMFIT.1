package tf.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tf.model.T_UserVO;

public class InstructorRegisterManager {
	public boolean checkInstructor(T_UserVO user) {
		InstructorDAO idao = new InstructorDAO();
		System.out.println("irm에서 상태 "+idao.setCheckInstructor(user));
		return idao.setCheckInstructor(user);
	}

}
