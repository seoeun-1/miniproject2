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


    // 상품 판매 및 판매여부 관리 메뉴
    public void rmenu() {

        while (true) {

            System.out.println();
            System.out.println("┌──────────────────── 상품 판매 관리 ────────────────────┐");
            System.out.println("│                                                       │");
            System.out.println("│   1. 상품 판매 관리   │   2. 판매여부   │   0. 뒤로 가기 │");
            System.out.println("│                                                       │");
            System.out.println("└───────────────────────────────────────────────────────┘");

            System.out.print("메뉴 선택 : ");
            int ch = scan.nextInt();

            if (ch == 1) {
                saleProduct();
            }
            else if (ch == 2) {
                statusMenu();
            }
            else if (ch == 0) {
                return;
            }
        }
    }

    // [기능 1] 상품 판매 관리

    public void saleProduct() {
        System.out.println();
        System.out.println("========== 상품 판매 관리 ==========");

        // 판매 가능한 개별 재고 조회
        ArrayList<RecvsalesDto> result = rd.findAllProduct();

        if (result.isEmpty()) {

            System.out.println();
            System.out.println("[안내] 판매 가능한 상품이 없습니다.");

            return;
        }

        System.out.println();
        System.out.println("==============================================================");
        System.out.println("구매번호 | 상품명 | 가격 | 유통기한 | 판매여부");
        System.out.println("==============================================================");

        // 개별 재고 출력
        for (RecvsalesDto dto : result) {
            String status;

            if (dto.isPstatus()) {
                status = "판매중";
            }
            else {
                status = "판매중지";
            }

            System.out.println(
                dto.getMno() + " | "
                + dto.getPname() + " | "
                + dto.getPprice() + "원 | "
                + dto.getMdate() + " | "
                + status
            );
        }
        System.out.println("==============================================================");

        // 구매번호 입력
        System.out.print("구매번호 : ");
        int purchaseNo = scan.nextInt();

        boolean result2 = rd.saleProduct(purchaseNo);

        if (result2) {
            System.out.println();
            System.out.println("[완료] 상품 구매가 완료되었습니다.");
            System.out.println("[완료] 구매번호 : " + purchaseNo);
        }
        else {
            System.out.println();
            System.out.println("[안내] 해당 구매번호의 상품을 구매할 수 없습니다.");
        }
    }

    // [기능 2] 판매여부 관리

    public void statusMenu() {

        System.out.println();
        System.out.println("========== 상품 판매여부 관리 ==========");

        // 현재 판매여부 조회
        ArrayList<RecvsalesDto> result = rd.findAllStatus();

        if (result.isEmpty()) {

            System.out.println();
            System.out.println("[안내] 등록된 상품이 없습니다.");

            return;
        }
        System.out.println();
        System.out.println("==============================================");
        System.out.println("상품번호 | 상품명 | 가격 | 판매여부");
        System.out.println("==============================================");

        // 상품별 판매여부 출력
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

        // 상품번호 입력
        System.out.print("상품번호 : ");
        int pno = scan.nextInt();

        // 판매여부 선택
        System.out.println();
        System.out.println("1. 판매중");
        System.out.println("2. 판매중지");
        System.out.print("변경할 판매여부 : ");
        int status = scan.nextInt();

        boolean result2 = false;

        if (status == 1) {
            result2 = rd.startSales(pno);
        }
        else if (status == 2) {
            result2 = rd.stopSales(pno);
        }
        else {
            System.out.println("[안내] 잘못된 선택입니다.");
            return;
        }

        if (result2) {
            System.out.println();
            System.out.println("[완료] 판매여부가 변경되었습니다.");
        }
        else {
            System.out.println();
            System.out.println("[안내] 상품번호를 확인해주세요.");
        }
    }
}