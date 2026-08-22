package view;

import controller.ManagementController;

public class ManagementView {

    private ManagementView(){} // 1.
    private static final ManagementView instance = new ManagementView(); // 2.
    public static ManagementView getInstance( ){ return instance; } // 3. 

    // [*] MVC패턴 흐름의 controller 싱글톤 호출
    private ManagementController bc = ManagementController.getInstance();


    public static void main(String[] args) {
        



        
    } //main end
} //class end
