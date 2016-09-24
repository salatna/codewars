package ru.antalas.codewars;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;

public class GapInPrimes {
    private static long FIRST_NON_UNIT_PRIME = 2;

    public static long[] gap(int gapSize, long left, long right) {
        // g: gap length >= 2
        // m: left limit, >=2, inclusive
        // n: right limit, >= m, inclusive

        LinkedList<Long> pair = new LinkedList<>();
        List<Long> factors = populateTo(left);

        for (long i = left; i <= right; i++) {
            if (isPrime(factors, i)) {
                factors.add(i);
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

    private static List<Long> populateTo(long number) {
        List<Long> factors = new LinkedList<>();
        factors.add(FIRST_NON_UNIT_PRIME);

        long i = FIRST_NON_UNIT_PRIME + 1;
        while (i < number) {
            if (isPrime(factors, i)) {
                factors.add(i);
            }
            i++;
        }
        return factors;
    }

    private static boolean isPrime(List<Long> factors, long number) {
        if (number % 2 == 0) return false;

        for (Long factor : factors) {
            if (factor > (long)sqrt(number)){
                return true;
            }
            if (number % factor == 0) {
                return false;
            }
        }
        return true;
    }
}
