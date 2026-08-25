package model.dto;

public class AdminDto {
    private int mno;
    private int pno;
    private String mstatus;
    private String inDate;
    private String outDate;
    private String pname;
    private int outCount;

    public AdminDto() {
    }

    public AdminDto(int mno, int pno, String mstatus, String inDate, String outDate, String pname, int outCount) {
        this.mno = mno;
        this.pno = pno;
        this.mstatus = mstatus;
        this.inDate = inDate;
        this.outDate = outDate;
        this.pname = pname;
        this.outCount = outCount;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }


    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }


    public String getMstatus() {
        return mstatus;
    }

    public void setMstatus(String mstatus) {
        this.mstatus = mstatus;
    }


    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }


    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }


    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }


    public int getOutCount() {
        return outCount;
    }

    public void setOutCount(int outCount) {
        this.outCount = outCount;
    }


    @Override
    public String toString() {
        return "ManagementDto ["+ "mno=" + mno + ", pno=" + pno + ", mstatus=" + mstatus
                                + ", inDate=" + inDate + ", outDate=" + outDate + ", pname=" + pname
                                + ", saleCount=" + outCount+ "]";
    }
}

