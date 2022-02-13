package com.qinweizhao.listener;


import com.qinweizhao.event.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author qinweizhao
 * @since 2022/2/8
 */
@Component
public class MyListener2 implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println(MyListener2.class.getName() + "监听到事件源：" + event.getSource());
    }
}