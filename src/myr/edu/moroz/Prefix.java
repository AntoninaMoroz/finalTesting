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

        if (array.length == 0) return "";

        String prefix = array[0];
        for (int i = 1; i < array.length; i++) {
            while (array[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.equals("")) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] array = {"abc", "abcd", "abfce", "abcac"};

        System.out.println(prefix(array));  // ab

        String[] array2 = {"abc", "abcd", "abce", "abcac"};

        System.out.println(prefix(array2)); // abc
    }
}

/*result:
ab
abc
 */
