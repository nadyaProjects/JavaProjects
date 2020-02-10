package School;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

    List<Discipline> disciplines = new ArrayList<>();


    public Teacher() {

    }
    public void  teacher(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public void add(Discipline e) {
        disciplines.add(e);
    }

}
