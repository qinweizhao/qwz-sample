package com.qinweizhao.basic.async.e;

import com.qinweizhao.basic.async.d.MessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author qinweizhao
 * @since 2023-02-15
 */
@Slf4j
@Component
public class AsyncSendEmailEventHandler implements ApplicationListener<AsyncSendEmailEvent> {

    @Autowired
    private MessageHandler mesageHandler;

    @Async("taskExecutor")
    @Override
    public void onApplicationEvent(AsyncSendEmailEvent event) {
        if (event == null) {
            return;
        }

        String email = event.getEmail();
        String subject = event.getSubject();
        String content = event.getContent();
        String targetUserId = event.getTargetUserId();
        mesageHandler.sendEmailSms(email, subject, content, targetUserId);
    }
}

