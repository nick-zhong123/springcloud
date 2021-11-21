package com.nick.springboot.demo.jvm;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class HelloClassLoader extends ClassLoader {


    public static void main(String[] args) {
        try {
            new HelloClassLoader().findClass("com.nick.springboot.demo.jvm.HelloByteCode").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String base64 = "yv66vgAAADQAIQoACAASBwATCgACABIJABQAFQgAFgoAFwAYCAAZBwAaAQAGPGluaXQ+AQADKClWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEABG1haW4BABYoW0xqYXZhL2xhbmcvU3RyaW5nOylWAQAIPGNsaW5pdD4BAApTb3VyY2VGaWxlAQASSGVsbG9CeXRlQ29kZS5qYXZhDAAJAAoBACpjb20vbmljay9zcHJpbmdib290L2RlbW8vanZtL0hlbGxvQnl0ZUNvZGUHABsMABwAHQEAFkhlbGxvQnl0ZUNvZGUgbWFpbiBydW4HAB4MAB8AIAEAHUhlbGxvQnl0ZUNvZGUgc3RhdGljIG1haW4gcnVuAQAQamF2YS9sYW5nL09iamVjdAEAEGphdmEvbGFuZy9TeXN0ZW0BAANvdXQBABVMamF2YS9pby9QcmludFN0cmVhbTsBABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgEAFShMamF2YS9sYW5nL1N0cmluZzspVgAhAAIACAAAAAAAAwABAAkACgABAAsAAAAdAAEAAQAAAAUqtwABsQAAAAEADAAAAAYAAQAAAAMACQANAA4AAQALAAAAMQACAAIAAAARuwACWbcAA0yyAAQSBbYABrEAAAABAAwAAAAOAAMAAAAKAAgACwAQAAwACAAPAAoAAQALAAAAJQACAAAAAAAJsgAEEge2AAaxAAAAAQAMAAAACgACAAAABgAIAAcAAQAQAAAAAgAR";
        byte[] bytes = decode(base64);
        return defineClass(name, bytes, 0, bytes.length);
    }

    public byte[] decode(String base64) {
        return Base64.decode(base64);
    }

}
