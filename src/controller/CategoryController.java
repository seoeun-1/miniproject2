package controller;

import model.dao.CategoryDao;
import model.dto.CategoryDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryController {
    private static CategoryController instance = new CategoryController();
    public static CategoryController getInstance() { return instance; }
    public CategoryDao cd = CategoryDao.getInstance();


// 카테고리 전체 조회 Controller (홀 매니저의 일)
public ArrayList<CategoryDto> cateFindall() {
    
    // 1. 손님(View)이 주문을 했으니, 주방(DAO)에 있는 친구(cd)한테 "카테고리 전부 가져와!" 하고 심부름을 시킵니다.
    // 그리고 주방에서 수레(List)를 받아와서 'result'라는 변수에 담아둡니다.
    ArrayList<CategoryDto> result = cd.cateFindall(); 
    
    // 2. 주방에서 받아온 수레(결과)를 그대로 손님(View)에게 전달(return)해 줍니다.
    return result;
}



// [카테고리 등록 Controller]
public boolean cateRegister(CategoryDto categoryDto) {
    // DAO에게 DTO를 넘겨주며 등록 처리를 부탁하고, 성공 여부(boolean)를 돌려받습니다.
    boolean result = cd.cateRegister(categoryDto);
    return result;
}


// [카테고리 수정 Controller]
public boolean cateUpdate(CategoryDto categoryDto) {
    // DAO에게 DTO를 넘겨주고 수정 결과를 받아옵니다.
    boolean result = cd.cateUpdate(categoryDto);
    return result;
}


// [카테고리 삭제 Controller]
public boolean cateDelete(int cno) {
    // DAO에게 번호를 건네주고 삭제 결과를 받아옵니다.
    boolean result = cd.cateDelete(cno);
    return result;
}



    }
