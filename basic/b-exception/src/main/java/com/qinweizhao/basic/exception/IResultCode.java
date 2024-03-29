package com.qinweizhao.basic.exception;

/**
 * @author qinweizhao
 * @since 2022-04-13
 */
public interface IResultCode {

    /**
     * 获取业务码
     *
     * @return 业务码
     */
    Integer getCode();

    /**
     * 获取信息
     *
     * @return 返回结构体中的信息
     */
    String getMsg();

}
