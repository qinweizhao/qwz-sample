package com.qinweizhao.basic.async.d;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qinweizhao
 * @since 2023-02-15
 */
@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    @Resource
    private MessageHandler mesageHandler;

    @Override
    @Async("taskExecutor")
    public void sendSms(String callPrefix, String mobile, String actionType, String content) {
        try {

            Thread.sleep(1000);
            mesageHandler.sendSms(callPrefix, mobile, actionType, content);

        } catch (Exception e) {
            log.error("发送短信异常 -> ", e);
        }
    }


    @Override
    @Async("taskExecutor")
    public void sendEmail(String email, String subject, String content) {
        try {

            Thread.sleep(1000);
            mesageHandler.sendEmail(email, subject, content);

        } catch (Exception e) {
            log.error("发送email异常 -> ", e);
        }
    }
}