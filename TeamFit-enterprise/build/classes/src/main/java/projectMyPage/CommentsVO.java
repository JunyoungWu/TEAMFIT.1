package projectMyPage;

import java.sql.Timestamp;

public class CommentsVO {
    private int comNum;
    private String comWriter;
    private int num;
    private String comContent;
    private Timestamp regdate;

    public int getComNum() {
        return comNum;
    }

    public void setComNum(int comNum) {
        this.comNum = comNum;
    }

    public String getComWriter() {
        return comWriter;
    }

    public void setComWriter(String comWriter) {
        this.comWriter = comWriter;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public Timestamp getRegdate() {
        return regdate;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

	@Override
	public String toString() {
		return "CommentsVO [comNum=" + comNum + ", comWriter=" + comWriter + ", num=" + num + ", comContent="
				+ comContent + ", regdate=" + regdate + "]";
	}
    
}
