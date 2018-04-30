import sun.security.ssl.Debug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Unpacker {
    public static void main(String[] args){
        try  {
            try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                //Read in the first 10 characters since that should always be the right length
                //Remember to deal with UTF8 character codes (-48)
//                System.out.println(maxStr);
                int max = 0;

                for (int segment; (segment = br.read()) != -1; ) {
                    if (segment == 48){
                        max++;
                    } else {
                        break;
                    }
                }

//                ArrayList<Integer> ints = new ArrayList<>();
                StringBuilder builder = new StringBuilder();


                for (int segment; (segment = br.read()) != -1; ) {
                    //UTF8 so -48
                    builder.append(segment-48);
                    if (builder.length() == max){
                        System.out.println(Integer.parseInt(builder.toString(), 2));
                        builder = new StringBuilder();
                    }
                }

//                int max = Integer.parseInt(br.readLine());
//                max = bitExtracted(max, BigInteger.valueOf(max).bitLength()-2, 1);
//                System.out.println(max);
//                int bitCount = 0;
//                int current = 0;
//                //Keep note of bits read, pack them in and then read them out
//                for (String segment; (segment = br.readLine()) != null && !segment.equals(""); ) {
//                    int number = Integer.parseInt(segment)-48;
////                    System.out.println(number);
//                    if(max > bitCount){
//                        int bits = BigInteger.valueOf(number).bitLength();
//                        bitCount += bits;
////                        System.out.println(bits+":"+bitCount);
//                        current <<= bits;
//                        current = current | number;
////                        System.out.println(current);
//                    } else {
//                        System.out.println(current);
//                        current = 0;
//                        bitCount = 0;
//                    }
//                }
            }
            } catch (Exception e){
                e.printStackTrace();
            }

//        int[] testEncode = {7,8,9,10,11,12,13};
//
//        int max = 3;
//        //read both values out as binary
//        int a = 4;
//        System.out.println(a+":"+Integer.toBinaryString(a));
//        int b = 7;
//        System.out.println(b+":"+Integer.toBinaryString(b));
//        //Shift across the maximum length (based on the largest number from the trie)
//        System.out.println(Integer.toBinaryString(a <<= max));
//        //Add in the new number in the space we left
//        System.out.println(Integer.toBinaryString(a = a | b));
//        System.out.println(bitExtracted(a, max, 1));
//        System.out.println(bitExtracted(a, max, 4));
//        System.out.println(bitExtracted(a, 4, 2));
//        System.out.println();
//        System.out.println(Integer.toBinaryString(6 << 5));
//        System.out.println(Integer.toBinaryString((1 << 10) | 7));
//        int temp = (1 << 10) | 7;
//        int t2 = 1145;
//        System.out.println(bitExtracted(t2, 9, 1));
//        for (int i = 0; i < 12; i++) {
//
//        }



//        int largeEncoded = 0;
//        for (int i : testEncode) {
//            largeEncoded <<= max;
//            largeEncoded = largeEncoded | i;
//            System.out.println(Integer.toBinaryString(i)+ ":"+i);
//        }
//        System.out.println();
//        System.out.println(Integer.toBinaryString(largeEncoded));
//        for (int i = 0; i < BigInteger.valueOf(largeEncoded).bitLength(); i+=max) {
//            System.out.println(bitExtracted(a, max, i+1));
//        }





//        System.out.println(Integer.toBinaryString(a >> 3));
//        a = ~ a;
//        for (int i = 6; i > 0; i--) {
//            System.out.print(Integer.toBinaryString((a >> i) & 1));
//        }





//        System.out.println(Integer.toBinaryString(num));
//        System.out.println(Integer.toBinaryString(num <<= 3));
//        System.out.println(Integer.toBinaryString(num | 7));
//        System.out.println(Integer.toBinaryString(num & 6));
//        System.out.println(Integer.toBinaryString(num <<= 4));
//        System.out.println(Integer.toBinaryString(num >>= 4));
//        System.out.println(Integer.toBinaryString(num >>= 4));
//        System.out.println(num);

//        int s = 4;
//        String test = "THISISATEST";
//        for (byte b : test.getBytes()) {
//
//        }
//
//        int x = 1;
//        System.out.println(Integer.toBinaryString(x));
//        System.out.println(Integer.toBinaryString(8));
//        System.out.println(Integer.toBinaryString(x <<= 10));
//        System.out.println(Integer.toBinaryString(x << 4));


//        int w = ((0x003C & data[0]) >> 2) |
//                ((0x0600 & data[0]) >> 6) |
//                ((0x6000 & data[0]) >> 7);
//        System.out.println(Integer.toBinaryString(bitmask));
//        System.out.println(Integer.toBinaryString(val));
//        System.out.println(Integer.toBinaryString(val & bitmask));
//        System.out.println(Integer.toBinaryString(2 << 3 << 4));
//        System.out.println(val & bitmask);


//        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
//            int size = br.read();
//            for(int b; (b = br.read()) != -1; ) {
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    static int bitExtracted(int number, int length, int p)
    {
        return (((1 << length) - 1) & (number >> (p - 1)));
    }
}
