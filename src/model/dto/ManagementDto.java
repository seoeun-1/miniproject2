package model.dto;

import java.time.LocalDate;

public class ManagementDto {
    int mno;
    LocalDate mdate;
    int pno;
    String mstatus;
    LocalDate in_date;
    LocalDate out_date;
    
    public ManagementDto() {
    }

    public ManagementDto(int mno, LocalDate mdate, int pno, String mstatus, LocalDate in_date, LocalDate out_date) {
        this.mno = mno;
        this.mdate = mdate;
        this.pno = pno;
        this.mstatus = mstatus;
        this.in_date = in_date;
        this.out_date = out_date;
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

    public LocalDate getIn_date() {
        return in_date;
    }
    public void setIn_date(LocalDate in_date) {
        this.in_date = in_date;
    }
    
    public LocalDate getOut_date() {
        return out_date;
    }
    public void setOut_date(LocalDate out_date) {
        this.out_date = out_date;
    }


    @Override
    public String toString() {
        return "ManagementDto [mno=" + mno + ", mdate=" + mdate + ", pno=" + pno + ", mstatus=" + mstatus + ", in_date="
                + in_date + ", out_date=" + out_date + "]";
    }
    
}
