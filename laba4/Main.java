import java.util.ArrayList;
import com.google.gson.Gson;

import java.sql.*;

public class Main {

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

    public static String URL = "jdbc:postgresql://localhost:5432/json";

    public static String user = "postgres";

    public static String password = "*****";

    public static Connection conn;

    public static void main(String[] args) throws SQLException {


        conn = DriverManager.getConnection(URL, user, password);
        Gson g = new Gson();

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < 50000; i++){
            University u = new University(genInt(1000), genName(genInt(10)), genInt(1000), genDirector());
            list.add(g.toJson(u));
        }

        System.out.println("*************************************************************************************");
        System.out.println("Insert:");
        System.out.println("json: " + insert(list, "test1") + " ms");
        System.out.println("jsonb: " + insert(list, "test2") + " ms");


        System.out.println("*************************************************************************************");
        System.out.println("Selection (easy mode):");
        System.out.println("json: " + easySelect("test1") + " ms");
        System.out.println("jsonb: " + easySelect("test2") + " ms");


        System.out.println("*************************************************************************************");
        System.out.println("Selection (hard mode):");
        System.out.println("json: " + hardSelect("test1") + " ms");
        System.out.println("jsonb: " + hardSelect("test2") + " ms");

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

    public static long easySelect(String table) throws SQLException {
        long start = System.currentTimeMillis();

        String q = "SELECT json_default ->> 'name' as name FROM " + table +
                " WHERE CAST (json_default ->> 'cntOfInstitutes' AS INTEGER) > 990;";

        PreparedStatement preparedStatement = conn.prepareStatement(q);
        preparedStatement.execute();

        return System.currentTimeMillis() - start;
    }

    public static long hardSelect(String table) throws SQLException {
        long start = System.currentTimeMillis();

        String q = "SELECT json_default ->> 'name' as name, json_default ->> 'score' as score FROM " + table +
                " WHERE (CAST(json_default -> 'director' ->> 'experience' AS INTEGER) < CAST(json_default -> 'director' -> 'deputer' ->> 'experience' AS INTEGER)) AND" +
                "(CAST (json_default -> 'director' -> 'deputer' ->> 'cntOfSubordinates' AS INTEGER) > 50);";

        PreparedStatement preparedStatement = conn.prepareStatement(q);
        preparedStatement.execute();

        return System.currentTimeMillis() - start;
    }

    public static long insert(ArrayList<String> list, String table) throws SQLException {
        long start = System.currentTimeMillis();

        String query = "INSERT INTO " + table + " (json_default) " + "VALUES (?::json);";

        for (String temp: list) {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, temp);
            preparedStatement.executeUpdate();
        }

        return System.currentTimeMillis() - start;
    }




}
