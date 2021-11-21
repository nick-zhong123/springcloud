package com.nick.springboot.demo.jvm;

public class HelloByteCode {

    static {
        System.out.println("HelloByteCode static main run");
    }

    public static void main(String[] args) {
        HelloByteCode obj = new HelloByteCode();
        System.out.println("HelloByteCode main run");
    }
}
