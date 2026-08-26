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

    

}
