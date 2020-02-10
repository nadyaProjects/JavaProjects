import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Person {


    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }

    List<Person> persons = Arrays.asList(
            new Person("Alex", 18),
            new Person("Pesho", 20),
            new Person("Goho", 19)
    );
    List<Person> filtered = persons
            .stream()
            .filter(p -> p.name.startsWith("A"))
            .collect(Collectors.toList());
    //System.out.println(filtered);
    Map<Integer, List<Person>> personsByAge = persons
            .stream()
            .collect(Collectors.groupingBy(p -> p.age));

        //personsByAge.forEach((age,p)->System.out.format("age %s: %s\n",age,p));

}


