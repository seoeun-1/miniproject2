package model.dto;

import java.time.LocalDate;

public class ProductManagementDto {
    //상품 속성
    int pno;
    String pname;
    int pprice;
    boolean pstatus;
    int cno;

    //재고 속성
    int mno;
    LocalDate mdate;
    String mstatus;
    LocalDate in_date;
    LocalDate out_date;
    public ProductManagementDto() {
    }
    public ProductManagementDto(int pno, String pname, int pprice, boolean pstatus, int cno, int mno, LocalDate mdate,
            String mstatus, LocalDate in_date, LocalDate out_date) {
        this.pno = pno;
        this.pname = pname;
        this.pprice = pprice;
        this.pstatus = pstatus;
        this.cno = cno;
        this.mno = mno;
        this.mdate = mdate;
        this.mstatus = mstatus;
        this.in_date = in_date;
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
        this.pprice = pprice;
    }
    public boolean isPstatus() {
        return pstatus;
    }
    public void setPstatus(boolean pstatus) {
        this.pstatus = pstatus;
    }
    public int getCno() {
        return cno;
    }
    public void setCno(int cno) {
        this.cno = cno;
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
        return "ProductManagementDto [pno=" + pno + ", pname=" + pname + ", pprice=" + pprice + ", pstatus=" + pstatus
                + ", cno=" + cno + ", mno=" + mno + ", mdate=" + mdate + ", mstatus=" + mstatus + ", in_date=" + in_date
                + ", out_date=" + out_date + "]";
    }



}
