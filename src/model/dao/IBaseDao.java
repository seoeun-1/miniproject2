package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class IBaseDao {
    // 여러게 DAO 클래스들에게 JDBC 연동 인스턴스 상속
    //1. 연동 정보
    private String url = "jdbc:mysql://127.0.0.1:3306/foodmanager";
    private String user = "root";
    private String password = "1324";

    //2.연동 인터페이스 , protected 상속 관계이면 다른 패키지도 접근 허용
    protected Connection conn;
    
    private void connect(){
        try {
            //3-1 : mysql 드라이버 클래스 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            //3-2 ; 데이터베이스 서버와 연동후 성공하면 conn(인터페이스)대입
            conn = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            System.out.println("DB연동실패" + e);
            e.printStackTrace();
            
        }
        
    }
    //4. 기본 생성자에 연동 메소드 실행
    protected IBaseDao(){connect();}
}
