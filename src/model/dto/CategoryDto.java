package model.dto;

public class CategoryDto {   // 카테고리테이블의 정보를 담을 상자 
    private int cno;
    private String cname;

    // 기본생성자 , 카테고리명만 받는 생성자 하나랑 , 전부다 받는 생성자 하나 3개
    public CategoryDto(){}
    public CategoryDto(String cname){ this.cname = cname; }
    public CategoryDto(int cno , String cname){ this.cno = cno; this.cname = cname; }


}
