package controller;

import java.util.List;

import model.dao.ManagementDao;
import model.dto.InventoryDto;
import model.dto.ManagementDto;
import model.dto.ProductManagementDto;

public class ManagementController {
    //생성자
    private ManagementController(){}
    //객체생성
    private static final ManagementController instance = new ManagementController();
    //getter
    public static ManagementController getInstance(){ return instance; }
    
    //[*] MVC패턴 흐름의 dao 싱글톤 호출
    private ManagementDao md = ManagementDao.getInstance();



    public boolean msave(int pno){
        boolean result = md.msave(pno); 
        return result;
    }

    public List<ManagementDto> mfind(){
        return md.mfind();
    }

    public boolean mupdate(ManagementDto managementDto){
        return md.mupdate(managementDto);
        
    }

    public boolean mdelete(int mno){
        return md.mdelete(mno);
        
    }

    public List<InventoryDto> inventory(){
        return md.inventory();
    }

    public List<DeadlineDiscountDto> deadlinediscount(){
        return md.Deadlinediscount();
    }
}