package TeamFit2;


import java.util.Comparator;
import java.util.Objects;

public class People implements Comparator<People>{
	private String name;
	private String pnum;
	private String id;
	private String password;
	private boolean teacher;
	
	
	public People(String name, String pnum, String id, String password, boolean teacher) {
		super();
		this.name = name;
		this.pnum = pnum;
		this.id = id;
		this.password = password;
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public boolean isTeacher() {
		return teacher;
	}

	public void setTeacher(boolean teacher) {
		this.teacher = teacher;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pnum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		return Objects.equals(pnum, other.pnum);
	}

	@Override
	public String toString() {
		return "[이름 = " + name + ", 연락처 = " + pnum + ", ID = " + id +  "]";
	}

	@Override
	public int compare(People o1, People o2) {
		
		return o2.getPnum().compareTo(o1.getPnum());
	}
	
	
	
	
}
