package myr.edu.moroz;

import java.util.Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Antonina Moroz
 * @version 1.0.0
 * @project finalTesting
 * @class Duplicates
 * @since 19.04.2021 - 19.22
 **/
    public class Duplicates {

        public  static  boolean hasDuplicates(int[] array){
                List<Integer> list = Arrays.stream(array)
                        .boxed()
                        .distinct()
                        .collect(Collectors.toList());
                return  list.size()!= array.length;
            }

        public static void main(String[] args) {
            int[] array = {1,5,3,6,2,9,33,21};
            System.out.println(hasDuplicates(array));  // false
            array[5] = 1;
            System.out.println(hasDuplicates(array)); // true
        }
    }

/* result:
false
true
 */

