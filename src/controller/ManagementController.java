package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import model.dao.ManageProdJoinDao;
import model.dao.ManagementDao;
import model.dto.InventoryDto;
import model.dto.ManageProdJoinDto;
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

    private ManageProdJoinDao mpd = ManageProdJoinDao.getInstance();


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

    public List<Map<String,Object>> deadlineProductFind(){
        List<Map<String,Object>> list = new ArrayList<>();
        
        List<ManageProdJoinDto> MPJDTO = mpd.MPJfind();
        
        for(ManageProdJoinDto i : MPJDTO){
            if(i.getMstatus().equals("판매중/입고")){
                Map<String,Object> maplist = new HashMap();
                maplist.put("mno", i.getMno());
                maplist.put("pname", i.getPname());
                maplist.put("mdate", i.getMdate());
                list.add(maplist); 
            }
        }
        return list;
    }

    public boolean deadlineProductUpdate(int mno,String mstatus){
        boolean result = mpd.deadlineProductUpdate(mno, mstatus);
        return result;

    }
    // public List<DeadlineDiscountDto> deadlinediscount(){
    //     return md.Deadlinediscount();
    // }
}