package model.dao;

import java.security.PrivateKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.SaleDto;


// 사용자나 관리자에서 선언해서 사용하면됨.  매개변수 SaleDto로 받으면 됨. 
public class SaleDao extends IBaseDao {
    // 싱글톤으로 선언 
    private SaleDao(){}
    private static final SaleDao instance = new SaleDao();
    public static SaleDao getInstance() { return instance; }

    // 일단 출력만 만들면 됨. 
    public ArrayList<SaleDto> salefindall(){
        ArrayList<SaleDto> list = new ArrayList<>();
        try{
            String sql = "SELECT m.mno, c.cno, c.cname, p.pname, p.pprice, m.mdate FROM management m INNER JOIN product p ON m.pno = p.pno INNER JOIN category c ON p.cno = c.cno ORDER BY m.mno ASC;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                SaleDto saleDto = new SaleDto();
                saleDto.setMno(rs.getInt("mno"));
                saleDto.setCno(rs.getInt("cno"));
                saleDto.setCname(rs.getString("cname"));
                saleDto.setPname(rs.getString("pname"));
                saleDto.setMdate(rs.getDate("mdate").toLocalDate());  // date 타입을 localdate타입으로 변환
                saleDto.setPprice(rs.getInt("pprice"));
                

                list.add(saleDto);

            }  // 반복문 종료 
        }catch(SQLException e){ System.out.println("할인정보 가져오기 실패"); }
        return list;
    } // salefindall end

}
