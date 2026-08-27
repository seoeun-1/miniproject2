package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.DailysalesDto;

public class DailysalesDao extends IBaseDao{
    private DailysalesDao() {}
    private static final DailysalesDao instance = new DailysalesDao();
    public static DailysalesDao getInstance() {
        return instance;
    }

    // 오늘 판매 매출 조회
    public ArrayList<DailysalesDto> findAllTodaySales(String date) {

        ArrayList<DailysalesDto> list = new ArrayList<>();

        String sql =
                "SELECT product.pname, product.pprice, " +
                "COUNT(*) AS salescount, " +
                "SUM(product.pprice) AS salesamount " +
                "FROM management " +
                "JOIN product ON management.pno = product.pno " +
                "WHERE management.mstatus = '판매' " +
                "AND management.out_date = ? " +
                "GROUP BY management.pno, product.pname, product.pprice " +
                "ORDER BY management.pno";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DailysalesDto dailysalesdto = new DailysalesDto();
                dailysalesdto.setPname(rs.getString("pname"));
                dailysalesdto.setPprice(rs.getInt("pprice"));
                dailysalesdto.setSalescount(rs.getInt("salescount"));
                dailysalesdto.setSalesamount(rs.getInt("salesamount"));

                list.add(dailysalesdto);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }


    // 오늘 총 매출 조회
    public int findAllTodayTotalSales(String date) {

        // 오늘 총 매출
        int totalsales = 0;

        String sql =
                "SELECT COALESCE(SUM(product.pprice), 0) " +
                "AS totalsales " +
                "FROM management " +
                "JOIN product ON management.pno = product.pno " +
                "WHERE management.mstatus = '판매' " +
                "AND management.out_date = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                totalsales =rs.getInt("totalsales"); 
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return totalsales;
    }
}