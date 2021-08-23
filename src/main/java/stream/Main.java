package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author qinweizhao
 */
@SuppressWarnings("all")
public class Main {


    public static void main(String[] args) {

        // createStream
        createStream();

    }

    /**
     * 创建流
     */
    public static void createStream() {

        // 1、java.util.Collection.stream()
        System.out.println("1、开始");
        List<String> list = Arrays.asList("a", "b", "c");
        // 创建一个顺序流
        Stream<String> stream1 = list.stream();
        stream1.forEach(System.out::println);
        // 创建一个并行流
        Stream<String> parallelStream1 = list.parallelStream();
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
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5, 6);
        stream3.forEach(System.out::println);
        // iterate()
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 3).limit(4);
        stream4.forEach(System.out::println);
        // generate()
        Stream<Double> stream5 = Stream.generate(Math::random).limit(3);
        stream5.forEach(System.out::println);
        System.out.println("3、结束");

    }

}
