package model.dto;

public class InventoryDto extends SuperDto{
    String pname;
    int inventory;
    public InventoryDto() {
    }
    public InventoryDto(String pname, int inventory) {
        this.pname = pname;
        this.inventory = inventory;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public int getInventory() {
        return inventory;
    }
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
    
    @Override
    public String toString() {
        return "Inventory [pname=" + pname + ", inventory=" + inventory + "]";
    }

    
}
