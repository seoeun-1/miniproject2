package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.AdminDto;

public class AdminDao extends IBaseDao {
    private AdminDao() {}
    private static final AdminDao instance = new AdminDao();
    public static AdminDao getInstance() {
        return instance;
    }

    // [1] 상품별 입고 이력 조회
    public ArrayList<AdminDto> findAllIn(int pno) {

        ArrayList<AdminDto> list = new ArrayList<>();

        try {
            String sql =
                    "SELECT mstatus, pname, in_date "
                    + "FROM management "
                    + "JOIN product ON management.pno = product.pno "
                    + "WHERE management.pno = ? "
                    + "AND mstatus = '판매중/입고' "
                    + "ORDER BY in_date";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, pno);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                AdminDto admindto = new AdminDto();

                admindto.setMstatus(rs.getString("mstatus"));
                admindto.setPname(rs.getString("pname"));
                admindto.setInDate(rs.getString("in_date"));

                list.add(admindto);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    // [2] 상품별 판매 이력 조회
    public ArrayList<AdminDto> findAllOut(int pno) {

        ArrayList<AdminDto> list = new ArrayList<>();

        try {
            String sql =
                    "SELECT mstatus, pname, out_date "
                    + "FROM management "
                    + "JOIN product ON management.pno = product.pno "
                    + "WHERE management.pno = ? "
                    + "AND mstatus = '판매' "
                    + "ORDER BY out_date";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, pno);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                AdminDto admindto = new AdminDto();

                admindto.setMstatus(rs.getString("mstatus"));
                admindto.setPname(rs.getString("pname"));
                admindto.setOutDate(rs.getString("out_date"));

                list.add(admindto);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    // [3] 날짜별 입고·판매 내역 조회
    public ArrayList<AdminDto> findAllDate(String date) {

        ArrayList<AdminDto> list = new ArrayList<>();

        try {
            String sql =
                    "SELECT mstatus, pname, in_date, out_date "
                    + "FROM management "
                    + "JOIN product ON management.pno = product.pno "
                    + "WHERE in_date = ? "
                    + "OR out_date = ? "
                    + "ORDER BY mno";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, date);
            ps.setString(2, date);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                AdminDto admindto = new AdminDto();

                admindto.setMstatus(rs.getString("mstatus"));
                admindto.setPname(rs.getString("pname"));
                admindto.setInDate(rs.getString("in_date"));
                admindto.setOutDate(rs.getString("out_date"));

                list.add(admindto);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

}