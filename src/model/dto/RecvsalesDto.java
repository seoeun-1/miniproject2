package model.dto;

public class RecvsalesDto {

    private int mno;           // 구매번호
    private String mdate;      // 유통기한
    private int pno;           // 상품번호
    private String pname;      // 상품명
    private int pprice;        // 가격
    private boolean pstatus;   // 판매여부


    public RecvsalesDto() {}

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
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

    
    @Override
    public String toString() {
        return "RecvsalesDto ["
                + "mno=" + mno
                + ", mdate=" + mdate
                + ", pno=" + pno
                + ", pname=" + pname
                + ", pprice=" + pprice
                + ", pstatus=" + pstatus
                + "]";
    }
}