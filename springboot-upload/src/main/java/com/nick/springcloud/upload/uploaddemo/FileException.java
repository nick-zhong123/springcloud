package com.nick.springcloud.upload.uploaddemo;

/**
 * @author nick
 * @date 2020/6/16 10:38 PM
 * @package com.nick.springcloud.upload.uploaddemo
 * @description
 */
public class FileException extends RuntimeException {

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}
