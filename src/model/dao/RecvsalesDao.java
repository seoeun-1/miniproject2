package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.RecvsalesDto;

public class RecvsalesDao extends IBaseDao {

    private RecvsalesDao() {}

    private static final RecvsalesDao instance = new RecvsalesDao();

    public static RecvsalesDao getInstance() {
        return instance;
    }

    // [기능 1] 상품 판매 관리

    // 구매 가능한 개별 상품 조회
    public ArrayList<RecvsalesDto> findAllProduct() {

        ArrayList<RecvsalesDto> list = new ArrayList<>();

        String sql =
                "SELECT m.mno, "
                + "p.pname, "
                + "p.pprice, "
                + "m.mdate, "
                + "p.pstatus "
                + "FROM management m "
                + "JOIN product p ON m.pno = p.pno "
                + "WHERE m.mstatus = '판매중/입고' "
                + "ORDER BY m.mno";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                RecvsalesDto dto = new RecvsalesDto();

                dto.setMno(rs.getInt("mno"));
                dto.setPname(rs.getString("pname"));
                dto.setPprice(rs.getInt("pprice"));
                dto.setMdate(rs.getString("mdate"));
                dto.setPstatus(rs.getBoolean("pstatus"));

                list.add(dto);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }


    // 상품 판매 처리
    public boolean saleProduct(int purchaseNo) {

        String sql =
                "UPDATE management "
                + "SET mstatus = '판매', "
                + "out_date = CURDATE() "
                + "WHERE mno = ? "
                + "AND mstatus = '판매중/입고'";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, purchaseNo);

            int count = ps.executeUpdate();

            return count > 0;

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
                "SELECT pno, pname, pprice, pstatus "
                + "FROM product "
                + "ORDER BY pno";

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
                "UPDATE product "
                + "SET pstatus = 1 "
                + "WHERE pno = ?";

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
                "UPDATE product "
                + "SET pstatus = 0 "
                + "WHERE pno = ?";

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