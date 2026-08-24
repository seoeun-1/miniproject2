package view;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ManagementController;
import model.dao.ManagementDao;
import model.dto.ManagementDto;

public class ManagementView {

    private ManagementView(){} // 1.
    private static final ManagementView instance = new ManagementView(); // 2.
    public static ManagementView getInstance( ){ return instance; } // 3. 

    static Scanner scan = new Scanner(System.in);
    // [*] MVC패턴 흐름의 controller 싱글톤 호출
    private ManagementController mc = ManagementController.getInstance();
    

    

        public void InventorySalesMenu(){

            ConsoleLayout.header();
            ConsoleLayout.blank();
            ConsoleLayout.line(" 1.입고 ");
            ConsoleLayout.line(" 2.재고 수정 ");
            ConsoleLayout.line(" 3.재고 삭제 ");
            ConsoleLayout.line(" 4.판매 여부 조정 ");

            ConsoleLayout.line(" 0.뒤로 가기 ");

            System.out.println();
            ConsoleLayout.blank();
            ConsoleLayout.footer();
            
            System.out.println("번호 입력 > ");
            int ch = scan.nextInt();
            for(;;){
                if(ch==1){
                    msave();
                    
                    
                }else if(ch==2){
                    mupdate();

                    
                }else if(ch==3){
                    

                }else if(ch==4){

                }else if(ch==0){

                }
            }
            

            
        }

    public void msave(){
        while (true) {
                try {
                int pno = 0;
                System.out.println("추가할 상품 번호를 입력하세요: ");
                pno = scan.nextInt();
                
                //상품 번호 비교 함수 넣기 


                boolean result = mc.msave(pno);
                if(result){
                    System.out.println("[안내] 재고가 성공적으로 등록 되었습니다");
                }else{
                    System.out.println("[안내] 재고 등록 실패");
                }

                break;

                } catch (InputMismatchException e) {
                    System.out.println("숫자로 입력하세요");
                        scan.nextLine();
                } catch (Exception e){
                    System.out.println(e);
                }
            }
            
    }

    public boolean mupdate(){
        while (true) {
            try {
                System.out.println("변경할 재고 번호 입력: ");  int mno = scan.nextInt();
                System.out.println("유통기한 변경 ex(20260820)"); String mdate = scan.next();
                LocalDate localDate = LocalDate.parse(mdate,DateTimeFormatter.BASIC_ISO_DATE);

                String mstatus;

                while (true) {
                    System.out.println("상태 입력(판매중/입고, 판매, 폐기): ");  mstatus = scan.next();
                    if (mstatus.equals("판매중/입고")
                            || mstatus.equals("판매")
                            || mstatus.equals("폐기")) {
                        break;
                        }
                        
                    System.out.println("다시 입력하세요: ");
                }
            
                ManagementDto managementDto = new ManagementDto();
                managementDto.setMno(mno); managementDto.setMdate(localDate);
                managementDto.setMstatus(mstatus); 
                
                boolean result = mc.mupdate(managementDto);

                return result;

            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하세요: ");
                scan.nextLine();
            } catch (DateTimeParseException e){
                System.out.println("올바른 날짜 입력:  ");
                scan.nextLine();
            } catch (Exception e){
                System.out.println(e);
            }
        }
                    
    }

    public boolean mdelete(){
        boolean result;
            while (true) {

                try {
                    System.out.println("삭제할 재고번호를 입력하세요: "); int mno = scan.nextInt();
                    result = mc.mdelete(mno);

                    break;
                } catch (InputMismatchException e) {
                    System.out.println("올바른 입력을 하세요: ");
                    scan.nextLine();

                }
                
            }
            
            return result;
    }
    

} //class end
