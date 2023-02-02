package com.qinweizhao.basic.exception;

/**
 * Base Exception 是所有异常的父级
 *
 * @author qinweizhao
 * @since 2022-04-12
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int errCode;

    public BaseException(String errMessage) {
        super(errMessage);
    }

    public BaseException(int errCode, String errMessage) {
        super(errMessage);
        this.errCode = errCode;
    }

    public BaseException(String errMessage, Throwable e) {
        super(errMessage, e);
    }

    public BaseException(int errCode, String errMessage, Throwable e) {
        super(errMessage, e);
        this.errCode = errCode;
    }

    public BaseException(IResponse responseEnum, Object[] args, String message) {
        super(message);
        this.errCode = responseEnum.getCode();
    }

    public BaseException(IResponse responseEnum, Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.errCode = responseEnum.getCode();
    }


    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

}

