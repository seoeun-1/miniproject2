package model;

import java.util.Arrays;

public class JunStack<T> {

    //배열 
    private Object[] items;
    // 맨위 데이터 위치
    private int top = -1;
    private int num = 10;
    
    public JunStack() {
        items = new Object[num];
    }



    public int size(){
        return top+1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public T peek(){
        if(isEmpty()){
            //비어있으면 예외처리
            throw new IllegalStateException("스택이 비어 있습니다.");
        }else{
            return (T)items[top];
        }
    }
    public void push(T data){
        // 맨위 데이터와 배열마지막 인덱스가 같다면 배열 추가
        if(top==items.length-1){
            items = Arrays.copyOf(items, items.length * 2);
        }

        //맨위 위치 올리고 그 인덱스에 데이터 추가
        items[++top] = data;
    }

    public T pop(){
        T result;
        if(isEmpty()){
            //비어있으면 예외처리
            throw new IllegalStateException("스택이 비어 있습니다.");
        }else{
            // 맨위에 있는 값 꺼내기 후 top 내리기
            result = (T) items[top];
            items[top] = null;
            top--;
        }
        

        // 스택에 있는 값의 개수가 배열길이의 25%보다 작으면 50% 배열 줄이기
        if(items.length > 10&&size() <= items.length/4){
        items = Arrays.copyOf(items, items.length / 2); 
        }
        return result;
    }
    
}


