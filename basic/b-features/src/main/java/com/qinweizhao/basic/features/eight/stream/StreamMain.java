package com.qinweizhao.basic.features.eight.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author qinweizhao
 */
public class StreamMain {

    private StreamMain() {
    }


    /**
     * 创建流
     */
    public static void createStream() {

        // 1、java.util.Collection.stream()
        System.out.println("1、开始");
        List<String> list = Arrays.asList("a", "b", "c");
        // 创建一个顺序流
        java.util.stream.Stream<String> stream1 = list.stream();
        stream1.forEach(System.out::println);
        // 创建一个并行流
        java.util.stream.Stream<String> parallelStream1 = list.parallelStream();
        parallelStream1.forEach(System.out::println);
        System.out.println("1、结束");

        // 2、java.util.Arrays.stream(T[] array)
        System.out.println("2、开始");
        int[] array = {1, 3, 5, 6, 8};
        IntStream stream2 = Arrays.stream(array);
        stream2.forEach(System.out::println);
        System.out.println("2、结束");

        // 3、of()、iterate()、generate()
        System.out.println("3、开始");
        // of()
        java.util.stream.Stream<Integer> stream3 = java.util.stream.Stream.of(1, 2, 3, 4, 5, 6);
        stream3.forEach(System.out::println);
        // iterate()
        java.util.stream.Stream<Integer> stream4 = java.util.stream.Stream.iterate(0, (x) -> x + 3).limit(4);
        stream4.forEach(System.out::println);
        // generate()
        java.util.stream.Stream<Double> stream5 = java.util.stream.Stream.generate(Math::random).limit(3);
        stream5.forEach(System.out::println);
        System.out.println("3、结束");

    }

    /**
     * 遍历/匹配（foreach/find/match）
     * Optional类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象
     */
    public static void foreachAndFindAndMatch() {
        List<Integer> list = Arrays.asList(1, 2, 3, 10, 5, 6, 7, 8);
        //遍历输出符合条件的元素
        list.stream().filter(item ->
                item > 4
        ).forEach(System.out::print);
        System.out.println();

        //匹配第一个
        Integer first = list.stream().filter(item -> item > 1).findFirst().orElse(null);
        System.out.println("first = " + first);

        //匹配任意（适用于并行流）
        Optional<Integer> any = list.parallelStream().filter(item -> item > 2).findAny();
        System.out.println("any = " + any.get());

        //是否包含符合特定条件的元素
        boolean b = list.stream().anyMatch(x -> x < 4);
        System.out.println("b = " + b);
    }

    /**
     * 筛选（filter）
     */
    public static void filter() {
        List<Integer> list = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        list.stream()
                .filter(item ->
                        item > 7)
                .forEach(System.out::println);

    }

    /**
     * 聚合（max/min/count)
     */
    public static void maxAndMinAndCount() {
        List<String> list = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        //max
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());

        //min
        Optional<String> min = list.stream().min(Comparator.comparing(String::length));
        System.out.println("最短的字符串：" + min.get());

