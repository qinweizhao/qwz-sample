package com.qinweizhao.exception;

/**
 * @author qinweizhao
 * @since 2022-4-13
 */
public enum Response implements BusinessExceptionAssert {
    /**
     * Bad licence type
     */
    BAD_LICENCE_TYPE(7001, "Bad licence type."),
    /**
     * Licence not found
     */
    LICENCE_NOT_FOUND(7002, "Licence not found.");
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;

    private Response(int code, String message){
        this.code=code;
        this.message=message;
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
