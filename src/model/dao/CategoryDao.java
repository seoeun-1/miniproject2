package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.CategoryDto;

public class CategoryDao extends IBaseDao {

    // [*] 싱글톤 패턴
    private CategoryDao() {
        super();
    }
    private static final CategoryDao instance = new CategoryDao();
    public static CategoryDao getInstance() { return instance; }



    // 카테고리 전체 조회 DAO
    public ArrayList<CategoryDto> cateFindall() {
        ArrayList<CategoryDto> list = new ArrayList<>();

        try {
            String sql = "select * from category";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setCno(rs.getInt("cno"));
                categoryDto.setCname(rs.getString("cname"));

                list.add(categoryDto);
            }
        } catch (SQLException e) {
            System.out.println("카테고리 전체 조회 오류: " + e);
        }
        
        return list;
    }
}