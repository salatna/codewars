package ru.antalas.codewars;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.sqrt;

public class PrimeConsec {

    public static int consecKprimes(int k, long[] arr) {
        List<Integer> ordersOfK = Arrays.stream(arr).
                mapToObj((number) -> IntegerFactorization.factorize(number).stream().mapToInt(f -> f.multiple).sum()).
                collect(Collectors.toList());

        int result = 0;
        for (int i = 0; i < ordersOfK.size() - 1; i++) {
            if (ordersOfK.get(i) == k && ordersOfK.get(i).equals(ordersOfK.get(i + 1))) {
                result += 1;
            }
        }

        return result;
    }

    static class IntegerFactorization {
        public static List<Factor> factorize(long number) {
            List<Factor> factors = new LinkedList<>();

            long nextPrime, current = number;
            while ((nextPrime = firstPrimeOf(current)) != current) {
                int multiple = 0;
                while (current % nextPrime == 0) {
                    current /= nextPrime;
                    multiple++;
                }

                factors.add(new Factor(nextPrime, multiple));
            }

            if (nextPrime != 1) {
                factors.add(new Factor(nextPrime, 1));
            }

            return factors;
        }

        private static long firstPrimeOf(long number) {
            long i = 2;
            while (i <= (long) Math.sqrt(number)) {
                if (number % i == 0 && isPrime(i)) {
                    return i;
                }
                i++;
            }
            return number;
        }

        private static boolean isPrime(long number) {
            for (long i = 2; i <= (long) sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }

        private static class Factor {
            long factor;
            int multiple;

            Factor(long factor, int multiple) {
                this.factor = factor;
                this.multiple = multiple;
            }
        }
    }
}