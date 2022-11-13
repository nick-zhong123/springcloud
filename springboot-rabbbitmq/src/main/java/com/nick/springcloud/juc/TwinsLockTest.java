package com.nick.springcloud.juc;

import java.util.concurrent.locks.Lock;

public class TwinsLockTest {

    public static void main(String[] args) {

        final TwinsLock lock = new TwinsLock();

        // 启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker(lock);
            w.setDaemon(true);
            w.start();
        }

        // 每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }

    }

    public static class Worker extends Thread {

        private final TwinsLock lock;

        public Worker(TwinsLock lock) {
            this.lock = lock;
        }

        public void run () {
            while (true) {
                lock.lock();
                try {
                    SleepUtils.second(1);
                    System.out.println(Thread.currentThread().getName());
                    SleepUtils.second(1);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
