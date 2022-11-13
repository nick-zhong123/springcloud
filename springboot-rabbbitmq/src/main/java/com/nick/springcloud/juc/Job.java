package com.nick.springcloud.juc;

public class Job implements Runnable {

    private String name;

    public Job(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Job :" + name + " is running.");
    }

}
