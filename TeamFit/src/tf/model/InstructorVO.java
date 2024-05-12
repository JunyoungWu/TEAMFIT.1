package tf.model;

public class InstructorVO {
	 String t_teacher;
     int t_user_code;
     String t_t_password;
     
     
     
	public InstructorVO() {
		super();
	}



	public InstructorVO(String t_teacher, int user_code, String t_t_password) {
		super();
		this.t_teacher = t_teacher;
		this.t_user_code = user_code;
		this.t_t_password = t_t_password;
	}



	public String getT_teacher() {
		return t_teacher;
	}



	public void setT_teacher(String t_teacher) {
		this.t_teacher = t_teacher;
	}



	public int getUser_code() {
		return t_user_code;
	}



	public void setUser_code(int user_code) {
		this.t_user_code = user_code;
	}



	public String getT_t_password() {
		return t_t_password;
	}



	public void setT_t_password(String t_t_password) {
		this.t_t_password = t_t_password;
	}
	
	
     
	
	 
	 
}
