package com.qinweizhao.fsca.auth.excepion;

import com.qinweizhao.fsca.auth.model.Result;
import com.qinweizhao.fsca.auth.model.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedGrantTypeException;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

/**
 * @author qinweizhao
 * @since 2022-06-07
 */
public class OAuthServerWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
    /**
     * 业务处理方法，重写这个方法返回客户端信息
     */
    @Override
    public ResponseEntity<Result> translate(Exception e) {
        Result resultMsg = doTranslateHandler(e);
        return new ResponseEntity<Result>(resultMsg, HttpStatus.UNAUTHORIZED);
    }

    /**
     * 根据异常定制返回信息
     * TODO 自己根据业务封装
     */
    private Result doTranslateHandler(Exception e) {
        //初始值，系统错误，
        ResultCode resultCode = ResultCode.UNAUTHORIZED;
        //判断异常，不支持的认证方式
        if (e instanceof UnsupportedGrantTypeException) {
            //不支持的授权类型异常
            resultCode = ResultCode.UNSUPPORTED_GRANT_TYPE;
        } else if (e instanceof InvalidGrantException) {
            //用户名或密码异常
            resultCode = ResultCode.USERNAME_OR_PASSWORD_ERROR;
        }
        return new Result(resultCode.getCode(), resultCode.getMsg(), null);
    }
}
