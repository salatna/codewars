package ru.antalas.codewars;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;

public class GapInPrimes {
    public static long[] gap(int gapSize, long left, long right) {
        // g: gap length >= 2
        // m: left limit, >=2, inclusive
        // n: right limit, >= m, inclusive

        LinkedList<Long> pair = new LinkedList<>();
        List<Long> primes = populateTo(left);

        for (long i = left; i <= right; i++) {
            if (isPrime(primes, i)) {
                primes.add(i);
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
        List<Long> primes = new LinkedList<>();

        long i = 2;
        while (i < number) {
            if (isPrime(primes, i)) {
                primes.add(i);
            }
            i++;
        }
        return primes;
    }

    private static boolean isPrime(List<Long> primes, long number) {
        for (Long prime : primes) {
            if (number % prime == 0) {
                return false;
            }
            if (prime > (long)sqrt(number)){
                return true;
            }
        }
        return true;
    }
}
