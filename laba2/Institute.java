import java.util.ArrayList;
import java.util.List;

public class Institute{
    private String name;

    private List<Direction> directions;

    public Institute(){
        directions = new ArrayList<Direction>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addDirection(Direction d){
        directions.add(d);
    }
}
