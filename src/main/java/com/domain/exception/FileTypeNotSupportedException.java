package com.domain.exception;

/**
 * Claim that the file type is not supported in our system
 *
 * @author hao.e.chen
 * @date 26/12/2017
 */
public class FileTypeNotSupportedException extends Exception {

    public FileTypeNotSupportedException() {
    }

    public FileTypeNotSupportedException(String s) {
        super(s);
    }

    public FileTypeNotSupportedException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public FileTypeNotSupportedException(Throwable throwable) {
        super(throwable);
    }

    public FileTypeNotSupportedException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
