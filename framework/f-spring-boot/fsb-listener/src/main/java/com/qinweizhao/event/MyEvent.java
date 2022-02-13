package com.qinweizhao.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author qinweizhao
 * @since 2022/2/8
 */
public class MyEvent extends ApplicationEvent {

    public MyEvent(Object source) {
        super(source);
    }
}
