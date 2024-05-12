package tf.model;

public class T_UserVO {
	int t_user_code;  
    String t_name;
	String t_pnum;    
	String t_id;         
	String t_password;  
    String t_teacherName;
    
	public T_UserVO(int t_user_code, String t_name, String t_pnum, String t_id, String t_password,
			String t_teacherName) {
		super();
		this.t_user_code = t_user_code;
		this.t_name = t_name;
		this.t_pnum = t_pnum;
		this.t_id = t_id;
		this.t_password = t_password;
		this.t_teacherName = t_teacherName;
	}
	public T_UserVO() {
		super();
	
	}
	public int getT_user_code() {
		return t_user_code;
	}
	public void setT_user_code(int t_user_code) {
		this.t_user_code = t_user_code;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_pnum() {
		return t_pnum;
	}
	public void setT_pnum(String t_pnum) {
		this.t_pnum = t_pnum;
	}
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public String getT_password() {
		return t_password;
	}
	public void setT_password(String t_password) {
		this.t_password = t_password;
	}
	public String getT_teacherName() {
		return t_teacherName;
	}
	public void setT_teacherName(String t_teacherName) {
		this.t_teacherName = t_teacherName;
	}
	@Override
	public String toString() {
		return "[유저코드=" + t_user_code + ", 이름=" + t_name + ", 전화번호=" + t_pnum + ", 아이디=" + t_id
				+ ",   t_teacherName=" + t_teacherName + "]";
	}
    
    
    
    
}
