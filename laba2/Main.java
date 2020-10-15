import java.util.*;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {

        Gson gson = new Gson();

        ArrayList<University> unis = new ArrayList<University>();

        unis.add(new University("KFU"));
        unis.add(new University("ITMO"));
        unis.add(new University("URFU"));
        unis.add(new University("UDGU"));
        unis.add(new University("A"));
        unis.add(new University("Z"));
        
        String uStr = gson.toJson(unis);

        System.out.println(uStr);

        List<University> unis2 = Arrays.asList(gson.fromJson(uStr, University[].class));

        Collections.sort(unis2);


        for (University u: unis2) {
            System.out.println(u.getName());
        }

    }
}
