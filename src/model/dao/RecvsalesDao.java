package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.RecvsalesDto;

public class RecvsalesDao extends IBaseDao {
    private RecvsalesDao(){}
    private static final RecvsalesDao instance = new RecvsalesDao();
    public static RecvsalesDao getInstance() {return instance;}

    // 1. 상품 판매 / 재고 관리
    // 판매 가능한 상품과 현재 재고 조회
    public ArrayList<RecvsalesDto> findAllProduct() {
        ArrayList<RecvsalesDto> list = new ArrayList<>();
        String sql =
                "SELECT proudct.pno, proudct.pname, proudct.pprice, proudct.pstatus, " +
                "COUNT(management.mno) AS inventory " +
                "FROM product " +
                "LEFT JOIN management " +
                "ON proudct.pno = management.pno " +
                "AND management.mstatus = '판매중/입고' " +
                "WHERE proudct.pstatus = 1 " +
                "GROUP BY proudct.pno, proudct.pname, proudct.pprice, proudct.pstatus " +
                "ORDER BY proudct.pno";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RecvsalesDto recvsalesDto = new RecvsalesDto();
                recvsalesDto.setPno(rs.getInt("pno"));
                recvsalesDto.setPname(rs.getString("pname"));
                recvsalesDto.setPprice(rs.getInt("pprice"));
                recvsalesDto.setPstatus(rs.getBoolean("pstatus"));
                recvsalesDto.setInventory(rs.getInt("inventory"));

                list.add(recvsalesDto);
            }

        } catch (SQLException e) {System.out.println(e);}

        return list;
    }


    // 상품 판매
    public boolean saleProduct(int pno, int salecount) {

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
            ps.setInt(2, salecount);

            int count = ps.executeUpdate();

            return count == salecount;

        } catch (SQLException e) {System.out.println(e);}

        return false;
    }

    // 2. 판매여부 관리
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

                RecvsalesDto recvsaledto = new RecvsalesDto();
                recvsaledto.setPno(rs.getInt("pno"));
                recvsaledto.setPname(rs.getString("pname"));
                recvsaledto.setPprice(rs.getInt("pprice"));
                recvsaledto.setPstatus(rs.getBoolean("pstatus"));

                list.add(recvsaledto);
            }

        } catch (SQLException e) {System.out.println(e);}

        return list;
    }


    // 판매중으로 변경
    public boolean startSales(int pno) {

        String sql =
                "UPDATE product " +
                "SET pstatus = 1 " +
                "WHERE pno = ?";

        try {
            PreparedStatement ps =  conn.prepareStatement(sql);

            ps.setInt(1, pno);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {System.out.println(e);}

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

        } catch (SQLException e) {System.out.println(e);}

        return false;
    }
}