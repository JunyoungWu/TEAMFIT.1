package TeamFit2;
 
public class Instructor extends People {
	
	


	public Instructor(String name, String pnum, String id, String password, boolean teacher) {
		super(name, pnum, id, password, teacher);
	}

	private String subject;

	

	
	
	@Override
	public String getName() {
		return super.getName();
	}



	@Override
	public void setName(String name) {
		super.setName(name);
	}



	@Override
	public String getPnum() {
		return super.getPnum();
	}



	@Override
	public void setPnum(String pnum) {
		super.setPnum(pnum);
	}



	@Override
	public String getId() {
		return super.getId();
	}



	@Override
	public void setId(String id) {
		super.setId(id);
	}



	@Override
	public String getPassword() {
		return super.getPassword();
	}



	@Override
	public void setPassword(String password) {
		super.setPassword(password);
	}

	










	@Override
	public boolean isTeacher() {
		return super.isTeacher();
	}



	@Override
	public void setTeacher(boolean teacher) {
		super.setTeacher(teacher);
	}



	@Override
	public int hashCode() {
		return super.hashCode();
	}



	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}



	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
	
	
}
