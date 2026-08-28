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

    // 판매 가능한 상품 전체 조회
    public ArrayList<RecvsalesDto> findAllProduct() {
        return rd.findAllProduct();
    }

    // 구매번호를 이용한 상품 판매 처리
    public boolean saleProduct(int purchaseNo) {
        return rd.saleProduct(purchaseNo);
    }

    // [기능 2] 판매여부 관리

    // 상품 판매여부 전체 조회
    public ArrayList<RecvsalesDto> findAllStatus() {
        return rd.findAllStatus();
    }

    // 판매중으로 변경
    public boolean startSales(int pno) {
        return rd.startSales(pno);
    }

    // 판매중지로 변경
    public boolean stopSales(int pno) {
        return rd.stopSales(pno);
    }
}