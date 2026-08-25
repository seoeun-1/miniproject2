package model.dto;

public class CategoryDto {   // 카테고리테이블의 정보를 담을 상자 
    private int cno;        // 카테고리 번호
    private String cname;   // 카테고리 이름

    public CategoryDto() {}

    public CategoryDto(int cno, String cname) {
        this.cno = cno;
        this.cname = cname;
    }

    public int getCno() { return cno; }
    public void setCno(int cno) { this.cno = cno; }

    public String getCname() { return cname; }
    public void setCname(String cname) { this.cname = cname; }
}