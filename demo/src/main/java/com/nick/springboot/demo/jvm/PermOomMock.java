package com.nick.springboot.demo.jvm;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class PermOomMock {

    public static void main(String[] args) {
        URL url = null;
        List<ClassLoader> classLoaders = new ArrayList<>();
        try {
            url = new File("/Users/weizhong/nick/code/java/microservice/demo/src/main/java/com/nick/springboot/demo/jvm/").toURI().toURL();
            URL[] urls = {url};
            while(true) {
                ClassLoader classLoader = new URLClassLoader(urls);
                classLoaders.add(classLoader);
                classLoader.loadClass("com.nick.springboot.demo.jvm.HelloByteCode");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
