import java.util.ArrayList;

import model.dao.ProductDao;
import model.dao.SaleDao;
import model.dto.SaleDto;
import view.ProductView;

/* 
public class AppStart {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

    }
}
*/

import view.DailysalesView;

public class AppStart {

    public static void main(String[] args) {

        DailysalesView.getInstance().amenu();

    }
}