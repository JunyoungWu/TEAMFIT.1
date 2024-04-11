package TeamFit2;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Exercise implements Comparator<Exercise>, Serializable {
	private String classCode; 		//강의코드
	
	private String name; 			//운동이름
	
	private String location;		//위치
	private String date;			//날짜
	private int memNum;			//인원수
	private String teacherName;		//강사명
	private int price;				//기격
	
	
	
	public Exercise(String classCode, String name, String location, String date, int memNum,
			String teacherName, int price) {
		super();
		this.classCode = classCode;
	
		this.name = name;
		this.location = location;
		this.date = date;
		this.memNum = memNum;
		this.teacherName = teacherName;
		this.price = price;
	}
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(classCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercise other = (Exercise) obj;
		return Objects.equals(classCode, other.classCode);
	}
	@Override
	public String toString() {
		return "[운동코드 = " + classCode + ", 운동 이름 = " + name + ", 장소 = " + location
				+ ", 날짜 = " + date + ", 최대 인원 수 = " + memNum + ", 담당 강사  = " + teacherName + ", 가격 = " + price + "]";
	}
	@Override
	public int compare(Exercise o1, Exercise o2) {
		
		
		return o2.getClassCode().compareTo(o1.getClassCode());
	}

	
}
