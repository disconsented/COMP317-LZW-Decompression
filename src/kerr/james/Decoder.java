package kerr.james;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Decoder {
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
                String last = "";
                for(String line; (line = br.readLine()) != null; ) {
                    //When we get the reset symbol, remove all new entries
                    if(line.equals(RESET)){
                        dictionary = dictionary.subList(0, initialDictSize);
                    } else {
                        try {
                            //New line == new phrase
                            int phraseNumber = Integer.parseInt(line);
                            String phrase = dictionary.get(phraseNumber);

                            //Just in case catch should never be true
                            if(phrase == null){
                                System.out.println("Unknown " + phraseNumber);
                            }

                            //Adding new phrases if they don't exist
                            String possibleNew = last+phrase;
                            if(!dictionary.contains(possibleNew)){
                                dictionary.add(possibleNew);
                            }
                            last = phrase;
                            //Printing the phrases as we get them, not sure why its on a new line
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

    }
}


