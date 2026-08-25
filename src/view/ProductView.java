package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ProductController;
import model.dao.ProductDao;
import model.dto.ProductDto;

public class ProductView {
    // 싱글톤 패턴
    private ProductView(){}
    private static final ProductView instance = new ProductView();
    public static ProductView getInstance(){ return instance; }

    // mvc패턴에 의해 controller 싱글톤 호출
    private ProductController pc = ProductController.getInstance();

    // 입력객체 
    Scanner scan = new Scanner(System.in);

    // 메뉴고르기 
    public void pmenu(){
        while (true) {
            System.out.println("┌──────────────────────────── 상품 관리 ────────────────────────────┐");
            System.out.println("│                                                                   │");
            System.out.println("│   1. 상품 등록        │   2. 상품 전체 조회                       │");
            System.out.println("│   3. 상품 수정        │   4. 상품 삭제        │   5. 뒤로가기     │");
            System.out.println("│                                                                   │");
            System.out.println("└───────────────────────────────────────────────────────────────────┘");
            System.out.print("메뉴 선택 : ");  int ch = scan.nextInt();

            if(ch == 1){
                psave();
            }
            else if( ch == 2 ){
                pfindAll();
            }
            else if( ch == 3 ){
                pupdate();
            }
            else if( ch == 4 ){
                pdelete();
            }
            else if( ch == 5 ){
               // 뒤로가기 함수 지금은 종료
               break;
            }
        }
    }




    // [1] C 입력
    public void psave(){

        // 상품 정보 입력받기 , 상품번호와 판매여부는 자동 부여됨 나머지값만 받음. 
        System.out.print("상품명을 입력해주세요 : "); String 상품명 = scan.next();
        System.out.print("상품가격을 입력해주세요 : "); int 상품가격 = scan.nextInt();
        // 여기에 카테고리 현재 있는 번호 출력해주면 좋을 거 같음 (FK에서 없는 키값은 받을 수 없기 때문에)
        System.out.print("카테고리 번호를 입력해주세요 : "); int 카테고리번호 = scan.nextInt();

        // 입력받은 값을 ProductDto 형으로 객체 생성 / 생성자 설정해둠
        ProductDto productDto = new ProductDto(상품명, 상품가격, 카테고리번호);

        boolean result = pc.psave(productDto);
        if(result){System.out.println("[안내] 상품이 성공적으로 등록 되었습니다");}
        else{System.out.println("[경고] 상품 등록 실패");}
    }

    // [2] R 전체 조회
    public void pfindAll( ){
        // 우선은 예제에서 배운것처럼 ArrayList로 결과 받기 
        ArrayList<ProductDto> result = pc.pfindAll();
        for( ProductDto dto : result){
            System.out.println(dto.toString());
        }
    }

    // [3] U
    public void pupdate( ){
        // 상품번호만 보여주는 함수 구현에서 넣기 
        System.out.print("수정하고자 하는 상품의 번호를 입력하세요");
        int ch = scan.nextInt();

        // 상품 정보 입력받기 , 상품번호와 판매여부는 자동 부여됨 나머지값만 받음. 
        System.out.print("상품명을 입력해주세요 : "); String 상품명 = scan.next();
        System.out.print("상품가격을 입력해주세요 : "); int 상품가격 = scan.nextInt();
        System.out.print("카테고리 번호를 입력해주세요 : "); int 카테고리번호 = scan.nextInt();
        ProductDto productDto = new ProductDto(상품명, 상품가격, 카테고리번호);


        boolean result = pc.pupdate(productDto, ch);
        if(result){System.out.println("[안내] 상품이 성공적으로 수정 되었습니다");}
        else{System.out.println("[경고] 등록된 상품번호가 없습니다. ");}
    }


    // [4] D 상품삭제
    public void pdelete(){
        //  상품 번호 전체 보여주는 함수 구현하면 좋을거 같음.
        System.out.print("수정하고자 하는 상품의 번호를 입력하세요");
        int ch = scan.nextInt();

        boolean result = pc.pdelete(ch);

        if(result){System.out.println("[안내] 상품이 성공적으로 수정 되었습니다");}
        else{System.out.println("[경고] 등록된 상품번호가 없습니다. ");}

    }


    
}
