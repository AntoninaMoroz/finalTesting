package myr.edu.moroz;

/**
 * @author Antonina Moroz
 * @version 1.0.0
 * @project finalTesting
 * @class Prefix
 * @since 19.04.2021 - 19.24
 **/
public class Prefix {

    public static String prefix(String[] array) {
        // your code is here
        return "";
    }

    public static void main(String[] args) {
        String[] array = {"abc", "abcd", "abfce", "abcac"} ;

        System.out.println(prefix(array));  // ab

        String[] array2 = {"abc", "abcd", "abce", "abcac"} ;

        System.out.println(prefix(array2)); // abc
}
