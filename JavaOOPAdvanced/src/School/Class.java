package School;

import java.util.ArrayList;
import java.util.List;

public class Class {

    String idClass;
    List<Teacher > teachers = new ArrayList<>();
//hashMap
    public void classId(String idClass) {
        this.idClass = idClass;
    }

    public Class() {

    }

    public void classGroup(String idClass, List<Teacher> teachers) {
        this.idClass = idClass;
        this.teachers = teachers;
    }

    public void add(Teacher e) {
        teachers.add(e);
    }


}
