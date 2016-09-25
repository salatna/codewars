package ru.antalas.codewars;

import java.util.LinkedList;

import static java.lang.Math.sqrt;

public class GapInPrimes {
    public static long[] gap(int gapSize, long left, long right) {
        // g: gap length >= 2
        // m: left limit, >=2, inclusive
        // n: right limit, >= m, inclusive

        LinkedList<Long> pair = new LinkedList<>();

        for (long i = left; i <= right; i++) {
            if (isPrime(i)) {
                pair.add(i);

                if (pair.size() == 2) {
                    if (pair.getLast() - pair.getFirst() == gapSize) {
                        return new long[]{pair.getFirst(), pair.getLast()};
                    } else {
                        pair.clear();
                        pair.add(i);
                    }
                }
            }
        }

        return null;
    }

    private static boolean isPrime(long number) {
        for (long i = 2; i <= (long)sqrt(number); i ++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