        //count
        long count = list.stream().filter(item ->
                item.length() > 6
        ).count();
        System.out.println("list中大于6的元素个数：" + count);
    }

    /**
     * 映射(map/flatMap)
     * map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
     */
    public static void mapAndFlatMap() {

        //map

        // 英文字符串数组的元素全部改为大写。
        String[] strArr = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("每个元素大写：" + strList);

        // 整数集合每个元素+3。
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Integer> intListNew = intList.stream().map(item -> item + 3).collect(Collectors.toList());
        System.out.println("每个元素+3：" + intListNew);

        // flatMap

        // 将两个字符数组合并成一个新的字符数组。
        List<String> list = Arrays.asList("h,e,l,l,o", "w,o,r,l,d");
        List<String> listNew = list.stream().flatMap(item -> {
            String[] split = item.split(",");
            return Arrays.stream(split);
        }).collect(Collectors.toList());
        System.out.println("处理前的集合：" + list);
        System.out.println("处理后的集合：" + listNew);
    }

    /**
     * 归约(reduce)
     * 归约，也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作。
     */
    public static void reduce() {
        // 求Integer集合的元素之和、乘积和最大值。
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        //求和 1
        Optional<Integer> sum = list.stream().reduce(Integer::sum);
        //求和 2
        Integer sum1 = list.stream().reduce(0, Integer::sum);
        // 求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);
        // 求最大值 1
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);
        // 求最大值 2
        Integer max1 = list.stream().reduce(1, Integer::max);

        System.out.println("list求和：" + sum.get() + "," + sum1);
        System.out.println("list求积：" + product.get());
        System.out.println("list求和：" + max.get() + "," + max1);
    }

    /**
     * 归集(toList/toSet/toMap)
     * 因为流不存储数据，那么在流中的数据完成处理后，需要将流中的数据重新归集到新的集合里。toList、toSet和toMap比较常用，另外还有toCollection、toConcurrentMap等复杂一些的用法。
     */
    public static void toListAndToSetAndToMap() {
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> toList = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        Set<Integer> toSet = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());
        Map<Integer, Integer> toMap = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toMap(x -> x, x -> x - 1));
        System.out.println("toList:" + toList);
        System.out.println("toSet:" + toSet);
        System.out.println("toMap:" + toMap);
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
    public static void countAndAveraging() {
        List<Integer> list = Arrays.asList(11, 22, 33, 44, 55, 66);
        // 求平均值
        Double average = list.stream().collect(Collectors.averagingDouble(x -> x));
        // 求最大
        Optional<Integer> max = list.stream().max(Integer::compare);
        // 一次性统计所有信息
        DoubleSummaryStatistics collect = list.stream().collect(Collectors.summarizingDouble(x -> x));

        System.out.println("平均：" + average);
        System.out.println("最大：" + max);
        System.out.println("所有信息：" + collect);
    }

    /**
     * 分组(partitioningBy/groupingBy)
     * 分区：将stream按条件分为两个Map。
     * 分组：将集合分为多个Map，比如员工按性别分组。有单级分组和多级分组。
     */
    public static void group() {

        List<User> list = new ArrayList<>();
        list.add(new User("male", "New York"));
        list.add(new User("male", "Washington"));
        list.add(new User("female", "Washington"));
        list.add(new User("female", "New York"));
        list.add(new User("male", "New York"));
        list.add(new User("female", "New York"));
        // 按性别分组
        Map<String, List<User>> group = list.stream().collect(Collectors.groupingBy(User::getSex));
        // 先按性别分组，再按地区分组
        Map<String, Map<String, List<User>>> group2 = list.stream().collect(Collectors.groupingBy(User::getSex, Collectors.groupingBy(User::getArea)));

        System.out.println("按性别分组情况：" + group);
        System.out.println("按性别、地区分组情况：" + group2);
    }

    /**
     * 接合(joining)
     * joining可以将stream中的元素用特定的连接符（没有的话，则直接连接）连接成一个字符串。
     */
    public static void joining() {
        List<User> list = new ArrayList<>();
        list.add(new User("qin", "male", "New York"));
        list.add(new User("wei", "male", "Washington"));
        list.add(new User("zhao", "female", "Washington"));
        String names = list.stream().map(User::getUsername).collect(Collectors.joining(","));

        System.out.println("所有的姓名：" + names);
    }

    /**
     * 排序(sorted)
     * sorted()：自然排序，流中元素需实现Comparable接口
     * sorted(Comparator com)：Comparator排序器自定义排序
     */
    public static void sorted() {
        List<User> list = new ArrayList<>();
        list.add(new User(20, "qin", "male", "New York"));
        list.add(new User(21, "wei", "male", "Washington"));
        list.add(new User(22, "zhao", "female", "Washington"));
        // 按年龄升序排序（自然排序）
        java.util.stream.Stream<String> sorted = list.stream().sorted(Comparator.comparing(User::getAge)).map(User::getUsername);
        // 按年龄倒序排序
        List<User> sorted1 = list.stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList());

        System.out.println("按年龄升序排序：" + sorted);
        System.out.println("按年龄降序排序：" + sorted1);
    }

    /**
     * 提取/组合
     * 流也可以进行合并、去重、限制、跳过等操作。
     */
    public static void distinctAndSkipAndLimit() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"d", "e", "f", "g"};
        java.util.stream.Stream<String> stream1 = java.util.stream.Stream.of(arr1);
        java.util.stream.Stream<String> stream2 = java.util.stream.Stream.of(arr2);
        // concat:合并两个流 distinct：去重
        List<String> newList = java.util.stream.Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit：限制从流中获得前n个数据
        List<Integer> collect = java.util.stream.Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        // skip：跳过前n个数据
        List<Integer> collect2 = java.util.stream.Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());

        System.out.println("流合并：" + newList);
        System.out.println("limit：" + collect);
        System.out.println("skip：" + collect2);
    }

}




/*
 *  stream和parallelStream的简单区分：stream是顺序流，由主线程按顺序对流执行操作，而parallelStream是并行流，内部以多线程并行执行的方式对流进行操作，但前提是流中的数据处理没有顺序要求。
 *
 */