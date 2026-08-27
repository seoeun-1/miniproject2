package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.CategoryDto;

public class CategoryDao extends IBaseDao {

    // [*] 싱글톤 패턴
    private CategoryDao() {
        super();
    }
    private static final CategoryDao instance = new CategoryDao();
    public static CategoryDao getInstance() { return instance; }






// [4] 카테고리 전체 조회 DAO (심부름꾼 클래스 안에 있는 메서드)
public ArrayList<CategoryDto> cateFindall() {
    
    // 1. [ArrayList] : 여러 개의 데이터(가방)들을 한꺼번에 담아서 나를 수 있는 '대형 수레(리스트)'를 만듭니다.
    // CategoryDto 타입의 물건들만 담을 수 있도록 빈 리스트를 준비합니다.
    ArrayList<CategoryDto> list = new ArrayList<>(); 
    
    try {
        // 2. [SQL] : 데이터베이스(창고)에 던질 명령어("category 테이블에서 모든 걸 조회해줘")를 문자열로 작성합니다.
        String sql = "select * from category order by cno asc";

        // 3. [PreparedStatement (ps)] : 작성한 SQL 명령어를 데이터베이스로 안전하게 들고 가기 위해 포장(기재)하는 도구입니다.
        // conn은 자바와 DB를 연결해 주는 '연결 통로'입니다.
        PreparedStatement ps = conn.prepareStatement(sql); 
        
        // 4. [ResultSet (rs)] : SQL 명령어를 실제로 실행(executeQuery)하고 난 뒤, 
        // 데이터베이스에서 쏟아져 나온 **조회 결과(표 형태의 데이터)**를 통째로 받아오는 '결과 장부'입니다.
        ResultSet rs = ps.executeQuery(); 
        
        // 5. [rs.next()] : 결과 장부(rs)의 첫 번째 줄부터 마지막 줄까지 행(Row)을 하나씩 이동하며 확인할 때 쓰는 반복문입니다.
        // 다음 줄이 있으면 계속 안으로 들어와서 실행합니다.
        while (rs.next()) { 
            
            // 6. [DTO (Data Transfer Object)] : 데이터베이스의 가로 한 줄(레코드) 데이터를 
            // 자바 세상으로 안전하게 옮겨 담기 위해 매번 새로 꺼내는 **'빈 택배 상자(가방)'**입니다.
            CategoryDto categoryDto = new CategoryDto();
            
            // 7. [Setter / getInt / getString] : 장부(rs)의 특정 칸에 적힌 데이터(카테고리 번호, 이름)를 꺼내서,
            // 빈 택배 상자(categoryDto)의 각 칸에 쏙쏙 집어넣어(세팅해) 줍니다.
            categoryDto.setCno(rs.getInt("cno"));     // 'cno' 컬럼의 정수 데이터를 꺼냄
            categoryDto.setCname(rs.getString("cname")); // 'cname' 컬럼의 문자열 데이터를 꺼냄
            
            // 8. [.add()] : 정보가 가득 찬 택배 상자(DTO)를 아까 만들어 둔 대형 수레(list)에 차곡차곡 실어둡니다.
            list.add(categoryDto);
        }
        
    } catch (SQLException e) { 
        // 9. [Exception] : 창고 문이 잠겼거나 SQL 문법이 틀렸을 때 등, 에러가 발생하면 프로그램이 안 멈추고 
        // 여기서 에러 내용을 출력해 줍니다.
        System.out.println("카테고리 전체 조회 오류: " + e); 
    }
    
    // 10. [return] : 카테고리 상자들이 가득 담긴 대형 수레(list)를 이 메서드를 호출한 곳으로 최종 전달해 줍니다.
    return list;
}


// [카테고리 등록 DAO]
public boolean cateRegister(CategoryDto categoryDto) {
    try {
        // 1. 데이터베이스에 추가할 SQL 쿼리를 작성합니다. (cno는 자동번호이므로 cname만 넣습니다)
        String sql = "insert into category(cname) values(?)";
        
        // 2. SQL을 실행할 준비를 합니다.
        PreparedStatement ps = conn.prepareStatement(sql);
        
        // 3. [중요] SQL 안의 물음표(?) 자리에 사용자가 입력했던 카테고리 이름(cname)을 채워 넣습니다.
        ps.setString(1, categoryDto.getCname()); // 첫 번째 ?에 문자열 대입
        
        // 4. SQL을 실행합니다. 
        // 데이터가 변경(추가, 수정, 삭제)될 때는 executeQuery가 아니라executeUpdate()를 씁니다!
        // 실행 결과로 변경된 행(Row)의 개수가 리턴되므로, 0보다 크면 성공(true)입니다.
        int count = ps.executeUpdate();
        if (count > 0) {
            return true; // 등록 성공
        }
        
    } catch (SQLException e) {
        System.out.println("카테고리 등록 오류: " + e);
    }
    
    return false; // 실패 시 false 반환
}


// [카테고리 수정 DAO]
public boolean cateUpdate(CategoryDto categoryDto) {
    try {
        // 1. 수정할 SQL 쿼리를 작성합니다. (cno번 카테고리의 cname을 바꾼다!)
        String sql = "update category set cname = ? where cno = ?";
        
        // 2. SQL 실행 준비
        PreparedStatement ps = conn.prepareStatement(sql);
        
        // 3. 물음표(?) 두 개를 순서대로 채워 줍니다.
        ps.setString(1, categoryDto.getCname()); // 첫 번째 ? : 새로운 이름
        ps.setInt(2, categoryDto.getCno());       // 두 번째 ? : 대상 번호(where)
        
        // 4. 데이터가 바뀌는 작업이므로 executeUpdate()를 씁니다.
        // 수정된 행의 개수가 0보다 크면 성공(true)입니다.
        int count = ps.executeUpdate();
        if (count > 0) {
            return true;
        }
        
    } catch (SQLException e) {
        System.out.println("카테고리 수정 오류: " + e);
    }
    
    return false;
}

// [카테고리 삭제 DAO]
public boolean cateDelete(int cno) {
    try {
        // 1. 삭제할 SQL 쿼리를 작성합니다. (cno가 일치하는 행을 지운다!)
        String sql = "delete from category where cno = ?";
        
        // 2. SQL 실행 준비
        PreparedStatement ps = conn.prepareStatement(sql);
        
        // 3. 유일한 물음표(?) 자리에 삭제할 번호(cno)를 채워 넣습니다.
        ps.setInt(1, cno);
        
        // 4. 데이터가 지워지는(변경되는) 작업이므로 executeUpdate()를 씁니다.
        // 삭제된 행의 개수가 0보다 크면 성공(true)입니다.
        int count = ps.executeUpdate();
        if (count > 0) {
            return true;
        }
        
    } catch (SQLException e) {
        System.out.println("카테고리 삭제 오류: " + e);
    }
    
    return false;
}


}