package model.dao;

// 💡 필요한 import 구문들 추가
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.CategoryDto; // Dto 패키지 import

public class CategoryDao extends IBaseDao {
    // [*] 싱글톤 패턴
    private CategoryDao(){
        super();
    }
    private static final CategoryDao instance = new CategoryDao();
    public static CategoryDao getInstance(){ return instance; }


    // [1] 카테고리 전체조회 DAO
    public ArrayList<CategoryDto> findAll(){
        ArrayList<CategoryDto> list = new ArrayList<>();
        try {
            String sql = "select * from category";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setCno(rs.getInt("cno"));
                categoryDto.setCname(rs.getString("cname"));
                list.add(categoryDto);
            }
        } catch(SQLException e) { 
            System.out.println(e); 
        }
        return list;
    }
}