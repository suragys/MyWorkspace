package leetCodeUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by surag on 10/19/2016.
 */
public class UglyNumber {

    public static void main(String[] args) {
        /*
        -2147483648
1
2
3
4
         */
        isUgly(-2147483648);
        isUgly(1);

    }

    public static boolean isUgly(int num) {

        long n = Math.abs((long) num);
        System.out.println(n);
        System.out.println(Math.abs((long) num));
        System.out.println(Math.abs(-100));


        boolean isUgly;
        switch (num) {
            case 1:
            case 2:
            case 3:
            case 5:
                isUgly = true;
                break;

            default:
                isUgly = checkIfUgly(num);
                break;
        }
        return isUgly;
    }

    public static boolean checkIfUgly(int num) {
        List<Integer> primes = new ArrayList<Integer>();
        int n = num;
        for (int i = 7; i <= (int) Math.sqrt(num); i = i + 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                primes.add(i);
                n = n / i;
            }
        }
        if (n > 2) {
//            printf ("%d ", n);
            primes.add(n);
        }


        if (num % 2 == 0) {
            if (num % 3 == 0 && num % 5 == 0) {
                for (int i : primes) {
                    if (num % i == 0) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        }
        return false;


    }
}
