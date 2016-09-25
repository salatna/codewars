package ru.antalas.codewars;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class PartList {
    public static String[][] partlist(String[] in) {
        String[][] result = new String[in.length - 1][2];

        List<String> items = Arrays.asList(in);
        for (int i = 0; i < in.length - 1; i++) {
            List<String> left = items.subList(0, i + 1);
            List<String> right = items.subList(i + 1, items.size());

            result[i][0] = left.stream().collect(joining(" "));
            result[i][1] = right.stream().collect(joining(" "));
        }

        return result;
    }
}
