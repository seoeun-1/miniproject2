package model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SaleDto extends SuperDto{
    private int mno ;
    private int cno ;
    private String cname;
    private String pname;
    private int pprice;
    private LocalDate mdate;

    // 기본생성자 , 정보받을 생성자 , 
    public SaleDto(){}
    public SaleDto(int mno, int cno, String cname, String pname, int pprice, LocalDate mdate){
        this.mno = mno;
        this.cno = cno;
        this.cname = cname;
        this.pname = pname;
        
        this.mdate = mdate;
        // 여기서 현재 날짜랑 검사 
        
        if(mdate != null){
                LocalDate now = LocalDate.now();
                String strDate = mdate.toString();
                String strNow = now.toString();
                String[] arryDate = (strDate.split("-"));  //  '-' 로 자르기
                String[] arryNow = (strNow.split("-"));  //  '-' 로 자르기
                int[] arrayDate = new int[3];    //  유통기한 날짜 int배열로 변환
                int[] arrayNow = new int[3];    //  현재 날짜 int배열로 변환
                for ( int i = 0 ; i <= 2 ; i++){
                    arrayDate[i] = Integer.parseInt(arryDate[i]);
                    arrayNow[i] = Integer.parseInt(arryNow[i]);
                }
                int result = (arrayDate[0] - arrayNow[0]) * 365
                            + (arrayDate[1] - arrayNow[1]) * 30
                            + (arrayDate[2] - arrayNow[2]);

                if(result == 1){
                    double aaa = pprice * 0.8;
                    this.pprice = (int)aaa;  // 형변환
                }
                else if(result == 0){
                    double aaa = pprice * 0.7;
                    this.pprice = (int)aaa;  // 형변환
                }
                else this.pprice = pprice;
        }else this.pprice = pprice;

        // 가격 반영 끝
    } 

    public SaleDto(int mno, int cno, String cname, String pname, int pprice){
        this.mno = mno;
        this.cno = cno;
        this.cname = cname;
        this.pname = pname;
        this.pprice = pprice;
    }


    // getter.setter
    public LocalDate getMdate() {
        return mdate;
    }
    public void setMdate(LocalDate mdate) {
        this.mdate = mdate;
    }
    public int getMno() {
        return mno;
    }
    public void setMno(int mno) {
        this.mno = mno;
    }
    public int getCno() {
        return cno;
    }
    public void setCno(int cno) {
        this.cno = cno;
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
        
                LocalDate now = LocalDate.now();
                String strDate = mdate.toString();
                String strNow = now.toString();
                String[] arryDate = (strDate.split("-"));  //  '-' 로 자르기
                String[] arryNow = (strNow.split("-"));  //  '-' 로 자르기
                int[] arrayDate = new int[3];    //  유통기한 날짜 int배열로 변환
                int[] arrayNow = new int[3];    //  현재 날짜 int배열로 변환
                for ( int i = 0 ; i <= 2 ; i++){
                    arrayDate[i] = Integer.parseInt(arryDate[i]);
                    arrayNow[i] = Integer.parseInt(arryNow[i]);
                }
                int result = (arrayDate[0] - arrayNow[0]) * 365
                            + (arrayDate[1] - arrayNow[1]) * 30
                            + (arrayDate[2] - arrayNow[2]);

                if(result == 1){
                    double aaa = pprice * 0.8;
                    this.pprice = (int)aaa;  // 형변환
                }
                else if(result == 0){
                    double aaa = pprice * 0.7;
                    this.pprice = (int)aaa;  // 형변환
                }
                else this.pprice = pprice;
        
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }


    // 여기서 사용자에게 보여줄 내용만 보여주면됨. 
    @Override
    public String toString() {
        return "SaleDto [mno=" + mno + ", cno=" + cno + ", pname=" + pname + ", pprice=" + pprice + ", mdate=" + mdate
                + "]";
    }

    
    

    /* 
    LocalDateTime now = LocalDateTime.now();
    String strDate = now.toString();
    */
    

}

/*
SELECT
    m.mno AS 유통식별번호,
    c.cname AS 카테고리명,
    p.pname AS 상품명,
    p.pprice AS 상품가격,
    m.mdate AS 유통기한
FROM management m
INNER JOIN product p
    ON m.pno = p.pno
INNER JOIN category c
    ON p.cno = c.cno
ORDER BY m.mno ASC;
*/