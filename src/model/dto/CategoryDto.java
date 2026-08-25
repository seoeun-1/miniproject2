package model.dto;

public class CategoryDto {   // 카테고리 테이블의 정보를 담을 객체

    private int cno;        // 카테고리 번호 (PK)
    private String cname;   // 카테고리 이름

    // 1. 기본 생성자
    public CategoryDto() {}

    // 2. 등록용 생성자 (cno는 DB에서 자동증가할 때 사용)
    public CategoryDto(String cname) {
        this.cname = cname;
    }

    // 3. 전체 필드 생성자 (조회/수정용)
    public CategoryDto(int cno, String cname) {
        this.cno = cno;
        this.cname = cname;
    }

    // Getter & Setter
    public int getCno() { return cno; }
    public void setCno(int cno) { this.cno = cno; }

    public String getCname() { return cname; }
    public void setCname(String cname) { this.cname = cname; }

    // 디버깅 및 데이터 확인용 toString()
    @Override
    public String toString() {
        return "CategoryDto{" +
                "cno=" + cno +
                ", cname='" + cname + '\'' +
                '}';
    }
}
