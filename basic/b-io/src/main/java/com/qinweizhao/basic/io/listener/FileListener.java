package com.qinweizhao.basic.io.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/**
 * @author qinweizhao
 * @since 2023-06-21
 */
@Slf4j
public class FileListener extends FileAlterationListenerAdaptor {

    /**
     * File system observer started checking event.（文件系统观察者开始检查事件）
     *
     * @param observer The file system observer (ignored)
     */
    @Override
    public void onStart(FileAlterationObserver observer) {
        super.onStart(observer);
    }

    /**
     * Directory created Event.
     *
     * @param directory The directory created (ignored)
     */
    @Override
    public void onDirectoryCreate(File directory) {
        log.info("创建文件夹 : {}",directory.getAbsolutePath());
    }

    /**
     * Directory changed Event.
     *
     * @param directory The directory changed (ignored)
     */
    @Override
    public void onDirectoryChange(File directory) {
        log.info("修改文件夹 : {}",directory.getAbsolutePath());
    }

    /**
     * Directory deleted Event.
     *
     * @param directory The directory deleted (ignored)
     */
    @Override
    public void onDirectoryDelete(File directory) {
        log.info("删除文件夹 : {}",directory.getAbsolutePath());
    }

    /**
     * File created Event.
     *
     * @param file The file created (ignored)
     */
    @Override
    public void onFileCreate(File file) {
        log.info("创建文件 : {}",file.getAbsolutePath());
    }

    /**
     * File changed Event.
     *
     * @param file The file changed (ignored)
     */
    @Override
    public void onFileChange(File file) {
        log.info("修改文件 : {}",file.getAbsolutePath());
    }

    /**
     * File deleted Event.
     *
     * @param file The file deleted (ignored)
     */
    @Override
    public void onFileDelete(File file) {
        log.info("删除文件 : {}",file.getAbsolutePath());
    }

    /**
     * File system observer finished checking event.（文件系统观察者已完成检查事件）
     *
     * @param observer The file system observer (ignored)
     */
    @Override
    public void onStop(FileAlterationObserver observer) {
        super.onStop(observer);
    }

}
