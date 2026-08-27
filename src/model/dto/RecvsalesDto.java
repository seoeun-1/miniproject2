package model.dto;

public class RecvsalesDto {

    private int pno;
    private String pname;
    private int pprice;
    private int inventory;
    private boolean pstatus;

    public RecvsalesDto() {}

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPprice() {
        return pprice;
    }

    public void setPprice(int pprice) {
        this.pprice = pprice;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public boolean isPstatus() {
        return pstatus;
    }

    public void setPstatus(boolean pstatus) {
        this.pstatus = pstatus;
    }

    @Override
    public String toString() {
        return "AdminDto ["+ "pno=" + pno + ", pname=" + pname + ", pprice=" + pprice
                                + ", inventory=" + inventory + ", pstatus=" + pstatus + "]";
    }
}
