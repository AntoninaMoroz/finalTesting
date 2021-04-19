package myr.edu.moroz;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

        //  Find all the proper names

        String[] words = text.split(" ");

        String stringOfDistincts = "";

        for (int i = 0; i < words.length; i++) {

            if (!stringOfDistincts.contains(words[i])) {
                stringOfDistincts += words[i] + " ";
            }
        }
        String[] properNames = stringOfDistincts.split(" ");


        for (int i = 0; i < properNames.length; i++) {
            if ((properNames[i].charAt(0) > 'A') && (properNames[i].charAt(0) < 'Z')) {
                properNames[i] += properNames[i];
            }
        }

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

        //Create a fine header for the file

        String sorted20 = "----------------------------" + "\n"
                + " HEAD for the task 1" + "\n"
                + " First 20 pairs and names" + "\n"
                + "-----------------------------------" + "\n";
        int counter = 0;

        //First 20 pairs and names write into to a file test.txt

        for (Map.Entry<String,Integer> entry : sorted.entrySet()){
            counter++;
            sorted20 += entry.getKey() + " " + entry.getValue() + "\n";
            if (counter == 20) break;
        }
        String sortedToString = sorted.toString();
        Files.write(Paths.get("/Users/User/Desktop/Java/exam.txt"),
                sorted20.getBytes(StandardCharsets.UTF_8));

        }

}
/* result:
----------------------------
 HEAD for the task 1
 First 20 pairs and names
-----------------------------------

the=3628
and=1919
to=1856
a=1688
he=1528
of=1259
harry=1214
was=1186
it=1026
in=964
his=937
you=863
said=794
had=702
i=652
on=636
at=625
that=601
they=597
as=526
 */
