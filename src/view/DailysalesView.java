package view;

import java.util.ArrayList;
import java.util.Scanner;
import controller.DailysalesController;
import model.dto.DailysalesDto;

public class DailysalesView {
    private DailysalesView() {}
    private static final DailysalesView instance = new DailysalesView();
    public static DailysalesView getInstance() {
        return instance;
    }

    private DailysalesController ds = DailysalesController.getInstance();
    Scanner scan = new Scanner(System.in);

    public void amenu() {
        while (true) {
            System.out.println();
            System.out.println("┌──────────── 하루 매출 확인 ────────────┐");
            System.out.println("│                                        │");
            System.out.println("│   1. 오늘의 매출   │   0. 뒤로 가기    │");
            System.out.println("│                                       │");
            System.out.println("└───────────────────────────────────────┘");

            System.out.print("메뉴 선택 : ");
            int ch = scan.nextInt();

            if (ch == 1) {
                findAllTodaySales();
            }
            else if (ch == 0) {
                return;
            }
        }
    }

    //오늘의 매출
    public void findAllTodaySales() {
        System.out.println();
        System.out.println("=================================");
        System.out.println("오늘의 매출"                       );
        System.out.println("=================================");
        System.out.println();
        System.out.print("조회할 날짜를 입력하세요 : "); 
        String date= scan.next();

        ArrayList<DailysalesDto> result = ds.findAllTodaySales(date);    
        // 조회 결과가 없는 경우
        if (result.isEmpty()) {
            System.out.println("[안내] 오늘 판매된 상품이 없습니다.");
            System.out.println("[안내] 오늘 총 매출 : 0원");
            return;
        }

        System.out.println();
        System.out.println("=====================================");
        System.out.println("상품명 | 가격 | 판매수량 | 상품별 매출");
        System.out.println("=====================================");

        // 총 판매수량 계산
        int totalcount = 0;
        
        // 판매 상품 출력
        for (DailysalesDto dto : result) {
            System.out.println( 
                dto.getPname() + " | " 
                + dto.getPprice() + " 원| "
                + dto.getSalescount() + " 개| "
                + dto.getSalesamount() + "원"
            );

            totalcount += dto.getSalescount();

        }

        // 오늘 총 매출 조회
        int totalsales = ds.findAllTodayTotalSales(date);

        System.out.println("==================================================");
        System.out.println("총 판매수량 : " + totalcount + "개");
        System.out.println("총 매출 : " + totalsales + "원");
        System.out.println("==================================================");
        System.out.println();
    }
}
