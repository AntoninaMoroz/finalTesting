package myr.edu.moroz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Antonina Moroz
 * @version 1.0.0
 * @project finalTesting
 * @class Harry
 * @since 19.04.2021 - 18.10
 **/
public class Harry {


    public static void main(String[] args) throws IOException {

        // download a text version of a novel about Harry Potter to string

        String text = new String(Files.readAllBytes(Paths.get("/Users/User/Desktop/Java/harry.txt")));

        String[] words = text.split(" ");

        String stringOfDistincts = "";

        for (int i = 0; i < words.length; i++) {

            if (!stringOfDistincts.contains(words[i])) {
                stringOfDistincts += words[i] + " ";
            }
        }
        String[] distincts = stringOfDistincts.split(" ");

        int properNames = 0;

        for (int i = 0; i < distincts.length; i++) {
            if ((distincts[i].charAt(0) > 'A') && (distincts[i].charAt(0) < 'Z')) {
                distincts[i] = "\n" + distincts[i];
            }
            System.out.println(properNames);


            // clean from a punctuation signs (Use RegEx)

            text = text.toLowerCase().replaceAll("[^A-Za-z ]", "");

            // split the novel into an array of words

            String[] array = text.split(" +");

            // array collect to list

            List<String> list = Arrays.stream(array).collect(Collectors.toList());

            // For each distinct word in the text calculate the number of occurrence.

            Map<String, Integer> map = new HashMap<>();

            Integer value = 0; // frequency of occurrence of a word in the text

            for (int i = 0; i < array.length; i++) {

                if (!map.containsKey(array[i])) {

                    map.put(array[i], 1);

                } else {

                    value = map.get(array[i]);

                    map.put(array[i], value + 1);
                }
            }

            Map<String, Integer> sorted = new LinkedHashMap<>();

            // Sort in the DESC mode by the number of occurrence

            map.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEachOrdered(entry -> sorted.put(entry.getKey(), entry.getValue()));

            // Find  the first 20 pairs

            sorted.entrySet().stream().limit(20).forEach(System.out::println);
        }
    }

}