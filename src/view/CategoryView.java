package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.CategoryController;
import model.dto.CategoryDto;

public class CategoryView {
    // [*] 싱글톤 패턴
    private CategoryView(){}
    private static final CategoryView instance = new CategoryView();
    public static CategoryView getInstance(){ return instance; }

    // [*] Controller 싱글톤 및 Scanner
    private CategoryController cc = CategoryController.getInstance();
    private Scanner scan = new Scanner(System.in);

    // [*] 카테고리 화면 실행
    public void run(){
        while(true){
            try {
                System.out.println("\n--- 카테고리 메뉴 ---");
                System.out.print("1.카테고리 전체조회 0.이전으로 선택: ");
                int ch = scan.nextInt();

                if(ch == 1){ 
                    findAll(); 
                } else if(ch == 0){ 
                    System.out.println("> 이전 메뉴로 돌아갑니다.");
                    break; 
                }
            } catch(InputMismatchException e){
                scan = new Scanner(System.in);
                System.out.println("[다시입력] " + e);
            }
        }
    }

    // [1] 카테고리 전체조회 VIEW
    public void findAll(){
        ArrayList<CategoryDto> result = cc.findAll();
        System.out.println("\n=============== 카테고리 목록 ===============");
        for(CategoryDto dto : result){
            System.out.println(dto.getCno() + " / " + dto.getCname());
        }
        System.out.println("===========================================");
    }
}
