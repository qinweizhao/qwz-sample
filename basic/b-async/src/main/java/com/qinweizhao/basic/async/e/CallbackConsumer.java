package com.qinweizhao.basic.async.e;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author qinweizhao
 * @since 2023-02-15
 */
@Slf4j
@Component
@RabbitListener(queues = "message.callback", containerFactory = "rabbitListenerContainerFactory")
public class CallbackConsumer {

    @RabbitHandler
    public void handle(String msg, Channel channel, @Headers Map<String, Object> map) throws Exception {

        if (map.get("error") != null) {
            //否认消息
            channel.basicNack((Long) map.get(AmqpHeaders.DELIVERY_TAG), false, true);
            return;
        }

        try {

            //执行业务逻辑
            System.out.println(msg);
            //消息消息成功手动确认，对应消息确认模式acknowledge-mode: manual
            channel.basicAck((Long) map.get(AmqpHeaders.DELIVERY_TAG), false);

        } catch (Exception e) {
            log.error("回调失败 -> {}", e);
        }
    }
}


