package com.qinweizhao.basic.async.d;

/**
 * @author qinweizhao
 * @since 2023-02-15
 */
public interface AsyncService {

    void sendSms(String callPrefix, String mobile, String actionType, String content);

    void sendEmail(String email, String subject, String content);
}