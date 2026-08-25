package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.dao.CategoryDao;
import model.dto.CategoryDto;

public class CategoryController {
    // [*] 싱글톤 패턴
    private CategoryController(){}
    private static final CategoryController instance = new CategoryController();
    public static CategoryController getInstance(){ return instance; }

    // [*] DAO 싱글톤 호출
    private CategoryDao cd = CategoryDao.getInstance();

    // [1] 카테고리 전체조회 Controller 
    public ArrayList<CategoryDto> findAll(){
        ArrayList<CategoryDto> result = cd.findAll();
        return result;
    }
}