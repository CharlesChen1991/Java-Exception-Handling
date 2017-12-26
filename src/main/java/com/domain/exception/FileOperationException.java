package com.domain.exception;

/**
 * This exception is to claim that exception occur during file operation
 *
 * @author hao.e.chen
 * @date 26/12/2017
 */
public class FileOperationException extends Exception {

    public static final String ERROR_FORMAT_INCORRECT = "OE01";
    public static final String ERROR_ILLEGAL_CONTENT = "OE02";

    public FileOperationException() {
    }

    public FileOperationException(String s) {
        super(s);
    }

    public FileOperationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public FileOperationException(Throwable throwable) {
        super(throwable);
    }

    public FileOperationException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
