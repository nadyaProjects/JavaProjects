import java.awt.datatransfer.StringSelection;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {


        List<String> myList = Arrays.asList("a1", "a2", "b1", "b2", "c1", "c2");

        myList.stream().filter(s -> s.startsWith("c"))
                .map(String :: toUpperCase)
                .sorted()
                .forEach(System.out :: println);

        Arrays.asList("a1","a2","a3").stream()
                .findFirst()
                .ifPresent(System.out::println);

        Stream.of("a1","a2","a3")
                .findFirst()
                .ifPresent(System.out::println);

        Arrays.stream(new int[] {1,2,3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);

        Stream.of("a1","a2","a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer :: parseInt)
                .max()
                .ifPresent(System.out::println);

        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));

    }
}