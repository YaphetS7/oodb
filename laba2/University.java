import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class University implements Comparable<University>{

    private String name;

    public List<Institute> institutes;

    public University(String name){
        this.name = name;
    }



    public University(){
        institutes = new ArrayList<Institute>();
    }

    public String toJson() {
        Gson json = new Gson();
        return json.toJson(this);
    }

    public static University fromJson(String str) {
        Gson json = new Gson();
        return json.fromJson(str, University.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addInstitute(Institute i){
        institutes.add(i);
    }



    public int compareTo(University o) {
        return this.name.compareTo(o.name);
    }
}