package leetCodeUtility;

/**
 * Created by surag on 10/18/2016.
 */
public class BinarySequence {

    public static void main(String[] args) {
        int num = 3;
        int max = (int) (Math.pow(2, 3));
        for (int i = 0; i < max; i++) {
            int temp = i;
            for (int j = 0; j < num; j++) {
                int x = temp & 1;
                temp = temp >> 1;
                System.out.print(x + "\t");
            }
            System.out.println();
        }

    }
}
