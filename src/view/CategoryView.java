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


    
    
}
