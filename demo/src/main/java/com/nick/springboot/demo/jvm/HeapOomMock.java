package com.nick.springboot.demo.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOomMock {

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        int i  = 0;
        boolean flag = true;

        while(flag) {
            try {
                i++;
                list.add(new byte[1024 * 1024]);
            } catch (Throwable e) {
                flag = false;
                e.printStackTrace();
                System.out.println("list size:" + i);
            }
        }

    }

}
