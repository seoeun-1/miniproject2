package view;

import java.util.ArrayList;
import java.util.Scanner;
import controller.AdminController;
import model.dto.AdminDto;

public class AdminView {

    // 싱글톤 패턴
    private AdminView() {}
    private static final AdminView instance = new AdminView();
    public static AdminView getInstance() {
        return instance;
    }

    private AdminController ac = AdminController.getInstance();
    Scanner scan = new Scanner(System.in);

    public void amenu() {
        while (true) {
            System.out.println("┌──────────────────────── 입·출고 및 판매 이력 조회 ───────────────────────────┐");
            System.out.println("│                                                                             │");
            System.out.println("│   1. 상품별 입고 이력 조회   │   2. 상품별 판매 이력 조회   │   3. 뒤로 가기   │");
            System.out.println("│                                                                             │");
            System.out.println("└─────────────────────────────────────────────────────────────────────────────┘");

            System.out.print("메뉴 선택 : ");
            int ch = scan.nextInt();

            if (ch == 1) {
                findAllIn();
            }
            else if (ch == 2) {
                findAllOut();
            }
            else if (ch == 3) {
                return;
            }
        }
    }

    // [1] 상품별 입고 이력 조회
    public void findAllIn() {
        System.out.println("========== 상품별 입고 이력 조회 ==========");
        System.out.print("조회할 상품번호를 입력하세요 : "); 
        int pno = scan.nextInt();

        ArrayList<AdminDto> result = ac.findAllIn(pno);
        // 조회 결과가 없는 경우
        if (result.isEmpty()) {
            System.out.println("[안내] 해당 상품의 입고 이력이 없습니다.");
            return;
        }

        System.out.println();
        System.out.println("========================");
        System.out.println("상태 | 상품명 | 입고날짜");
        System.out.println("========================");

        // 조회 결과 출력
        for (AdminDto dto : result) {
            System.out.println( 
                dto.getMstatus() + " | " 
                + dto.getPname() + " | "
                + dto.getInDate()
            );
        }
    }

    // [2] 상품별 판매 이력 조회
    public void findAllOut() {
        System.out.println();
        System.out.println("========== 상품별 판매 이력 조회 ==========");
        System.out.print("조회할 상품번호를 입력하세요 : ");
        int pno = scan.nextInt();

        ArrayList<AdminDto> result = ac.findAllOut(pno);

        // 조회 결과가 없는 경우
        if (result.isEmpty()) {
            System.out.println("[안내] 해당 상품의 판매 이력이 없습니다.");
            return;
        }

        System.out.println();
        System.out.println("====================================");
        System.out.println("상태 | 상품명 | 판매날짜 | 판매갯수");
        System.out.println("====================================");

        // 조회 결과 출력
        for (AdminDto dto : result) {
            System.out.println(
                dto.getMstatus() + " | "
                + dto.getPname() + " | "
                + dto.getOutDate() + " | "
                + dto.getOutCount()
            );
        }
    }
    /* 
    // [3] 날짜별 입고·판매 내역 조회
    public void findAllDate() {
        System.out.println("========== 날짜별 입고·판매 내역 조회 ==========");
        System.out.print("조회할 날짜를 입력하세요 (YYYY-MM-DD) : ");
        String date = scan.next();

        ArrayList<AdminDto> result = ac.findAllDate(date);

        // 조회 결과가 없는 경우
        if (result.isEmpty()) {
            System.out.println( "[안내] 해당 날짜의 입·출고 및 판매 내역이 없습니다.");
            return;
        }

        System.out.println();
        System.out.println("====================================");
        System.out.println("상태 | 상품명 | 입고날짜 | 판매날짜");
        System.out.println("====================================");

        // 조회 결과 출력
        for (AdminDto dto : result) {
            System.out.println(
                dto.getMstatus() + " | "
                + dto.getPname() + " | "
                + dto.getInDate() + " | "
                + dto.getOutDate()
            );
        }
    }
    */
}