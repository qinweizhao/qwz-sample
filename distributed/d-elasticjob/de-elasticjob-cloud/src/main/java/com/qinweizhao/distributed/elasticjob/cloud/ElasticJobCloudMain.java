package com.qinweizhao.distributed.elasticjob.cloud;


import com.qinweizhao.distributed.elasticjob.cloud.job.MyJob;
import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.cloud.executor.local.LocalTaskExecutor;

public class ElasticJobCloudMain {

    public static void main(String[] args) {

        // 本地运行
        localRun();

//        JobBootstrap.execute(new MyJob());

    }

    private static void localRun() {
        // 创建作业配置
        JobConfiguration jobConfig = JobConfiguration.newBuilder("myJob", 3).cron("0/5 * * * * ?").build();

        // 配置当前运行的作业的分片项
        int shardingItem = 1;

        // 创建本地执行器
        new LocalTaskExecutor(new MyJob(), jobConfig, shardingItem).execute();
    }

}
