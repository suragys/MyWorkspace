package leetCodeUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by surag on 10/19/2016.
 */
public class BinaryWatch {
    public static void main(String[] args) {
        List<String> times = readBinaryWatch(1);
        for (String x : times) {
            System.out.println(x);
        }
    }

    public static List<String> readBinaryWatch(int num) {
        // Total number of LEDs are 10 = 4(hours) 6(minutes)
        // hours: 0 -12 : 0000 - 1100 ; 1110 1101 are not valid
        // minutes : 00 - 59 ; max=111111=63 111110=62 111101=61 111100=60 are invalid

        // if num < 5 then we can
        List<Integer> h;
        List<Integer> m;
        List<String> times = new ArrayList<>();
        for (int i = 0; i < (int) Math.pow(2, 10); i++) {
            int temp = i;
            h = new ArrayList<Integer>();
            m = new ArrayList<Integer>();
            if (numberOfOnes(i) == num) {
                System.out.print(Integer.toBinaryString(temp));
                for (int j = 0; j < 10; j++) {
                    int x = temp & 1;
//                        System.out.print(x);
                    temp = temp >> 1;
                    if (x == 1) {
                        if (j < 6) {
                            m.add(j);
                        } else {
                            h.add(j - 6);
                        }
                    }
                }
                times.add(computeTime(h, m));
                System.out.println();
            }
        }
        return times;
    }

    private static int numberOfOnes(int val) {
        int count = 0;
        // we are sure that number cannot be bigger than 10 bits
        for (int i = 0; i < 10; i++) {
            count += val & 1;
            val = val >> 1;
        }
        return count;
    }

    private static String computeTime(List<Integer> h, List<Integer> m) {
//            String time = "";
        int hour = 0;
        int min = 0;
        System.out.print("\t h = " + h.toString());
        System.out.print("\t m = " + m.toString());

        return convertToString(getDecimalVal(h), 1) + ":" +
                convertToString(getDecimalVal(m), 2);

    }

    private static int getDecimalVal(List<Integer> ls) {
        int val = 0;
        for (Integer i : ls) {
            val += (int) Math.pow(2, i);
        }
        return val;
    }

    private static String convertToString(int n, int length) {
        StringBuilder time = new StringBuilder();
        while (n > 0) {
            int val = n % 10;
            n = n / 10;
            time.insert(0, val);
        }
        if (time.length() < length) {
            int i = time.length();
            while (i < length) {
                time.insert(0, "0");
                i++;
            }
        }
        return time.toString();
    }

}
