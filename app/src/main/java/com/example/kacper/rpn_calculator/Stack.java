package com.example.kacper.rpn_calculator;

import java.util.ArrayDeque;

public class Stack {

    //our stack will store float numbers
    private ArrayDeque<Double> stack = new ArrayDeque<>();
    private Double x;
    private  Double y;
    private Double secondLastElement;
    private Double thirdLastElement;
    private Double fourthLastElement;
    boolean stackIsOver=false;

    //push number to stack
    public void push(double number) {
        stack.push(number);
    }
    public double pop() {
        return stack.pop();
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

    public Double getLastPopElement() {
        return y;
    }

    public Double getY() {
        return x;
    }

    public Double getSecondLastElement() {
        return secondLastElement;
    }

    public boolean isStackIsOver() {
        return stackIsOver;
    }

    public Double getThirdLastElement() {
        return thirdLastElement;
    }

    public Double getFourthLastElement() {
        return fourthLastElement;
    }

    //first pop two last numbers from stack and than add them
    public double add() {
        //add only if we have two or more numbers in stack
        Double result;
        if (stack.size() >= 2) {
            x = stack.pop(); //input
            y = stack.pop(); //last element which was added by enter button

            //if you dont have anything to pop set Flag -> flag set '' to firstStackInput and says it s over
            if( !(stack.size()==0) ){
                secondLastElement= stack.pop();
                stackIsOver=false;
                stack.push(secondLastElement);

                result = y + x;
                return result;

            }
            else {
              //  secondLastElement = Double.valueOf(0);
                stackIsOver = true;
                clear();
                result = y + x;
                return result;
            }

            //push result to stack - STACK 1
            //stack.push(result);

        } else {
            Double x = stack.pop();
            clear();
            return x;

        }
    }

    //subtract two numbers, first pop from stack then compute result
    public double sub() {
        //add only if we have two or more numbers in stack
        Double result;
        if (stack.size() >= 2) {
            x = stack.pop(); //input
            y = stack.pop(); //last element which was added by enter button

            //if you dont have anything to pop set Flag -> flag set '' to firstStackInput and says it s over
            if( !(stack.size()==0) ){
                secondLastElement= stack.pop();
                stackIsOver=false;
                stack.push(secondLastElement);

                result = y -x;
                return result;

            }
            else {
                //  secondLastElement = Double.valueOf(0);
                stackIsOver = true;
                clear();
                result = y - x;
                return result;
            }

            //push result to stack - STACK 1
            //stack.push(result);

        } else {
            Double x = stack.pop();
            clear();
            return x;

        }
    }
    public double mul() {
        //add only if we have two or more numbers in stack
        Double result;
        if (stack.size() >= 2) {
            x = stack.pop(); //input
            y = stack.pop(); //last element which was added by enter button

            //if you dont have anything to pop set Flag -> flag set '' to firstStackInput and says it s over
            if( !(stack.size()==0) ){
                secondLastElement= stack.pop();
                stackIsOver=false;
                stack.push(secondLastElement);

                result = y *x;
                return result;

            }
            else {
                //  secondLastElement = Double.valueOf(0);
                stackIsOver = true;
                clear();
                result = y * x;
                return result;
            }

            //push result to stack - STACK 1
            //stack.push(result);

        } else {
            Double x = stack.pop();
            clear();
            return x;

        }
    }



    public double div() {
        //add only if we have two or more numbers in stack
        Double result;
        if (stack.size() >= 2) {
            x = stack.pop(); //input
            y = stack.pop(); //last element which was added by enter button

            //if you dont have anything to pop set Flag -> flag set '' to firstStackInput and says it s over
            if( !(stack.size()==0) ){
                secondLastElement= stack.pop();
                stackIsOver=false;
                stack.push(secondLastElement);

                result = y /x;
                return result;

            }
            else {
                //  secondLastElement = Double.valueOf(0);
                stackIsOver = true;
                clear();
                result = y / x;
                return result;
            }

            //push result to stack - STACK 1
            //stack.push(result);

        } else {
            Double x = stack.pop();
            clear();
            return x;

        }
    }
    public double pow() {
        //add only if we have two or more numbers in stack
        Double result;
        if (stack.size() >= 2) {
            x = stack.pop(); //input
            y = stack.pop(); //last element which was added by enter button

            //if you dont have anything to pop set Flag -> flag set '' to firstStackInput and says it s over
            if( !(stack.size()==0) ){
                secondLastElement= stack.pop();
                stackIsOver=false;
                stack.push(secondLastElement);

                result = Math.pow(x,y);
                return result;

            }
            else {
                //  secondLastElement = Double.valueOf(0);
                stackIsOver = true;
                clear();
                result = Math.pow(x,y);
                return result;
            }

            //push result to stack - STACK 1
            //stack.push(result);

        } else {
            Double x = stack.pop();
            clear();
            return x;

        }
    }


    //METHODS FOR THREE STACK DISPLAY

    public double addThreeStack() {
        //add only if we have two or more numbers in stack
        Double result;
        if (stack.size() == 2) {
            x = stack.pop(); //input
            y = stack.pop(); //last element which was added by enter button

            //if you dont have anything to pop set Flag -> flag set '' to firstStackInput and says it s over
            if( !(stack.size()==0) ){
                secondLastElement= stack.pop();
                stackIsOver=false;
                stack.push(secondLastElement);

                result = y + x;
                return result;

            }
            else {
                //  secondLastElement = Double.valueOf(0);
                stackIsOver = true;
                clear();
                result = y + x;
                return result;
            }

            //push result to stack - STACK 1
            //stack.push(result);

        }
        else if(stack.size()>=3) {
            //add only if we have two or more numbers in stack
            x = stack.pop(); //input
            y = stack.pop(); //last element which was added by enter button
            thirdLastElement = stack.pop();
            push(thirdLastElement);

            //if you dont have anything to pop set Flag -> flag set '' to firstStackInput and says it s over
            if (!(stack.size() == 0)) {
                secondLastElement = stack.pop();
                stackIsOver = false;
                stack.push(secondLastElement);

                result = y + x;
                return result;

            } else {
                //  secondLastElement = Double.valueOf(0);
                stackIsOver = true;
                clear();
                result = y + x;
                return result;
            }

            //push result to stack - STACK 1
            //stack.push(result);
        }


        else {
            Double x = stack.pop();
            clear();
            return x;

        }
    }

}
