package model.dto;

import java.time.LocalDate;

public class DiscountPriceDto extends SuperDto {
    private String pname;
    private int originPrice;
    private int mno;
    private LocalDate mdate;

    // dao 에서 localdate 사용인데 dto에 멤버변수없음.
    

    public DiscountPriceDto(int originPrice , LocalDate mdate) {
        this.originPrice = originPrice;
    }
    public String getPname() { return pname; }
    public void setPname(String pname) { this.pname = pname; }

    public int getOriginPrice() { return originPrice; }
    public void setOriginPrice(int originPrice) {
        this.originPrice = originPrice;
    }

  
    


    public int getMno() { return mno; }
    public void setMno(int mno) { this.mno = mno; }
    public LocalDate getMdate() {
        return mdate;
    }
    public void setMdate(LocalDate mdate) {
        this.mdate = mdate;
    }
    
    
}
