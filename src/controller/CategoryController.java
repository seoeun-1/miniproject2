package controller;

import java.util.ArrayList;

import model.dao.CategoryDao;
import model.dto.CategoryDto;

public class CategoryController {

    // [*] 싱글톤 패턴
    private CategoryController(){}
    private static final CategoryController instance = new CategoryController();
    public static CategoryController getInstance(){ return instance; }

    // [*] DAO 싱글톤 호출
    private CategoryDao cd = CategoryDao.getInstance();

    // [1] 카테고리 전체조회 (Read) - 일반 고객 & 관리자 공통
    public ArrayList<CategoryDto> findAll(){
        return cd.findAll();
    }

    // [2] 카테고리 등록 (Create) - 추후 관리자용
    public boolean save(CategoryDto categoryDto){
        return cd.save(categoryDto);
    }

    // [3] 카테고리 수정 (Update) - 추후 관리자용
    public boolean update(CategoryDto categoryDto){
        return cd.update(categoryDto);
    }

    // [4] 카테고리 삭제 (Delete) - 추후 관리자용
    public boolean delete(int cno){
        return cd.delete(cno);
    }
}