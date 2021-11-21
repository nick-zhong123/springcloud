package com.nick.springboot.demo.jvm;

public class StackErrorMock {


    public static int index = 1;

    public void call() {
        index++;
        call();
    }

    public static void main(String[] args) {
        StackErrorMock stackErrorMock = new StackErrorMock();
        try {
            stackErrorMock.call();
        } catch (Throwable e) {
            System.out.println("Stack Deep:" + index);
            e.printStackTrace();
        }
    }

}
