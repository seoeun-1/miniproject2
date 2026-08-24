/* 
package controller;

import java.util.ArrayList;
import model.dto.AdminDto;
import model.dto.ManagementDto;
import model.dao.AdminDao;

public class Admincontroller {
    private Admincontroller(){}
    private static final Admincontroller instance = new Admincontroller();
    public static Admincontroller getInstance(){
        return instance;
    }

    private AdminDao ad = AdminDao.getInstance();

    // 상품별 입고 이력 조회
    public ArrayList<ManagementDto> findAllIn(int pno) {
    ArrayList<ManagementDto> result = ad.findAllIn(pno);
        return result;
    }

    //상품별 판매 이력 조회
    public ArrayList<ManagementDto> findAllout(int pno) {
        ArrayList<ManagementDto> result = ad.findAllout(pno);
        return result;
    }

    ////날짜별 입고.판매 내역 조회
    public ArrayList<ManagementDto> findAllDate(String date) {
        ArrayList<ManagementDto> result = ad.findAllDate(date);
        return result;
    }

}
*/