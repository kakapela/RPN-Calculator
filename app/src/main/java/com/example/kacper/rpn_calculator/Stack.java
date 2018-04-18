package com.example.kacper.rpn_calculator;

import java.util.ArrayDeque;

public class Stack {

    //our stack will store float numbers
    private ArrayDeque<Double> stack = new ArrayDeque<>();

    //push number to stack
    public void push(double number) {
        stack.push(number);
    }
//clear stack
    public void clear() {
        stack.clear();
    }
    public int size(){
        return stack.size();
    }
    public double peek(){
        return stack.peek();
    }

    //first pop two last numbers from stack and than add them
    public double add() {
        //add only if we have two numbers in stack
        if (stack.size() >= 2) {
            Double x = stack.pop();
            Double y = stack.pop();

            Double result = y + x;

            //push result to stack - STACK 1
            stack.push(result);

            return result;
        } else {
            Double x = stack.pop();
            clear();
            return x;

        }
    }

    //subtract two numbers, first pop from stack then compute result
    public double sub() throws ArithmeticException {
        System.out.println(stack.size());
        if (stack.size() >= 2) {
            Double x = stack.pop();
            Double y = stack.pop();

            Double result = y - x;

            stack.push(result);
            return result;
        }  else {
            Double x = stack.pop();
            clear();
            return x;

        }
    }

    public double mal() {
        if (stack.size() >= 2) {
            Double x = stack.pop();
            Double y = stack.pop();

            Double result = y * x;

            stack.push(result);

            return result;
        } else {
            Double x=stack.pop();
            clear();
            return x;
        }
    }

    public double div()  {
        if (stack.size() >= 2) {
            Double x = stack.pop();
            Double y = stack.pop();

            Double result = y / x;

            stack.push(result);

            return result;
        } else {
            Double x=stack.pop();
            clear();
            return x;
        }
    }
}
