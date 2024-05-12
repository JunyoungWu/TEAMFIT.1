package tf.model;
import java.util.Date;
public class ExerciseVO {
	int e_no;
	String	e_classCode; 		
	String	e_name; 			
	String  e_location;		
	Date e_date;			   
	int e_memNum;			
	String e_teacherName;		
	int e_price;
	
	
	

	
	public ExerciseVO(int e_no, String e_classCode, String e_name, String e_location, Date e_date, int e_memNum,
			String e_teacherName, int e_price) {
		super();
		this.e_no = e_no;
		this.e_classCode = e_classCode;
		this.e_name = e_name;
		this.e_location = e_location;
		this.e_date = e_date;
		this.e_memNum = e_memNum;
		this.e_teacherName = e_teacherName;
		this.e_price = e_price;
	}
	
	public ExerciseVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

	

	public Date getE_date() {
		return e_date;
	}

	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}

	public String getE_classCode() {
		return e_classCode;
	}
	public void setE_classCode(String e_classCode) {
		this.e_classCode = e_classCode;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_location() {
		return e_location;
	}
	public void setE_location(String e_location) {
		this.e_location = e_location;
	}
	
	public int getE_memNum() {
		return e_memNum;
	}
	public void setE_memNum(int e_memNum) {
		this.e_memNum = e_memNum;
	}
	public String getE_teacherName() {
		return e_teacherName;
	}
	public void setE_teacherName(String e_teacherName) {
		this.e_teacherName = e_teacherName;
	}
	public int getE_price() {
		return e_price;
	}
	public void setE_price(int e_price) {
		this.e_price = e_price;
	}

	@Override
	public String toString() {
		return "[e_no=" + e_no + ", e_classCode=" + e_classCode + ", e_name=" + e_name + ", e_location="
				+ e_location + ", e_date=" + e_date + ", e_memNum=" + e_memNum + ", e_teacherName=" + e_teacherName
				+ ", e_price=" + e_price + "]";
	}		
	
}
