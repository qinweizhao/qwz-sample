package com.qinweizhao.listener;


import com.qinweizhao.event.MyEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author qinweizhao
 * @since 2022/2/8
 */
public class MyListener1 implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println(MyListener1.class.getName() + "监听到事件源：" + event.getSource());
    }
}
