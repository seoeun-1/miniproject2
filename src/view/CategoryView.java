/* 
package view;

import java.util.Scanner;

import controller.CategoryController;

public class CategoryView {CategoryController cc = CategoryController.getInstance();
     // [1] 등록 VIEW
    public void cateInsert( ){
        Scanner scan = new Scanner(System.in);
        System.out.print("카테고리명: ");     String 카테고리 = scan.next();  // 1.1 저장할 자료 입력받기 
        boolean result = cc.cateInsert( 카테고리 ); // 1.3 컨트롤러 에게 전달(dto) 하여 응답(boolean) 받기 
        if( result ){ System.out.println(">등록 성공");} // 1.4 응답받은 결과로 출력
        else{ System.out.println(">등록 실패"); }
    }

}
*/
