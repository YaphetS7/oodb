import java.util.*;

import com.thoughtworks.xstream.XStream;


public class Main {
    public static void main(String[] args) {
        XStream xStream = new XStream();

        ArrayList<University> list = new ArrayList<University>();

        for (int i = 0; i < 10; i++){
            University u = new University(genInt(1000), genName(genInt(10)), genInt(1000), genDirector());
            list.add(u);
        }

        String uStr = xStream.toXML(list);

        System.out.println(uStr);

        List<University> unis2 = (List<University>)xStream.fromXML(uStr);

        Collections.sort(unis2);


        for (University u: unis2) {
            System.out.println(u.getName());
        }
    }

    public static String en = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static int genInt(int r){
        return (int) (Math.random() * r);
    }


    public static String genName(int length){

        StringBuilder name = new StringBuilder();

        for (int i =0; i < length; i++){
            int index = genInt(en.length());
            name.append(en.charAt(index));
        }

        return name.toString();
    }


    public static Director genDirector(){
        Deputy d = genDeputy();

        Director director = new Director(genName(10), genInt(50), d);
        return director;
    }

    public static Deputy genDeputy(){
        Deputy d = new Deputy(genInt(1000), genName(10), genInt(50));
        return d;
    }

}
