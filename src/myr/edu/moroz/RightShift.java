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
        // your code is here and nowhere more
        return array;
    }
    public static void main(String[] args) {
        int[] array = {10, 20, 30};
        System.out.println(Arrays.toString(rightShift(array, 1))); // [30, 10, 20]

        int[] array2 = {10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(rightShift(array2, 2))); // [40, 50, 10, 20, 30]

        System.out.println(Arrays.toString(rightShift(array2, 21))); // [50, 10, 20, 30, 40]
}
