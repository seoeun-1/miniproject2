package model.dto;

import java.time.LocalDate;

public class BaseDiscountPriceDto {
    int pprice;
    LocalDate mdate;
    

    public BaseDiscountPriceDto() {
    }


    public BaseDiscountPriceDto(int pprice, LocalDate mdate){
        
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
}
