package com.qinweizhao.listener;


import com.qinweizhao.event.MyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author qinweizhao
 * @since 2022/2/8
 */
@Component
public class MyListener4 {

    @EventListener
    public void onApplicationEvent(MyEvent event) {
        System.out.println(MyListener4.class.getName() + "监听到事件源：" + event.getSource());
    }
}