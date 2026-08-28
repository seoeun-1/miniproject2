package model.dto;

public class ProductDto extends SuperDto{
    // Product DB 정보를 받기 위한 매개변수들
    private int pno;
    private String pname;
    private int pprice;
    private boolean pstatus;
    private int cno;

    // 기본 생성자 , 전체 생성자 , 입력받을때 생성자
    public ProductDto(){}
    public ProductDto(int pno, String pname, int pprice, boolean pstatus, int cno){
        this.pno = pno;
        this.pname = pname;
        this.pprice = super.getPprice();
        this.pstatus = pstatus;
        this.cno = cno;
    }
    public ProductDto(String pname, int pprice, int cno){
        this.pname = pname;
        this.pprice = super.getPprice();
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
        return super.getPprice();
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
