package model.dto;

import java.time.LocalDate;

public class DiscountPriceDto extends SuperDto {
    private String pname;
    private int originPrice;
    private int mno;

    public String getPname() { return pname; }
    public void setPname(String pname) { this.pname = pname; }

    public int getOriginPrice() { return originPrice; }
    public void setOriginPrice(int originPrice) {
        this.originPrice = originPrice;
    }

    public DiscountPriceDto(int pprice, LocalDate mdate) {
        super(pprice, mdate);
    }


    public int getMno() { return mno; }
    public void setMno(int mno) { this.mno = mno; }
    
    
}
