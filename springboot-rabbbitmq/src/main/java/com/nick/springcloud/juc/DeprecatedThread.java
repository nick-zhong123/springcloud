package com.nick.springcloud.juc;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DeprecatedThread {

    public static void main(String[] args) throws InterruptedException {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(), "PrintThread");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);
        // 将PrintThread进行暂停，输出内容工作停止
        printThread.suspend();
        System.out.println("main suspend PrintThread  at " + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

        printThread.resume();
        System.out.println("main resume PrintThread  at " + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

        printThread.stop();
        System.out.println("main stop PrintThread  at " + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

    }

    public static class Runner implements Runnable {

        @Override
        public void run() {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                System.out.println(Thread.currentThread().getName() + " Run at " + dateFormat.format(new Date()));
                SleepUtils.second(1);
            }
        }

    }

}
