package model.dto;

import java.time.LocalDate;

public class ManageProdJoinDto extends SuperDto{
    int mno;
    LocalDate mdate;
    String mstatus;
    LocalDate in_Date;
    LocalDate out_date;
    int pno;
    String pname;
    int pprice;
    boolean pstatus;
    
    public ManageProdJoinDto() {
    }

    public ManageProdJoinDto(int mno, LocalDate mdate, String mstatus, LocalDate in_Date, LocalDate out_date, int pno,
            String pname, int pprice, boolean pstatus) {
        this.mno = mno;
        this.mdate = mdate;
        this.mstatus = mstatus;
        this.in_Date = in_Date;
        this.out_date = out_date;
        this.pno = pno;
        this.pname = pname;
        this.pprice = super.getPprice();
        this.pstatus = pstatus;
    }
    public int getMno() {
        return mno;
    }
    public void setMno(int mno) {
        this.mno = mno;
    }
    public LocalDate getMdate() {
        return mdate;
    }
    public void setMdate(LocalDate mdate) {
        this.mdate = mdate;
    }
    public String getMstatus() {
        return mstatus;
    }
    public void setMstatus(String mstatus) {
        this.mstatus = mstatus;
    }
    public LocalDate getIn_Date() {
        return in_Date;
    }
    public void setIn_Date(LocalDate in_Date) {
        this.in_Date = in_Date;
    }
    public LocalDate getOut_date() {
        return out_date;
    }
    public void setOut_date(LocalDate out_date) {
        this.out_date = out_date;
    }
    public int getPno() {
        return pno;
    }
    public void setPno(int pno) {
        this.pno = pno;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public int getPprice() {
        return pprice;
    }
    public void setPprice(int pprice) {
        this.pprice = super.getPprice();
    }
    public boolean isPstatus() {
        return pstatus;
    }
    public void setPstatus(boolean pstatus) {
        this.pstatus = pstatus;
    }

    @Override
    public String toString() {
        return "ManageProdJoinDto [mno=" + mno + ", mdate=" + mdate + ", mstatus=" + mstatus + ", in_Date=" + in_Date
                + ", out_date=" + out_date + ", pno=" + pno + ", pname=" + pname + ", pprice=" + pprice + ", pstatus="
                + pstatus + "]";
    }

}
