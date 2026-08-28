package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.CategoryController;
import model.dto.CategoryDto;

public class CategoryView {

    // 1. 싱글톤 패턴 적용 (객체를 단 하나만 생성)
    private CategoryView(){}
    private static final CategoryView instance = new CategoryView();
    public static CategoryView getInstance(){ return instance; }

    // 2. 컨트롤러 연결 및 공통 스캐너 선언 (이름을 scan으로 통일)
    private CategoryController cc = CategoryController.getInstance();
    private Scanner scan = new Scanner(System.in);

    // 3. 메인 메뉴 화면
    public void index() {
        while (true) {
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|                    카테고리 관리                        |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|  1. 전체 조회          |  2. 등록                      |");
            System.out.println("|  3. 수정               |  4. 삭제       |  5. 종료     |");
            System.out.println("+----------------------------------------------------------+");
            System.out.print("메뉴 선택 : ");

            int ch = scan.nextInt();

            if (ch == 1) { cateFindall(); }
            else if (ch == 2) { cateRegister(); }
            else if (ch == 3) { cateUpdate(); }
            else if (ch == 4) { cateDelete(); }
            else if (ch == 5) {
                System.out.println("안내) 프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("안내) 잘못된 입력입니다. 1~5 사이로 입력해주세요.");
            }
        }
    }

    // 카테고리 전체 조회 VIEW
    public void cateFindall() {
        ArrayList<CategoryDto> result = cc.cateFindall(); 

        System.out.println("\n--- [ 카테고리 전체 목록 ] ---");
        System.out.println("카테고리번호\t카테고리명");
        
        for (CategoryDto dto : result){
            System.out.println(dto.getCno() + "\t\t" + dto.getCname());
        }
    }

    // [카테고리 등록 View]
    public void cateRegister() {
        System.out.print("등록할 카테고리명 입력: ");
        String cname = scan.next(); // scan 사용
    
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCname(cname);
    
        boolean result = cc.cateRegister(categoryDto);
    
        if (result) {
            System.out.println("안내) 카테고리 등록 성공!");
        } else {
            System.out.println("안내) 카테고리 등록 실패...");
        }
    }

    // [카테고리 수정 View]
    public void cateUpdate() {
        System.out.print("수정할 카테고리 번호 입력: ");
        int cno = scan.nextInt(); // scan 사용
        
        System.out.print("새로운 카테고리 이름 입력: ");
        String cname = scan.next(); // scan 사용
        
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCno(cno);
        categoryDto.setCname(cname);
        
        boolean result = cc.cateUpdate(categoryDto);
        
        if (result) {
            System.out.println("안내) 카테고리 수정 성공!");
        } else {
            System.out.println("안내) 카테고리 수정 실패...");
        }
    }

    // [카테고리 삭제 View]
    public void cateDelete() {
        System.out.print("삭제할 카테고리 번호 입력: ");
        int cno = scan.nextInt(); // scan 사용
        
        boolean result = cc.cateDelete(cno);
        
        if (result) {
            System.out.println("안내) 카테고리 삭제 성공!");
        } else {
            System.out.println("안내) 카테고리 삭제 실패...");
        }
    }

}