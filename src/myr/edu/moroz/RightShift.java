package myr.edu.moroz;

import java.util.Arrays;

/**
 * @author Antonina Moroz
 * @version 1.0.0
 * @project finalTesting
 * @class RightShift
 * @since 19.04.2021 - 19.20
 **/
public class RightShift {
    public static int[] rightShift(int[] array, int step){

        for (int iterations = 0; iterations < step; iterations++) {
            int temp = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30};
        System.out.println(Arrays.toString(rightShift(array, 1))); // [30, 10, 20]

        int[] array2 = {10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(rightShift(array2, 2))); // [40, 50, 10, 20, 30]

        int[] array3 = {10, 20, 30, 40, 50};

        System.out.println(Arrays.toString(rightShift(array3, 21))); // [50, 10, 20, 30, 40]
    }
}
/* result:
[30, 10, 20]
[40, 50, 10, 20, 30]
[50, 10, 20, 30, 40]
 */
