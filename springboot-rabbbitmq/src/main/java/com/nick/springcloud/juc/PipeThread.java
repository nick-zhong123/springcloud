package com.nick.springcloud.juc;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipeThread {

    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);
        Thread printThread = new Thread(new PipePrint(in), "PrintThread");
        printThread.start();
        int recevive = 0;
        try {
            while ((recevive = System.in.read()) != -1) {
                out.write(recevive);
            }
        } finally {
            out.close();
        }

    }

    public static class PipePrint implements Runnable {

        private final PipedReader in;

        public PipePrint(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.println((char) receive);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
