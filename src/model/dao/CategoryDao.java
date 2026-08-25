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

    // [1] 카테고리 전체조회 (Read)
    public ArrayList<CategoryDto> findAll() {
        ArrayList<CategoryDto> list = new ArrayList<>();
        String sql = "SELECT * FROM category";

        // try-with-resources 구문으로 ps, rs 자동 close 처리
        try (PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setCno(rs.getInt("cno"));
                categoryDto.setCname(rs.getString("cname"));
                list.add(categoryDto);
            }
        } catch (SQLException e) { 
            System.out.println("[CategoryDao.findAll Error] " + e.getMessage()); 
        }
        return list;
    }

    // [2] 카테고리 등록 (Create) - 추후 관리자 기능용
    public boolean save(CategoryDto categoryDto) {
        String sql = "INSERT INTO category(cname) VALUES(?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, categoryDto.getCname());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("[CategoryDao.save Error] " + e.getMessage());
        }
        return false;
    }

    // [3] 카테고리 수정 (Update) - 추후 관리자 기능용
    public boolean update(CategoryDto categoryDto) {
        String sql = "UPDATE category SET cname = ? WHERE cno = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, categoryDto.getCname());
            ps.setInt(2, categoryDto.getCno());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("[CategoryDao.update Error] " + e.getMessage());
        }
        return false;
    }

    // [4] 카테고리 삭제 (Delete) - 추후 관리자 기능용
    public boolean delete(int cno) {
        String sql = "DELETE FROM category WHERE cno = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cno);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("[CategoryDao.delete Error] " + e.getMessage());
        }
        return false;
    }
}