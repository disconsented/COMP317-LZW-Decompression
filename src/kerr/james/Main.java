import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    private static final String RESET = "\0";
    //Use the index as our lookup value
    private static List<String> dictionary  = new ArrayList<>();

    public static void main(String[] args) {
        //Load in our dict
        try  {
            Stream<String> stream = Files.lines(Paths.get(args[0]));
            stream.forEach(dictionary::add);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //So we know where to reset back to
        int initialDictSize = dictionary.size();

        try  {
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                //Keep reference of the last phrase for building a new one
                String entry;
                String ch;
                int prevcode, currcode;
                prevcode = Integer.parseInt(br.readLine());
                System.out.println(dictionary.get(prevcode));
                for(String line; (line = br.readLine()) != null; ) {
                    //When we get the reset symbol, remove all new entries
                    if(line.equals(RESET)){
                        dictionary = dictionary.subList(0, initialDictSize);
                    } else {
                        try {
                            //New line == new phrase
                            currcode = Integer.parseInt(line);
                            entry = dictionary.get(currcode);
                            System.out.println(entry);
                            ch = entry.substring(0,1);
                            String toAdd = dictionary.get(prevcode) + ch;
                            System.out.println(":"+toAdd);
                            dictionary.add(toAdd);
                            prevcode = currcode;
                        } catch (NumberFormatException e){
                            //Do nothing
                            e.printStackTrace();
                        }
                    }
                }
//                System.out.println(output);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

