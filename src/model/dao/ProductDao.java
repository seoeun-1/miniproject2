package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.ProductDto;

public class ProductDao extends IBaseDao {
    // 싱글톤 패턴
    private ProductDao(){}
    private static final ProductDao instance = new ProductDao();
    public static ProductDao getInstance() { return instance; }

    // [1] C 입력 
    public boolean psave(ProductDto productDto){

        try{

            // SQL 작성
            String sql = "INSERT INTO product(pname, pprice, cno) VALUES(?, ?, ?)";

            // DB에 SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);  

            // SQL 문법내 ?에 매개변수 값 대입 
            ps.setString(1, productDto.getPname());
            ps.setInt(2, productDto.getPprice());
            ps.setInt(3, productDto.getCno());

            // 기재된 SQL 실행
            int result = ps.executeUpdate();  // 실행후 성공한 레코드 수 반환
            // 여기서는 insert이므로 1개행 성공 이므로 1을 반환

            if(result == 1){ return true; }

        }catch(SQLException e){System.out.println("상품등록 실패" + e);}

        // 실패하면 반환
        return false; 

    } // psace( ) end


    // [2] R 전체 출력
    public ArrayList<ProductDto> pfindAll(){
        ArrayList<ProductDto> list = new ArrayList<>();
        try{
            // sql 작성
            String sql = "select * from product";

            // sql 기재
            PreparedStatement ps = conn.prepareStatement(sql);

            // 매개 변수에 대입 , 기재된 sql문실행 .executeQuery()
            ResultSet rs = ps.executeQuery();

            // sql 결과 
            while(rs.next()) {
                // 현재 레코드 정보를 Dto로 변환
                ProductDto productDto = new ProductDto();
                productDto.setPno(rs.getInt("pno"));
                productDto.setPname(rs.getString("pname"));
                productDto.setPprice(rs.getInt("pprice"));
                productDto.setPstatus(rs.getBoolean("pstatus"));
                productDto.setCno(rs.getInt("cno"));

                // 변환한 DTO 리스트에 담기
                list.add(productDto);

                
            } //  반복문 종료
        }catch( SQLException e){System.out.println(e);}
        return list;
    } // pfindAll() end


    // [3] U 수정 
    public boolean pupdate(ProductDto productDto , int pno){
        try{
            String sql = "update product set pname = ? , pprice = ? , cno = ? where pno = ? "; // 1.1 SQL 작성
            
            PreparedStatement ps = conn.prepareStatement(sql); // 1.2 SQL 기재 *예외*
            
            ps.setString(1, productDto.getPname());// 1.3 SQL내 ? 매개변수대입
            ps.setInt(2, productDto.getPprice());
            ps.setInt(3, productDto.getCno());
            ps.setInt(4,pno);
            
            int result = ps.executeUpdate(); // 1.4 SQL 실행
            
            if(result == 1) return true; // 1.5 실행 결과 반환
        
        }catch(SQLException e){System.out.println("상품데이터 수정 오류" + e);}
        return false;
    } // pupdate( ) end


    // [4] D 상품 삭제
    public boolean pdelete(int pno){
        try{
            String sql = "delete from product where pno = ? ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,pno);

            int result = ps.executeUpdate();
            if(result == 1)return true;
        } catch(SQLException e){System.out.println("상품 삭제 오류" + e);}

        return false;
    } // pdelete


}
