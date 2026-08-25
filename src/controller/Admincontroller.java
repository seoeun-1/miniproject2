package controller;

import java.util.ArrayList;
import model.dto.AdminDto;
import model.dao.AdminDao;

public class Admincontroller {
    private Admincontroller(){}
    private static final Admincontroller instance = new Admincontroller();
    public static Admincontroller getInstance(){
        return instance;
    }

    private AdminDao ad = AdminDao.getInstance();

    // 상품별 입고 이력 조회
     public ArrayList<AdminDto> findAllIn(int pno) {
        return ad.findAllIn(pno);
    }

    // [2] 상품별 판매 이력 조회
    public ArrayList<AdminDto> findAllOut(int pno) {
        return ad.findAllOut(pno);
    }

    // [3] 날짜별 입고·판매 내역 조회
    public ArrayList<AdminDto> findAllDate(String date) {
        return ad.findAllDate(date);
    }
}
