import java.util.*;

import com.thoughtworks.xstream.XStream;

public class Main {
    public static void main(String[] args) {

        XStream xStream = new XStream();

        ArrayList<University> unis = new ArrayList<University>();

        unis.add(new University("KFU"));
        unis.add(new University("ITMO"));
        unis.add(new University("URFU"));
        unis.add(new University("UDGU"));
        unis.add(new University("A"));
        unis.add(new University("Z"));

        String uStr = xStream.toXML(unis);

        System.out.println(uStr);

        List<University> unis2 = (List<University>)xStream.fromXML(uStr);

        Collections.sort(unis2);


        for (University u: unis2) {
            System.out.println(u.getName());
        }

    }
}
