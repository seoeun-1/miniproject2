package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.DiscountPriceDto;
import model.dto.ManageProdJoinDto;
import model.dto.ProductManagementDto;

public class ManageProdJoinDao extends IBaseDao {

    private ManageProdJoinDao() {}

    private static final ManageProdJoinDao instance =
            new ManageProdJoinDao();

    public static ManageProdJoinDao getInstance() {
        return instance;
    }

    public List<ManageProdJoinDto> MPJfind() {
        List<ManageProdJoinDto> list = new ArrayList<>();

        try {
            String sql = """
                    SELECT mno, pname, mdate, mstatus,
                           mm.pno, pprice, pstatus, in_date, out_date
                    FROM management mm
                    JOIN product pd ON mm.pno = pd.pno
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ManageProdJoinDto pmd = new ManageProdJoinDto();

                pmd.setMno(rs.getInt("mno"));
                pmd.setPname(rs.getString("pname"));
                
                Date mdate = rs.getDate("mdate");
                Date inDate = rs.getDate("in_date");
                Date outDate = rs.getDate("out_date");

                pmd.setMdate(mdate != null ? mdate.toLocalDate() : null);
                pmd.setIn_Date(inDate != null ? inDate.toLocalDate() : null);
                pmd.setOut_date(outDate != null ? outDate.toLocalDate() : null);

                pmd.setMstatus(rs.getString("mstatus"));
                pmd.setPno(rs.getInt("pno"));
                pmd.setPprice(rs.getInt("pprice"));
                pmd.setPstatus(rs.getBoolean("pstatus"));

                list.add(pmd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    public boolean deadlineProductUpdate(int mno,String mstatus){
        try {
            String sql = "UPDATE management SET mstatus = ? WHERE mno = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mstatus);
            ps.setInt(2, mno);

            int result = ps.executeUpdate();

            if (result==1) {
                return true;
            }
        } catch (SQLException e) {

            System.out.println(e);
        }
        return false;
    }

    public List<DiscountPriceDto> discountFind() {
        List<DiscountPriceDto> list = new ArrayList<>();

        try {
            String sql = """
            SELECT mm.mno, pd.pname, pd.pprice, mm.mdate
            FROM management mm
            JOIN product pd ON mm.pno = pd.pno
            WHERE mm.mstatus IN ('판매중/입고')
            AND mm.out_date IS NULL
            AND mm.mdate BETWEEN CURDATE()
                            AND DATE_ADD(CURDATE(), INTERVAL 1 DAY)
        """;

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Date sqlMdate = rs.getDate("mdate");

                DiscountPriceDto dto = new DiscountPriceDto(
                        rs.getInt("pprice"),
                        sqlMdate != null ? sqlMdate.toLocalDate() : null
                );

                dto.setPname(rs.getString("pname"));
                dto.setOriginPrice(rs.getInt("pprice"));
                dto.setMno(rs.getInt("mno"));

                list.add(dto);
            }

        } catch (SQLException e) {
            System.out.println("discountFind 오류");
            e.printStackTrace();
        }

    return list;
}
}
