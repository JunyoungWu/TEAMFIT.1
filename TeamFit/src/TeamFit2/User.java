package TeamFit2;

public class User extends People  {

	String teacherName;

	

	public User(String name, String pnum, String id, String password, boolean teacher, String teacherName) {
		super(name, pnum, id, password, teacher);
		this.teacherName=teacherName;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public String getPnum() {
		// TODO Auto-generated method stub
		return super.getPnum();
	}

	@Override
	public void setPnum(String pnum) {
		// TODO Auto-generated method stub
		super.setPnum(pnum);
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}


	

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+", "+getTeacherName();
	}
	
	
	
	
	

}
