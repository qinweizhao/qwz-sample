package eight;

import org.junit.jupiter.api.Test;


/**
 * @author qinweizhao
 * @since 2021/11/18
 */

class StreamMainTests {


    /**
     * 创建流
     */
    @Test
    void createStream() {
        com.qinweizhao.eight.StreamMain.createStream();
    }


    /**
     * 遍历/匹配（foreach/find/match）
     * Optional类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象
     */
    @Test
    void foreachAndFindAndMatch() {
        com.qinweizhao.eight.StreamMain.foreachAndFindAndMatch();
    }

    /**
     * 筛选（filter）
     */
    @Test
    void filter() {
        com.qinweizhao.eight.StreamMain.filter();
    }


    /**
     * 聚合（max/min/count)
     */
    @Test
    void maxAndMinAndCount() {
        com.qinweizhao.eight.StreamMain.maxAndMinAndCount();
    }

    /**
     * 映射(map/flatMap)
     * map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
     */
    @Test
    void mapAndFlatMap() {

        com.qinweizhao.eight.StreamMain.mapAndFlatMap();
    }

    /**
     * 归约(reduce)
     * 归约，也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作。
     */
    @Test
    void reduce() {
        com.qinweizhao.eight.StreamMain.reduce();
    }


    /**
     * 归集(toList/toSet/toMap)
     * 因为流不存储数据，那么在流中的数据完成处理后，需要将流中的数据重新归集到新的集合里。toList、toSet和toMap比较常用，另外还有toCollection、toConcurrentMap等复杂一些的用法。
     */
    @Test
    void toListAndToSetAndToMap() {
        com.qinweizhao.eight.StreamMain.toListAndToSetAndToMap();
    }


    /**
     * 统计(count/averaging)
     * Collectors提供了一系列用于数据统计的静态方法：
     * 计数：count
     * 平均值：averagingInt、averagingLong、averagingDouble
     * 最值：maxBy、minBy
     * 求和：summingInt、summingLong、summingDouble
     * 统计以上所有：summarizingInt、summarizingLong、summarizingDouble
     */
    @Test
    void countAndAveraging() {
        com.qinweizhao.eight.StreamMain.countAndAveraging();
    }

    /**
     * 分组(partitioningBy/groupingBy)
     * 分区：将stream按条件分为两个Map。
     * 分组：将集合分为多个Map，比如员工按性别分组。有单级分组和多级分组。
     */
    @Test
    void group() {
        com.qinweizhao.eight.StreamMain.group();
    }

    /**
     * 接合(joining)
     * joining可以将stream中的元素用特定的连接符（没有的话，则直接连接）连接成一个字符串。
     */
    @Test
    void joining() {
        com.qinweizhao.eight.StreamMain.joining();
    }

    /**
     * 排序(sorted)
     * sorted()：自然排序，流中元素需实现Comparable接口
     * sorted(Comparator com)：Comparator排序器自定义排序
     */
    @Test
    void sorted() {
        com.qinweizhao.eight.StreamMain.sorted();
    }


    /**
     * 提取/组合
     * 流也可以进行合并、去重、限制、跳过等操作。
     */
    @Test
    void distinctAndSkipAndLimit() {
        com.qinweizhao.eight.StreamMain.distinctAndSkipAndLimit();
    }
}
