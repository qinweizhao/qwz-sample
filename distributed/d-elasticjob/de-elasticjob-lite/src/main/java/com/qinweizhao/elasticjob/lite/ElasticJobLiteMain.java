package com.qinweizhao.elasticjob.lite;


import com.qinweizhao.elasticjob.lite.job.MyJob;
import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.OneOffJobBootstrap;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.ScheduleJobBootstrap;
import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperConfiguration;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;

public class ElasticJobLiteMain {

    public static void main(String[] args) {

        // 定时调度
        schedule();

        // 一次行调度
        oneOff();
    }

    private static void oneOff() {
        OneOffJobBootstrap jobBootstrap = new OneOffJobBootstrap(createRegistryCenter(), new MyJob(), createJobConfiguration());
        // 可多次调用一次性调度
        jobBootstrap.execute();
        jobBootstrap.execute();
        jobBootstrap.execute();
    }

    private static void schedule() {
        // 调度基于 class 类型的作业
        new ScheduleJobBootstrap(createRegistryCenter(), new MyJob(), createJobConfiguration()).schedule();
    }


    /**
     * 作业配置
     *
     * @return JobConfiguration
     */
    private static JobConfiguration createJobConfiguration() {
        return JobConfiguration.newBuilder("MyJob", 3).cron("0/5 * * * * ?").build();
    }

    /**
     * 注册中心配置
     *
     * @return CoordinatorRegistryCenter
     */
    private static CoordinatorRegistryCenter createRegistryCenter() {
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("localhost:2181", "my-job"));
        regCenter.init();
        return regCenter;
    }

}
