package com.qinweizhao.elasticjob.lite.job;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;

/**
 * @author qinweizhao
 * @since 2022-10-14
 */
public class MyJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        int shardingItem = shardingContext.getShardingItem();
        System.out.println("shardingItem" + shardingItem);
        switch (shardingItem) {
            case 0:
                System.out.println("item 0 ");
                break;
            case 1:
                System.out.println("item 1 ");
                break;
            case 2:
                System.out.println("item 2 ");
                break;
            case 3:
                System.out.println("item 3 ");
                break;
            case 4:
                System.out.println("item 4 ");
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
