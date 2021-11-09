package com.qinweizhao;

import java.util.concurrent.Callable;

/**
 * @author YVKG
 */
public class ThreadThree implements Callable<String> {

    @Override
    public String call() throws Exception {
        return " this is three";
    }
}
