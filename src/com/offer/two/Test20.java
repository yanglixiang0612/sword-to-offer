package com.offer.two;

import java.util.Stack;

public class Test20 {
    public static void main(String[] args) {

    }

    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int node){
        data.push(node);
        if(min.empty()){
            min.push(node);
        }else if(node < min.peek()){
            min.push(node);
        }
    }

    public void pop(){
        if(data.peek() == min.peek()){
            min.pop();
        }
        data.pop();
    }

    public int top(){
        return data.peek();
    }

    public int min(){
        return min.peek();
    }
}
