package com.qinweizhao.exception;

/**
 * @author qinweizhao
 * @since 2022-04-13
 */
public class BusinessException extends  BaseException{
    private static final long serialVersionUID = 1L;

    public BusinessException(IResponse responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }

    public BusinessException(IResponse responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}

