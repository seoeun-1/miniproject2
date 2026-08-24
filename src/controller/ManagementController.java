package controller;

import model.dao.ManagementDao;

public class ManagementController {
    //생성자
    private ManagementController(){}
    //객체생성
    private static final ManagementController instance = new ManagementController();
    //getter
    public static ManagementController getInstance(){ return instance; }
    
    //[*] MVC패턴 흐름의 dao 싱글톤 호출
    private ManagementDao bd = ManagementDao.getInstance();

    
}