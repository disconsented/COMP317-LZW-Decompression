import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Unpacker {
    public static void main(String[] args) {
        try {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                //Count the amount of 0's before the first one the figure out the max length
                int max = 0;
                for (int segment; (segment = br.read()) != -1; ) {
                    if (segment == 48) {
                        max++;
                    } else {
                        break;
                    }
                }
                //String builder for keeping track of the incoming without having to buffer
                StringBuilder builder = new StringBuilder();
                for (int segment; (segment = br.read()) != -1; ) {
                    //UTF8 so -48
                    builder.append(segment - 48);
                    if (builder.length() == max) {
                        //Max length convert it back into the int
                        System.out.println(Integer.parseInt(builder.toString(), 2));
                        builder = new StringBuilder();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
