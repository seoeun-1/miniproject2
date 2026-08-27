package view;

import java.util.ArrayList;
import java.util.Scanner;
import controller.RecvsalesController;
import model.dto.RecvsalesDto;

public class RecvsalesView {
   // 싱글톤 패턴
    private RecvsalesView() {}
    private static final RecvsalesView instance = new RecvsalesView();
    public static RecvsalesView getInstance() {
        return instance;
    }

    private RecvsalesController rd = RecvsalesController.getInstance();
    Scanner scan = new Scanner(System.in);

    // 상품 판매 및  판매여부 관리 메뉴

    public void amenu() {
        while (true) {
            System.out.println();
            System.out.println("┌──────────────────── 입·출고 및 판매 이력 조회 ───────────────────┐");
            System.out.println("│                                                                 │");
            System.out.println("│   1. 상품 판매시 재고 관리  │   2. 판매여부 │   0. 뒤로 가기      │");
            System.out.println("│                                                                 │");
            System.out.println("└─────────────────────────────────────────────────────────────────┘");
            System.out.println();
            System.out.print("메뉴 선택 : ");
            int ch = scan.nextInt();

            if (ch == 1) {
                saleProduct();
            }
            else if (ch == 2) {
                findAllStatus();
            }
            else if (ch == 0) {
                return;
            }
        }
    }

    // 1. 상품 판매시 재고

    public void saleProduct() {
        System.out.println();
        System.out.println("=================================");
        System.out.println(      "상품 판매시 재고 관리"        );
        System.out.println("=================================");

        ArrayList<RecvsalesDto> result = rd.findAllProduct();


        if (result.isEmpty()) {
            System.out.println(
                   "[안내] 현재 판매 가능한 상품이 없습니다."
            );
            return;
        }

        System.out.println();
        System.out.println("==============================================");
        System.out.println("상품번호 | 상품명 | 가격 | 현재재고" );
        System.out.println("==============================================");


        for (RecvsalesDto recvsalesdto : result) {
            System.out.println(
                recvsalesdto.getPno() + " | "
                + recvsalesdto.getPname() + " | "
                + recvsalesdto.getPprice() + "원 | "
                + recvsalesdto.getInventory() + "개"
            );
        }


        System.out.println("==============================================");
        System.out.print("구매할 상품번호 : ");
        int pno = scan.nextInt();
        System.out.print("구매 수량 : ");
        int salecount = scan.nextInt();

        if (salecount <= 0) {
            System.out.println("[안내] 구매 수량은 1개 이상 입력하세요.");
            return;
        }

        boolean result2 = rd.saleProduct(pno, salecount);

        if (result2) {
            System.out.println();
            System.out.println("[완료] 상품 구매가 완료되었습니다.");
            System.out.println("[완료] 구매 수량 : "+ salecount + "개");
            System.out.println("[완료] 재고가 "+ salecount + "개 감소했습니다.");
        }
        else {
            System.out.println();
            System.out.println("[안내] 재고가 부족하거나 " + "판매할 수 없는 상품입니다.");
        }
    }

    // 2. 판매 여부
      public void statusMenu() {

        while (true) {
            System.out.println();
            System.out.println("┌──────────────────── 입고 및 판매 관리────────────────────────┐");
            System.out.println("│                                                             │");
            System.out.println("│   1. 판매여부 조회   │   2. 판매여부 변경 │   0. 뒤로 가기    │");
            System.out.println("│                                                             │");
            System.out.println("└─────────────────────────────────────────────────────────────┘");
            System.out.println();
            System.out.print("메뉴 선택 : ");
            int ch = scan.nextInt();


            if (ch == 1) {
                findAllStatus();
            }
            else if (ch == 2) {
                changeStatus();
            }
            else if (ch == 0) {
                return;
            }
        }
    }


    // 판매여부 조회
    public void findAllStatus() {
        System.out.println();
        System.out.println("=================================");
        System.out.println(          "상품여부 조회"           );
        System.out.println("=================================");

        ArrayList<RecvsalesDto> result = rd.findAllStatus();


        if (result.isEmpty()) {
            System.out.println("[안내] 등록된 상품이 없습니다.");
            return;
        }

        System.out.println();
        System.out.println("==============================================");
        System.out.println("상품번호 | 상품명 | 가격 | 판매여부");
        System.out.println("==============================================");

        for (RecvsalesDto dto : result) {

            String status;

            if (dto.isPstatus()) {
                status = "판매중";
            }
            else {
                status = "판매중지";
            }


            System.out.println(
                dto.getPno() + " | "
                + dto.getPname() + " | "
                + dto.getPprice() + "원 | "
                + status
            );
        }

        System.out.println("==============================================");
    }

    // 판매여부 변경
    public void changeStatus() {
        System.out.println();
        System.out.println("=================================");
        System.out.println(          "상품여부 변경"           );
        System.out.println("=================================");

        // 현재 판매여부 보여주기
        findAllStatus();

        System.out.print("변경할 상품번호 : ");
        int pno = scan.nextInt();

        System.out.println();
        System.out.println("1. 판매중");
        System.out.println("2. 판매중지");
    
        System.out.print("변경할 판매여부 : ");
        int status = scan.nextInt();

        boolean result = false;

        if (status == 1) {
            result = rd.startSales(pno);
        }
        else if (status == 2) {
            result = rd.stopSales(pno);
        }
        else {
            System.out.println( "[안내] 잘못된 선택입니다.");
            return;
        }

        if (result) {
            System.out.println( "[완료] 판매여부가 변경되었습니다.");
        }
        else {
            System.out.println("[안내] 상품번호를 확인해주세요.");
        }
    }
}


