package view;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import controller.ManagementController;
import model.dao.ManagementDao;
import model.dto.InventoryDto;
import model.dto.ManagementDto;

public class ManagementView {

    private ManagementView(){} // 1.
    private static final ManagementView instance = new ManagementView(); // 2.
    public static ManagementView getInstance( ){ return instance; } // 3. 

    static Scanner scan = new Scanner(System.in);
    // [*] MVC패턴 흐름의 controller 싱글톤 호출
    private ManagementController mc = ManagementController.getInstance();
    
        //관리자 메뉴 2번
        public void InventorySalesMenu(){
            for(;;){
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
                
                if(ch==1){
                    msave();
                }else if(ch==2){
                    mupdate();
                }else if(ch==3){
                    mdelete();
                }else if(ch==4){

                }else if(ch==0){

                }
            }
        }

        // 관리자 메뉴 3번
        public void InventoryMenu(){
            for(;;){

                ConsoleLayout.header();
                ConsoleLayout.blank();
                ConsoleLayout.line(" 1.총 재고조회 ");
                ConsoleLayout.line(" 2.재고 수량 ");
                ConsoleLayout.line(" 3.발주 필요 상품 ");
                ConsoleLayout.line(" 4.폐기할 상품 조회/폐기");

                ConsoleLayout.line(" 0.뒤로 가기 ");

                System.out.println();
                ConsoleLayout.blank();
                ConsoleLayout.footer();
            
            
            
                System.out.println("번호 입력 > ");
                int ch = scan.nextInt();
                
                if(ch==1){
                    mfind();
                    
                }else if(ch==2){
                    inventory();
                }else if(ch==3){
                    orderneed();
                }else if(ch==4){
                    deadlineProductFind();
                    deadlineProductUdate();
                }else if(ch==0){

                }
            }
        }

        //저장 기능
        public void msave(){
            
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

            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력하세요");
                    scan.nextLine();
            } catch (Exception e){
                System.out.println(e);
            }
                
        }

        //수정 기능
        public void mupdate(){
            
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

                if(result){
                    System.out.println("[안내] 재고가 성공적으로 변경 되었습니다");
                }else{
                    System.out.println("[안내] 재고 변경 실패");
                }

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

        //삭제 기능
        public void mdelete(){
            boolean result;
                
            try {
                System.out.println("삭제할 재고번호를 입력하세요: "); int mno = scan.nextInt();
                result = mc.mdelete(mno);
                if(result){
                    System.out.println("[안내] 재고가 성공적으로 삭제 되었습니다");
                }else{
                    System.out.println("[안내] 재고 삭제 실패");
                }

            } catch (InputMismatchException e) {
                System.out.println("올바른 입력을 하세요: ");
                scan.nextLine();

            }
                
        }
        
        // 모든 재고 조회
    public void mfind() {
        List<ManagementDto> result = mc.mfind();

        System.out.println(
            "MNO  | PNO  | MDATE      | IN_DATE    | OUT_DATE   | STATUS"
        );

        System.out.println(
            "----------------------------------------------------------------"
        );

        for (ManagementDto dto : result) {
            System.out.printf(
                "%-4d | %-4d | %-10s | %-10s | %-10s | %s%n",
                dto.getMno(),
                dto.getPno(),
                dto.getMdate(),
                dto.getIn_date(),
                dto.getOut_date(),
                dto.getMstatus()
            );
        }
    }

    //상품명별 재고량 조회 기능
    public void inventory(){
        List<InventoryDto> result = mc.inventory();

        System.out.println(
            "상품  | 수량  "
        );

        System.out.println(
            "-----------------------------"
        );

        for (InventoryDto dto : result) {
            System.out.printf(
                "%-4s | %-4d %n",
                dto.getPname(),
                dto.getInventory()
              
            );
        }
    }

    // 발주필요상품조회 기능
    public void orderneed(){
        List<InventoryDto> result = mc.inventory();
        System.out.println(
            "------발주 필요 상품------");
        System.out.println(
            "상품   | 수량  " );
        System.out.println(
            "-----------------------------");

        for (InventoryDto dto : result) {
            if(dto.getInventory()<=5){
                System.out.printf(
                "%-4s | %-4d %n",
                dto.getPname(),
                dto.getInventory());

            }
            
        }
    }

    //폐기할 상품 조회
    public void deadlineProductFind(){
        
        List<Map<String,Object>> result = mc.deadlineProductFind();
        System.out.println(
            "------폐기 할 상품------");
        System.out.println(
            "식별번호   | 상품명   |  유통기한" );
        System.out.println(
            "-----------------------------");
            for(Map<String,Object> i : result){
                System.out.println(i.get("mno") +"    |"+ i.get("pname")+"    |"+ i.get("mdate"));
                
            }
    }

    //페기 상품 업데이트 U
    public void deadlineProductUdate(){
        try {
            System.out.println("변경할 재고 번호 입력: ");  int mno = scan.nextInt();

            String mstatus="폐기";

            boolean result = mc.deadlineProductUpdate(mno,mstatus);

            if (result) {
                System.out.println("폐기 수정 성공");
            }else{
                System.out.println("폐기 수정 실패");
            }
        } catch (InputMismatchException e) {
            System.out.println(e + "올바른 입력을 하세요");
        }catch (Exception e) {
            System.out.println(e);
        }
    }


} //class end
