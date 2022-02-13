package com.qinweizhao;

import com.qinweizhao.event.MyEvent;
import com.qinweizhao.listener.MyListener1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author qinweizhao
 * @since 2022/2/8
 */
@SpringBootApplication
public class FsbListenerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FsbListenerApplication.class, args);

        // 装载监听
        context.addApplicationListener(new MyListener1());

        // 发布事件
        context.publishEvent(new MyEvent("测试"));
    }

}
