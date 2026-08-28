package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.RecvsalesDto;

public class RecvsalesDao extends IBaseDao {
    private RecvsalesDao() {}
    private static final RecvsalesDao instance =  new RecvsalesDao();

    public static RecvsalesDao getInstance() {
        return instance;
    }

    // [기능 1] 상품 판매 관리

    // 상품 + 현재 재고 조회
    public ArrayList<RecvsalesDto> findAllProduct() {

        ArrayList<RecvsalesDto> list =
                new ArrayList<>();

        String sql =
                "SELECT p.pno, p.pname, p.pprice, p.pstatus, " +
                "COUNT(m.mno) AS inventory " +
                "FROM product p " +
                "LEFT JOIN management m " +
                "ON p.pno = m.pno " +
                "AND m.mstatus = '판매중/입고' " +
                "GROUP BY p.pno, p.pname, p.pprice, p.pstatus " +
                "ORDER BY p.pno";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RecvsalesDto dto = new RecvsalesDto();
                dto.setPno(rs.getInt("pno"));
                dto.setPname(rs.getString("pname"));
                dto.setPprice(rs.getInt("pprice"));
                dto.setPstatus(rs.getBoolean("pstatus"));
                dto.setInventory(rs.getInt("inventory"));

                list.add(dto);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    // 상품 판매 처리
    public boolean saleProduct(int pno, int saleCount) {

        String sql =
                "UPDATE management " +
                "SET mstatus = '판매', " +
                "out_date = CURDATE() " +
                "WHERE pno = ? " +
                "AND mstatus = '판매중/입고' " +
                "LIMIT ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, pno);
            ps.setInt(2, saleCount);

            int count = ps.executeUpdate();

            return count == saleCount;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    // [기능 2] 판매여부 관리

    // 전체 상품 판매여부 조회
    public ArrayList<RecvsalesDto> findAllStatus() {

        ArrayList<RecvsalesDto> list = new ArrayList<>();

        String sql =
                "SELECT pno, pname, pprice, pstatus " +
                "FROM product " +
                "ORDER BY pno";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                RecvsalesDto dto = new RecvsalesDto();

                dto.setPno(rs.getInt("pno"));
                dto.setPname(rs.getString("pname"));
                dto.setPprice(rs.getInt("pprice"));
                dto.setPstatus(rs.getBoolean("pstatus"));

                list.add(dto);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }


    // 판매중으로 변경
    public boolean startSales(int pno) {

        String sql =
                "UPDATE product " +
                "SET pstatus = 1 " +
                "WHERE pno = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pno);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }


    // 판매중지로 변경
    public boolean stopSales(int pno) {

        String sql =
                "UPDATE product " +
                "SET pstatus = 0 " +
                "WHERE pno = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pno);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }
}