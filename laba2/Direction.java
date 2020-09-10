import java.util.ArrayList;
import java.util.List;

public class Direction{
    private String name;

    private List<Group> groups;

    public Direction(){
        groups = new ArrayList<Group>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGroup(Group g){
        groups.add(g);
    }
}