package com.qinweizhao.basic.async.f;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author qinweizhao
 * @since 2023-02-15
 */
@Slf4j
@Component
public class CallbackProducer {

    @Resource
    AmqpTemplate amqpTemplate;

    public void sendCallbackMessage(String msg, final long delayTimes) {

        log.info("生产者发送消息，callbackDTO，{}", msg);

        amqpTemplate.convertAndSend("Exchange", "RoutingKey", msg, message -> {
            //给消息设置延迟毫秒值，通过给消息设置x-delay头来设置消息从交换机发送到队列的延迟时间
            message.getMessageProperties().setHeader("x-delay", delayTimes);
            message.getMessageProperties().setCorrelationId(msg);
            return message;
        });
    }
}

