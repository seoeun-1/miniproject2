package model.dto;

public class DailysalesDto {
     private String pname;       // 상품명
    private int pprice;         // 상품가격
    private int salescount;     // 판매수량
    private int salesamount;    // 상품별 매출

    public DailysalesDto() {
    }

    public DailysalesDto(String pname, int pprice, int salescount, int salesamount) {
        this.pname = pname;
        this.pprice = pprice;
        this.salescount = salescount;
        this.salesamount = salesamount;
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

    public int getSalescount() {
        return salescount;
    }

    public void setSalescount(int salescount) {
        this.salescount = salescount;
    }

    public int getSalesamount() {
        return salesamount;
    }

    public void setSalesamount(int salesamount) {
        this.salesamount = salesamount;
    }

    @Override
    public String toString() {
        return "DailysalesDto ["+ "pname=" + pname + ", pprice=" + pprice + ", salescount=" + salescount
                                + ", salesamounte=" + salesamount + "]";
    }
}
