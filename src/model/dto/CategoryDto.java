package model.dto;

public class CategoryDto {
    private int cno;         // 카테고리 번호 (PK)
    private String cname;    // 카테고리명

    // 1. 기본 생성자
    public CategoryDto() {}

    // 2. 매개변수 생성자
    public CategoryDto(int cno, String cname) {
        this.cno = cno;
        this.cname = cname;
    }

    // 3. Getter & Setter
    public int getCno() { return cno; }
    public void setCno(int cno) { this.cno = cno; }

    public String getCname() { return cname; }
    public void setCname(String cname) { this.cname = cname; }

    // 4. 출력용 toString (콘솔에 찍힐 때 보기 편하게)
    @Override
    public String toString() {
        return cno + ". " + cname;
    }
}