package controller;

import java.util.Scanner;

import model.dao.CategoryDao;

public class CategoryController {




    private CategoryController(){}
    private static final CategoryController instance = new CategoryController();
    public static CategoryController getInstance(){ return instance; }
    public int qwer(int a){return a;}
    //[*] MVC패턴 흐름의 dao 싱글톤 호출
    private CategoryDao cd = CategoryDao.getInstance();

    public boolean cateInsert(String 카테고리){boolean result = cateInsert()}
    
}
