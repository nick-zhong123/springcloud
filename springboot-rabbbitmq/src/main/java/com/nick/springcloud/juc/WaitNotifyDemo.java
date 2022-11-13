package com.nick.springcloud.juc;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WaitNotifyDemo {

    static boolean flag = true;
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new WaitRunnable(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new NotifyRunnable(), "NotifyThread");
        notifyThread.start();
    }

    public static class WaitRunnable implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while(flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. Waiting @" + LocalDateTime.now());
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + " flag is false. Running @" + LocalDateTime.now());
            }
        }

    }

    public static class NotifyRunnable implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock. Nofity @" + LocalDateTime.now());
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. Sleep @" + LocalDateTime.now());
                SleepUtils.second(5);
            }
        }
    }

}
