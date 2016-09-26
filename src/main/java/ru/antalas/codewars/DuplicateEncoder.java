package ru.antalas.codewars;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.Character.toLowerCase;

public class DuplicateEncoder {
    static String encode(String word) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> frequencies = charFrequenciesOf(word);
        for (int i = 0; i < word.length(); i++) {
            char item = toLowerCase(word.charAt(i));
            sb.append(frequencies.get(item) == 1 ? '(' : ')');
        }
        return sb.toString();
    }

    private static Map<Character, Integer> charFrequenciesOf(String word) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char item = toLowerCase(word.charAt(i));
            Integer frequency = frequencies.get(item);
            if (frequency == null) {
                frequencies.put(item, 1);
            } else {
                frequencies.put(item, frequency + 1);
            }
        }

        return frequencies;
    }
}

