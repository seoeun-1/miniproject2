package model.dao;

public class ManagementDao extends IBaseDao{
    //싱글톤
    private ManagementDao(){}
    private static final ManagementDao instance = new ManagementDao();
    public static ManagementDao getInstance(){ return instance; }



}
