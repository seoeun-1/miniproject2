import java.util.ArrayList;

import model.dao.ProductDao;
import model.dao.SaleDao;
import model.dto.SaleDto;
import view.CategoryView;
import view.ProductView;

/* 
public class AppStart {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

    }
}
*/

/* 
import view.AdminView;

public class AppStart {

    public static void main(String[] args) {

        AdminView.getInstance().amenu();

    }
}

*/

public class AppStart {
    public static void main(String[] args) {
        // 싱글톤으로 만든 CategoryView를 가져와서 메인 메뉴(index)를 실행합니다!
        CategoryView.getInstance().index();
    }
}
