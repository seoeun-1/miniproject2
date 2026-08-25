package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.CategoryController;
import model.dto.CategoryDto;

public class CategoryView {

    private CategoryView(){}
    private static final CategoryView instance = new CategoryView();
    public static CategoryView getInstance(){ return instance; }

    private CategoryController cc = CategoryController.getInstance();
    private Scanner scan = new Scanner(System.in);

    public void run(){
        while(true){
            try {
                // DB에서 카테고리 전체 목록 조회
                ArrayList<CategoryDto> list = cc.findAll();

                System.out.println("╔═════════════════════════════════════════════════════════════════════════╗");
                System.out.println("║            🌟 FoodManager Console 🌟   |  일반 고객  |                    ║");
                System.out.println("╠═════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                         ║");
                System.out.println("║                     [ 카테고리 ]                                         ║");
                System.out.println("║                                                                         ║");

                // DB에 있는 카테고리 목록을 한 줄씩(2개씩) 예쁘게 출력
                if(list == null || list.isEmpty()){
                    System.out.println("║             등록된 카테고리가 없습니다.                                  ║");
                } else {
                    for(int i = 0; i < list.size(); i++){
                        CategoryDto dto = list.get(i);
                        // 프로토타입처럼 번호와 이름 표시
                        System.out.printf("║      %d. %-15s", (i + 1), dto.getCname());
                        
                        // 2개 출력할 때마다 줄바꿈 처리
                        if((i + 1) % 2 == 0 || i == list.size() - 1){
                            System.out.println("                                ║");
                        }
                    }
                }

                System.out.println("║                                                                         ║");
                System.out.println("║      0. 메인으로 돌아가기                                                  ║");
                System.out.println("║                                                                         ║");
                System.out.println("╚═════════════════════════════════════════════════════════════════════════╝");
                System.out.print("👉 카테고리 선택 : ");

                int ch = scan.nextInt();

                if(ch == 0){
                    System.out.println("> 메인 화면으로 이동합니다.");
                    break;
                } else if(ch > 0 && ch <= list.size()){
                    // 선택한 카테고리 객체 가져오기
                    CategoryDto selectedCategory = list.get(ch - 1);
                    System.out.println("\n[선택 완료] '" + selectedCategory.getCname() + "' 카테고리를 선택하셨습니다.");
                    
                    // TODO: 이후 해당 카테고리의 상품 목록 화면으로 이동 (예: ProductUserView.getInstance().run(selectedCategory.getCno());)
                } else {
                    System.out.println("[경고] 목록에 있는 번호를 입력해 주세요.");
                }

            } catch(InputMismatchException e){
                scan = new Scanner(System.in);
                System.out.println("[다시입력] 숫자만 입력해 주세요.");
            }
        }
    }
}
