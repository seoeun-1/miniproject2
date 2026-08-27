package model.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class WooklistDao<T> {

    //  배열의크기를 세팅
    private int size = 0;

    // 실제 데이터를 저장할 배열
    private Object[] list = new Object[size];

    // 현재 저장된 데이터 개수
    private int top = 0;

    // 모든 DTO를 받을 수있는 배열
    

    // 크기가 3 이고 top이 3이면 
    // 크기를 하나 늘리고 top은 그대로 대입하고 
    // 추가 
    public boolean add( T value){
        if(size ==  top){
            size += 1;
            list[top] = value;
            top++;
            return true;
        }
        return false;
    }

    // for 문을 사용해서 배열을 싹 돌려서 조회 
    // 조회 
    public void  findall (T values){
        // 특정 객체에 선언된 모든 필드(맴버변수를 목록배열(Field[]) )
        Field[] fields = values.getClass().getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName() + " : " + field.get(value));
        }
    }

    // 삭제 

    // 수정
    
    


    public void wookList(){}
    // ArrayList는 크기가 자동으로 조절되는 배열기반의 자바 리스트 자료구조 
    // 동적 크기조절 기능 
    // 인덱스 기반 조회 기능 
    // 순서 유지와 중복 허용
    // 수정 삭제 조회 추가 가능해야함. 
}
