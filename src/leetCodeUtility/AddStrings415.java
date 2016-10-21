package leetCodeUtility;

/**
 * Created by surag on 10/20/2016.
 * <p>
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings415 {

    public static void main(String[] args) {
        addStrings("0", "9");
        addStrings("98", "9");

//        addStrings("999999999999999999999999999999999999999999999999999999999999999999999999","999999999999999999999999999999999999999999999999999999999999999999999999");
    }

    public static String addStrings(String num1, String num2) {
        // int sum = 0;
        int carry = 0;

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder tot = new StringBuilder();

        while (i >= 0 && j >= 0) {

//                Integer.parseInt(num1.)
            int a = num1.charAt(i) - '0';
            int b = num2.charAt(j) - '0';
            System.out.println(a + " " + b);
            a += b + carry;
            if (a > 9) {
                carry = 1;
                a = a % 10;
            } else {
                carry = 0;
            }
            tot.insert(0, a);
            i--;
            j--;
        }
        while (i >= 0) {
            int a = num1.charAt(i) - '0';

            a += carry;
            if (a > 9) {
                carry = 1;
                a = a % 10;
            } else {
                carry = 0;
            }
            tot.insert(0, a);
            i--;
        }

        while (j >= 0) {
            int a = num2.charAt(j) - '0';

            a += carry;
            if (a > 9) {
                carry = 1;
                a = a % 10;
            } else {
                carry = 0;
            }
            tot.insert(0, a);
            j--;
        }

        if (carry != 0) {
            tot.insert(0, carry);
        }
        System.out.println(tot.toString());
        return tot.toString();
    }
}
