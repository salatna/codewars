package ru.antalas.codewars;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Finance {
    public static BigInteger finance(int n) {
        BigDecimal sum = new BigDecimal(sumOfFirst(n));

        for (int i = 1; i <= n; i++) {
            sum = sum.add(new BigDecimal(sumOfFirst(i))).add(new BigDecimal((2 * i - 1) * (n + 1 - i)));
        }

        return sum.toBigIntegerExact();
    }

    private static long sumOfFirst(int n) {
        return n * (n + 1) / 2;
    }
}
