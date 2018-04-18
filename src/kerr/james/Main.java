package kerr.james;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    public static final char RESET = '\0';
    //Use the index as our lookup value
    public static ArrayList<String> dictionary  = new ArrayList<String>();
    public static final String dictLocation = "dict.txt";

    public static void main(String[] args) {
        try  {
            Stream<String> stream = Files.lines(Paths.get(dictLocation));
            stream.forEach(dictionary::add);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }
}
