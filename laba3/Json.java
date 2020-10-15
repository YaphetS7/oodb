import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Json {

    public String readFile(String path) throws FileNotFoundException {
        File f = new File(path);
        Scanner myReader = new Scanner(f);
        StringBuilder ans = new StringBuilder();
        while (myReader.hasNextLine()) {
            ans.append(myReader.nextLine());
        }

        myReader.close();
        return ans.toString();
    }


    public void WriteToFile(String str, String path) throws IOException {
        FileWriter myWriter = new FileWriter(path);

        myWriter.write(str);

        myWriter.close();

    }
}
