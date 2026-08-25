package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import model.dto.InventoryDto;
import model.dto.ManagementDto;
import model.dto.ProductDto;
import model.dto.ProductManagementDto;

public class ManagementDao extends IBaseDao{
    //싱글톤
    private ManagementDao(){}
    private static final ManagementDao instance = new ManagementDao();
    public static ManagementDao getInstance(){ return instance; }


    //저장 DAO
    public boolean msave( int pno){
        try {
            //1.1 등록 sql 작성 , 값에 와일드 카드(?) 이용한 매개변수 대입
            String sql = "insert into management(mdate, pno, mstatus, in_date, out_date) values(?,?,?,?,?)";
            //1.2 연동된 데이터베이스에 sql 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            //1.3 기재된 sql문법내 ? (와일드 카드) 매개변수 값 대입
            ps.setDate(1, java.sql.Date.valueOf(LocalDate.now().plusDays(3)));
            ps.setInt(2, pno);
            ps.setString(3, "판매중/입고");
            ps.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
            ps.setNull(5, Types.DATE);
            //1.4 기재된 sql 실행 .executeUpdate() insert/update/delete 에서 사용
            int result = ps.executeUpdate();
            //1.5 sql 결과
            if( result == 1){
                return true;
            } //성공 반환
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    //전체조회 DAO
    public List<ManagementDto> mfind(){
        List<ManagementDto> list = new ArrayList<>();
        try {
            String sql = "SELECT mno, mdate, pno, mstatus, in_date, out_date FROM management";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) { // rs.next() :다음 레코드로 이동, 마지막 레코드까지 반복
                ManagementDto md = new ManagementDto();
                md.setMno(rs.getInt("mno"));
                md.setPno(rs.getInt("pno"));
                md.setMdate(rs.getDate("mdate").toLocalDate());
                md.setMstatus(rs.getString("mstatus"));
                md.setIn_date(rs.getDate("in_date").toLocalDate());
                md.setOut_date(rs.getDate("out_date") == null? null: rs.getDate("out_date").toLocalDate());
                list.add(md);
            }
        } catch (SQLException e) {
            System.out.println("mfind 오류");
        }
        return list;
    } 
    //수정 DAO
    public boolean mupdate(ManagementDto managementDto){
        LocalDate out_date;
        try {
            String url = "UPDATE management SET mdate = ?, mstatus = ?, out_date = ? WHERE mno = ?";
            PreparedStatement ps = conn.prepareStatement(url);
            
            ps.setDate(1, Date.valueOf(managementDto.getMdate()));
            ps.setString(2, managementDto.getMstatus());
            if(managementDto.getMstatus().equals("판매중/입고"))
                {
                 out_date = null;
                }else{
                 out_date = LocalDate.now();
                }
            if(managementDto.getOut_date() == null){
                ps.setNull(3, Types.DATE);
            }else{
                ps.setDate(3, Date.valueOf(out_date));
            }
            
            ps.setInt(4, managementDto.getMno());

            int result = ps.executeUpdate();
            if(result == 1){ return true;}
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    };

    //삭제 DAO
    public boolean mdelete(int mno){
        try {
            String url = "DELETE FROM management where mno = ?";
            PreparedStatement ps = conn.prepareStatement(url);
            ps.setInt(1, mno);
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    };

    public List<InventoryDto> inventory(){
        List<InventoryDto> list = new ArrayList<>();
        try {

            String url ="SELECT pd.pname, COUNT(*) AS inventory " +"FROM management mm " + "JOIN product pd ON mm.pno = pd.pno " +"WHERE mm.mstatus = '판매중/입고' " + "GROUP BY pd.pname";
            PreparedStatement ps = conn.prepareStatement(url);
            ResultSet rs = ps.executeQuery();

            
            
            while (rs.next()) { // rs.next() :다음 레코드로 이동, 마지막 레코드까지 반복
                InventoryDto id = new InventoryDto();
                id.setPname(rs.getString("pname"));
                id.setInventory(rs.getInt("inventory"));
                
                list.add(id);
            }

        } catch (SQLException e) {
            System.out.println("inventory 오류");
        }
        
        return list;
    }
}
