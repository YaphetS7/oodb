import java.util.ArrayList;
import java.util.List;

public class Group{
    private String name;

    private List<Student> students;

    public Group(){
        students = new ArrayList<Student>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(Student s){
        students.add(s);
    }
}