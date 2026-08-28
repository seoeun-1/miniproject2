package controller;

import java.util.ArrayList;

import model.dao.RecvsalesDao;
import model.dto.RecvsalesDto;

public class RecvsalesController {
    private RecvsalesController() {}
    private static final RecvsalesController instance = new RecvsalesController();
    public static RecvsalesController getInstance() {
        return instance;
    }

    private RecvsalesDao rd = RecvsalesDao.getInstance();

    // [기능 1] 상품 판매 관리
    public ArrayList<RecvsalesDto> findAllProduct() {
        return rd.findAllProduct();
    }

    public boolean saleProduct(int pno, int saleCount) {
        return rd.saleProduct(pno, saleCount);
    }


    // [기능 2] 판매여부 관리
    public ArrayList<RecvsalesDto> findAllStatus() {
        return rd.findAllStatus();
    }

    public boolean startSales(int pno) {
        return rd.startSales(pno);
    }

    public boolean stopSales(int pno) {
        return rd.stopSales(pno);
    }
}