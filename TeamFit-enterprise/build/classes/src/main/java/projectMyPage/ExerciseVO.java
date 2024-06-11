package projectMyPage;

public class ExerciseVO {
	private int e_no;
    private String e_name;
    private String e_location;
    private String e_date;
    private String e_memnum;
    private String e_price;
    
    
    
	public ExerciseVO() {
		super();
		
	}



	public ExerciseVO(int e_no, String e_name, String e_location, String e_date, String e_memnum, String e_price) {
		super();
		this.e_no = e_no;
		this.e_name = e_name;
		this.e_location = e_location;
		this.e_date = e_date;
		this.e_memnum = e_memnum;
		this.e_price = e_price;
	}



	public int getE_no() {
		return e_no;
	}



	public void setE_no(int e_no) {
		this.e_no = e_no;
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



	public String getE_date() {
		return e_date;
	}



	public void setE_date(String e_date) {
		this.e_date = e_date;
	}



	public String getE_memnum() {
		return e_memnum;
	}



	public void setE_memnum(String e_memnum) {
		this.e_memnum = e_memnum;
	}



	public String getE_price() {
		return e_price;
	}



	public void setE_price(String e_price) {
		this.e_price = e_price;
	}



	@Override
	public String toString() {
		return "ExerciseVO [e_no=" + e_no + ", e_name=" + e_name + ", e_location=" + e_location + ", e_date=" + e_date
				+ ", e_memnum=" + e_memnum + ", e_price=" + e_price + "]";
	}



	






	






	






	




	




	

	
    
    
}
