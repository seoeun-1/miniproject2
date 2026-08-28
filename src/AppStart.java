
import java.util.Scanner;

import view.CategoryView;
import view.ProductView;
import view.RecvsalesView;
import view.ManagementView;
import view.AdminView;
import view.DailysalesView;
import view.MainView;

public class AppStart {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        MainView.getInstance().startMenu();
        while (true) {
            try {

                System.out.println("╔══════════════════════════════════════╗");
                System.out.println("║              [ 메뉴 선택 ]           ║");
                System.out.println("╠══════════════════════════════════════╣");
                System.out.println("║  0. 카테고리 관리                    ║");
                System.out.println("║  1. 상품 관리                        ║");
                System.out.println("║  2. 입고 및 판매 관리                ║");
                System.out.println("║  3. 재고 현황 관리                   ║");
                System.out.println("║  4. 마감할인 자동 적용               ║");
                System.out.println("║  5. 입고 및 판매 이력 조회           ║");
                System.out.println("║  6. 하루 매출                        ║");
                System.out.println("║  7. 종료                             ║");
                System.out.println("╚══════════════════════════════════════╝");
                System.out.print("▶ 번호 선택 : ");

                int ch = scan.nextInt();

                // 0. 카테고리 관리
                if (ch == 0)
                    CategoryView.getInstance().index();

                // 1. 상품 관리
                else if (ch == 1)
                    ProductView.getInstance().pmenu();

                // 2. 입고 및 판매 관리
                else if (ch == 2)
                    ManagementView.getInstance().InventorySalesMenu();

                
                // 3. 재고 현황 관리
                else if (ch == 3)
                    ManagementView.getInstance().inventory();

                /* 
                // 4. 마감할인 작동 적용
                /* else if (ch == 4)
                    View.getInstance().menu();
                */

                // 5. 입고 및 판매 이력 조회
                else if (ch == 5)
                    AdminView.getInstance().amenu();

                // 6. 하루 매출
                else if (ch == 6)
                    DailysalesView.getInstance().dmenu();

                // 9. 종료
                else if (ch == 7) {
                    System.out.println("[안내] 프로그램을 종료합니다.");
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("[안내] 잘못된 입력입니다.");
                scan.nextLine();
            }
        }
    }
}
