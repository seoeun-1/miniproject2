package view;

import java.util.Scanner;

import model.dao.SaleDao;

public class MainView {
    private MainView(){}
    private static final MainView instance = new MainView();
    public static MainView getInstance() { return instance; }


    public void startMenu() {
        Scanner scan = new Scanner(System.in);
        
        while (true) {
            System.out.println();
            System.out.println("=====================================");
            System.out.println("         FoodManager Console         ");
            System.out.println("=====================================");
            System.out.println(" 1. 관리자");
            System.out.println(" 2. 사용자");
            System.out.println(" 0. 종료");
            System.out.println("=====================================");
            System.out.print("메뉴 선택 : ");
            
            if (!scan.hasNextInt()) {
                System.out.println("[안내] 숫자로 입력해주세요.");
                scan.next();
                continue;
            }
            
            int ch = scan.nextInt();
            scan.nextLine();

            if (ch == 1) {
                break;
            } else if (ch == 2) {
                RecvsalesView.getInstance().saleProduct();
            } else if( ch == 0){
                System.out.println("[안내] 프로그램을 종료합니다.");
                    break;
            }else {
                System.out.println("[안내] 잘못된 입력입니다.");
            }
        }
    }
}