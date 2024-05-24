package tf.model;

public class Exercise_ApplicationVO {
	 private int application_id;
	 private int user_code;
	 private int e_no;
	public Exercise_ApplicationVO(int application_id, int user_code, int e_no) {
		super();
		this.application_id = application_id;
		this.user_code = user_code;
		this.e_no = e_no;
	}
	public Exercise_ApplicationVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getApplication_id() {
		return application_id;
	}
	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}
	public int getUser_code() {
		return user_code;
	}
	public void setUser_code(int user_code) {
		this.user_code = user_code;
	}
	public int getE_no() {
		return e_no;
	}
	public void setE_no(int e_no) {
		this.e_no = e_no;
	}
	@Override
	public String toString() {
		return "Exercise_ApplicationVO [application_id=" + application_id + ", user_code=" + user_code + ", e_no="
				+ e_no + "]";
	}
	 
	 
}
