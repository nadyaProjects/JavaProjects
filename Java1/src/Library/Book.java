package Library;

import java.util.LinkedList;

public class Book {

    public String getTitle() {
        return title;
    }

    String title;

    public String getAutor() {
        return autor;
    }

    String autor;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
