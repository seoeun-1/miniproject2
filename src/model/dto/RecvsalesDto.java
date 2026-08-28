package model.dto;

import java.time.LocalDate;

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