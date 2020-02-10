package Library;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Library {

    public String getName() {
        return name;
    }

    String name;
    Map<String,String> listOfBooks;



    static void addBook(String title, String autor){

    }

    static void removeBook(String title, String autor){

    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", listOfBooks=" + listOfBooks +
                '}';
    }
}
