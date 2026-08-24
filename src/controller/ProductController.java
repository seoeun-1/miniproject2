package controller;

import java.util.ArrayList;

import model.dao.ProductDao;
import model.dto.ProductDto;

public class ProductController {
    // 싱글톤 패턴
    private ProductController(){}
    private static final ProductController instance = new ProductController();
    public static ProductController getInstance(){ return instance; }

    // mvc패턴에 의해 Dao 호출
    private ProductDao pd = ProductDao.getInstance();

    // [1] C 입력
    public boolean psave(ProductDto productDto){
        boolean result = pd.psave(productDto);
        return result;
    }


    // [2] R 전체 출력
    public ArrayList<ProductDto> pfindAll(){
        ArrayList<ProductDto> result = pd.pfindAll();
        return result;
    }

    // [3] U
    public boolean pupdate(ProductDto productDto , int pno){
        boolean result = pd.pupdate(productDto, pno);
        return result;
    }

    // [4] D
    public boolean pdelete(int pno){
        int result = pd.pdelete(pno);
    }

}
