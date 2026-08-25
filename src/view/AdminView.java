package view;

import java.util.Scanner;

public class AdminView {
    public static void main(String[] args) {
        
        ManagementView mv = ManagementView.getInstance();
        Scanner scan = new Scanner(System.in);

        for(;;){

                ConsoleLayout.header();
                ConsoleLayout.blank();
                ConsoleLayout.line(" 1. ");
                ConsoleLayout.line(" 2.입고, 판매관리 ");
                ConsoleLayout.line(" 3.재고 확인 ");
                ConsoleLayout.line(" 4. ");

                ConsoleLayout.line(" 0.뒤로 가기 ");

                System.out.println();
                ConsoleLayout.blank();
                ConsoleLayout.footer();
            
                System.out.println("번호 입력 > ");
                int ch = scan.nextInt();
                
                if(ch==1){
                    
                }else if(ch==2){
                    mv.InventorySalesMenu();
                    
                }else if(ch==3){
                    mv.InventoryMenu();
                }else if(ch==4){

                }else if(ch==0){

                }
            }
        
        
        
    }
}
