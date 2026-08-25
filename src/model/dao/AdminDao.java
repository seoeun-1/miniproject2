package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dto.AdminDto;

public class AdminDao extends IBaseDao{
    private AdminDao(){}
    private static final AdminDao instance = new AdminDao();
    public static AdminDao getInstance(){ return instance; }

    // [1] 상품별 입고 이력 조회
    public ArrayList<AdminDto> findAllIn(int pno) {
        ArrayList<AdminDto> list = new ArrayList<>();
        try {
            String sql =
                    "SELECT "
                    + "m.mstatus, "
                    + "p.pname, "
                    + "m.in_date "
                    + "FROM management m "
                    + "JOIN product p "
                    + "ON m.pno = p.pno "
                    + "WHERE m.pno = ? "
                    + "AND m.mstatus = '판매중/입고' "
                    + "ORDER BY m.in_date";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, pno);

            ResultSet rs = ps.executeQuery();

            //sql결과
            while (rs.next()) {
                AdminDto admindto = new AdminDto();
                admindto.setMstatus(rs.getString("mstatus"));
                admindto.setPname(rs.getString("pname"));
                admindto.setInDate(rs.getString("in_date"));
                // 변환한 DTO 리스트
                list.add(admindto);
            }
        //반복문 종료
        } catch (SQLException e) {System.out.println(e);}
        return list;
    }

    // [2] 상품별 판매 이력 조회
    public ArrayList<AdminDto> findAllOut(int pno) {
        ArrayList<AdminDto> list = new ArrayList<>();
        try { 
            String sql =
                    "SELECT "
                    + "m.mstatus, "
                    + "p.pname, "
                    + "m.out_date, "
                    + "(SELECT COUNT(*) "
                    + " FROM management "
                    + " WHERE pno = ? "
                    + " AND mstatus = '판매') AS saleCount "
                    + "FROM management m "
                    + "JOIN product p "
                    + "ON m.pno = p.pno "
                    + "WHERE m.pno = ? "
                    + "AND m.mstatus = '판매' "
                    + "ORDER BY m.out_date";

            PreparedStatement ps = conn.prepareStatement(sql);

            // 서브쿼리의 상품번호
            ps.setInt(1, pno);

            // 본문의 상품번호
            ps.setInt(2, pno);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AdminDto admindto = new AdminDto();
                admindto.setMstatus(rs.getString("mstatus"));
                admindto.setPname(rs.getString("pname"));
                admindto.setOutDate(rs.getString("out_date"));
                admindto.setOutCount(rs.getInt("outCount"));

                list.add(admindto);
            }
        //반복문 종료
        } catch (SQLException e) {System.out.println(e);}
        return list;
    }

    // [3] 날짜별 입고·판매 내역 조회
    // 상태 / 상품명 / 입고날짜 / 판매날짜
    public ArrayList<AdminDto> findAllDate(String date) {
        ArrayList<AdminDto> list = new ArrayList<>();
        try {
            String sql =
                    "SELECT "
                    + "m.mstatus, "
                    + "p.pname, "
                    + "m.in_date, "
                    + "m.out_date "
                    + "FROM management m "
                    + "JOIN product p "
                    + "ON m.pno = p.pno "
                    + "WHERE m.in_date = ? "
                    + "OR m.out_date = ? "
                    + "ORDER BY m.mno";

            PreparedStatement ps = conn.prepareStatement(sql);

            // 입고날짜
            ps.setString(1, date);

            // 판매날짜
            ps.setString(2, date);

            ResultSet rs = ps.executeQuery();

            //sql 결과
            while (rs.next()) {
                AdminDto admindto = new AdminDto();
                admindto.setMstatus(rs.getString("mstatus"));
                admindto.setPname(rs.getString("pname"));
                admindto.setInDate(rs.getString("in_date"));
                admindto.setOutDate(rs.getString("out_date"));

                list.add(admindto);
            }
        //반복문 종료
        } catch (SQLException e) { System.out.println(e);}
        return list;
    }
}
