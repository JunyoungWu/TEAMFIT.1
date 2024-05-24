package tf.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tf.model.T_UserVO;

public class InstructorRegisterManager {
	public boolean checkInstructor(T_UserVO user) {
		InstructorDAO idao = new InstructorDAO();
	
		return idao.setCheckInstructor(user);
	}

}
