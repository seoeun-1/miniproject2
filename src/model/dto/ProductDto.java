package model.dto;

import java.time.LocalDate;

public class ProductDto extends SuperDto{
    // Product DB 정보를 받기 위한 매개변수들
    private int pno;
    private String pname;
    private int pprice;
    private boolean pstatus;
    private int cno;
    private LocalDate mdate;

    // 기본 생성자 , 전체 생성자 , 입력받을때 생성자
    public ProductDto(){}
    public ProductDto(int pno, String pname, int pprice, boolean pstatus, int cno, LocalDate mdate){
        this.pno = pno;
        this.pname = pname;
        this.pprice = pprice;
        this.pstatus = pstatus;
        this.cno = cno;
        this.mdate = mdate;
    }
    public ProductDto(String pname, int pprice, int cno){
        this.pname = pname;
        this.pprice = pprice;
        this.cno = cno;
    }


    
    // getter setter, toString 
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
        return checksale(this.pprice, this.mdate);
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


    @Override
    public String toString() {
        return "ProductDto [pno=" + pno + ", pname=" + pname + ", pprice=" + pprice + ", pstatus=" + pstatus + ", cno="
                + cno + "]";
    }

    

    


}
