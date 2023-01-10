package com.qinweizhao.config;

import ch.qos.logback.core.PropertyDefinerBase;

import java.io.File;

/**
 * @author qinweizhao
 * @since 2021-09-07
 */
public class LogOutPathConfig extends PropertyDefinerBase {
    @Override
    public String getPropertyValue() {
        String outPath = System.getProperty("user.home") + File.separator;
        System.out.println("路径：" + outPath);
        return outPath;
    }
}
