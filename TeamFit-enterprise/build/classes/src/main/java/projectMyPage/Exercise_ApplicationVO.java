package projectMyPage;

public class Exercise_ApplicationVO {
	int apNumber;
    int e_no;
    String id;
    
	public Exercise_ApplicationVO(int apNumber, int e_no, String idD) {
		super();
		this.apNumber = apNumber;
		this.e_no = e_no;
		this.id = idD;
	}
	public Exercise_ApplicationVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getApNumber() {
		return apNumber;
	}
	public void setApNumber(int apNumber) {
		this.apNumber = apNumber;
	}
	public int getE_no() {
		return e_no;
	}
	public void setE_no(int e_no) {
		this.e_no = e_no;
	}
	public String getId() {
		return id;
	}
	public void setIdD(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Exercise_ApplicationVO [apNumber=" + apNumber + ", e_no=" + e_no + ", id=" + id + "]";
	}
	
	
    
    
}
