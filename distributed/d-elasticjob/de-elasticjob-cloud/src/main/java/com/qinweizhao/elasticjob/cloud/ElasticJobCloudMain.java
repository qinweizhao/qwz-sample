package com.qinweizhao.elasticjob.cloud;


import com.qinweizhao.elasticjob.cloud.job.MyJob;
import org.apache.shardingsphere.elasticjob.cloud.api.JobBootstrap;

public class ElasticJobCloudMain {

    public static void main(String[] args) {
        JobBootstrap.execute(new MyJob());
    }

}
