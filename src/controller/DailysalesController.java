package controller;

import java.util.ArrayList;

import model.dao.DailysalesDao;
import model.dto.DailysalesDto;

public class DailysalesController {
    private DailysalesController(){}
    private static final DailysalesController instance = new DailysalesController();
    public static DailysalesController getInstance(){
        return instance;
    }

    private DailysalesDao ds = DailysalesDao.getInstance();

      // 오늘 판매 매출 조회
    public ArrayList<DailysalesDto> findAllTodaySales(String date) {
        return ds.findAllTodaySales(date);
    }

    // 오늘 총 매출 조회
    public int findAllTodayTotalSales(String date) {
        return ds.findAllTodayTotalSales(date);
    }
}

