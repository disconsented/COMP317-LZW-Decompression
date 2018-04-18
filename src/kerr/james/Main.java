package kerr.james;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static final String RESET = "\0";
    //Use the index as our lookup value
    public static List<String> dictionary  = new ArrayList<String>();
    public static final String dictLocation = "dict.txt";
    public static final String test = "TOBEORNOTTOBEORTOBEEORNOT";

    public static void main(String[] args) {
        try  {
            Stream<String> stream = Files.lines(Paths.get(dictLocation));
            stream.forEach(dictionary::add);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //So we know where to reset back to
        int initalDictSize = dictionary.size();
        String output = "";

        try  {
            try(BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
                String last = "";
                for(String line; (line = br.readLine()) != null; ) {
                    if(line.equals(RESET)){
                        dictionary = dictionary.subList(0, initalDictSize);
                    } else {
                        try {
                            int phraseNumber = Integer.parseInt(line);
                            String phrase = dictionary.get(phraseNumber);
                            if(phrase == null){
                                System.out.println("Unknown " + phraseNumber);
                            }

                            String possibleNew = last+phrase;

                            if(!dictionary.contains(possibleNew)){
                                dictionary.add(possibleNew);
//                                System.out.println(possibleNew);
                            }

                            output += phrase;
                            last = phrase;
                            System.out.println(last);

                        } catch (NumberFormatException e){
                            //Do nothing
                            e.printStackTrace();
                        }
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(output.toCharArray()));
        System.out.println(Arrays.toString(test.toCharArray()));
        System.out.println(output.equals(test));
        System.out.println("done");
    }
}


