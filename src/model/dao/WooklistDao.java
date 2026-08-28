package model.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;

import model.dto.ProductDto;

public class WooklistDao<T> {

    // findall함수를 사용할때 이미 클래스변수가 담긴 배열의 클래스 속성을 알고 싶은건데
    // 매개변수를 어떻게 넘겨야할지와 필요한지가 궁금해서
    // 찾아본 결과 class의 타입을 저장할 수 있음. 
    private Class<T> type;
    // 단 받을 때 

    //생성자
    public WooklistDao (Class <T> type){
        this.type = type;
    }


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
            //  size 와 top이 같으면 배열이 꽉찬것이므로 크기를 늘림
            size ++;
            // 한칸 늘린 배열 선언
            Object[] newList = new Object[size];  

            for(int i = 0 ; i < top; i++){
                newList[i] = list[i];
            } // 하나씩 새로운 배열로 복사
            list = newList; // 새로만든 배열의 주소를 list에 넘김
        }
        list[top] = value;
        top ++;
        System.out.println("등록성공");
        return true;
    }

    // for 문을 사용해서 배열을 싹 돌려서 조회 
    // 조회 
    public void findall(){ 

    for(int i = 0; i < top; i++){ 

        Object obj = list[i];
        try{ 
            Field[] field = obj.getClass().getDeclaredFields();
            
            for ( int j = 0 ; j < field.length; j++){
                // private 멤버변수에도 접근 가능하도록 설정
                // 속성값이 private라 접근이 안돼서 setAccessible을 사용하여 접근
                if(field[j].getType() == boolean.class) continue;
                field[j].setAccessible(true);

                // 해당 객체의 멤버변수 값 출력
                System.out.print(field[j].get(obj) + " ");
            }


            // 객체 하나 출력 끝나면 줄바꿈
            System.out.println();

        }catch(Exception e){
            System.out.println("조회실패");
        } 
    }
} //  f end

    // 수정

    // 삭제 
    public boolean delete( int num){
            num --;
            size--;
            Object[] newList = new Object[size];  

            for(int i = 0 ; i < top; i++){
                if(i < num){ newList[i] = list[i]; }
                else if ( i == num){continue;}
                else{ newList[i-1] = list[i];}
            } // 하나씩 새로운 배열로 복사
            list = newList; // 새로만든 배열의 주소를 list에 넘김
        
        top --;
        return true;
    }

    


    public void wookList(){}
    // ArrayList는 크기가 자동으로 조절되는 배열기반의 자바 리스트 자료구조 
    // 동적 크기조절 기능 
    // 인덱스 기반 조회 기능 
    // 순서 유지와 중복 허용
    // 수정 삭제 조회 추가 가능해야함. 
}
