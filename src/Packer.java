import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Packer {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            //Get the max length
            int max = Integer.parseInt(br.readLine());
            for (int i = 0; i < max; i++) {
                System.out.print(0);
            }
            //Use the first 1 as a delimiter for maximum length
            System.out.print(1);
            //Unpacker has been told the length to expect, start outputting
            for (String line; (line = br.readLine()) != null; ) {
                int toOutput = Integer.parseInt(line);
                for (int i = 0; i < max - BigInteger.valueOf(toOutput).bitLength(); i++) {
                    System.out.print(0);
                }
                System.out.print(Integer.toBinaryString(toOutput));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
