package ru.antalas.codewars;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class PartList {
    public static String[][] partlist(String[] in) {
        List<Pair> result = new ArrayList<>();

        BigInteger arrangement = ZERO;
        while (arrangement.bitLength() <= in.length) {
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();
            for (int i = 0; i < in.length; i++) {
                if (arrangement.testBit(i)) {
                    left.append(in[i]).append(" ");
                } else {
                    right.append(in[i]).append(" ");
                }
            }
            cleanup(left);
            cleanup(right);

            //exclude all-0 and all-1 arrangements
            if (left.length() > 0 && right.length() > 0) {
                result.add(new Pair(left.toString(), right.toString()));
            }

            arrangement = arrangement.add(ONE);
        }

        return format(result);
    }

    private static void cleanup(StringBuilder builder) {
        if (builder.length() > 0 && builder.charAt(builder.length() - 1) == ' ') {
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    private static String[][] format(List<Pair> result) {
        String[][] out = new String[result.size()][2];
        for (int i = 0; i < out.length; i++) {
            out[i][0] = result.get(i).left;
            out[i][1] = result.get(i).right;
        }
        return out;
    }

    private static class Pair {
        private String left;
        private String right;

        private Pair(String left, String right) {
            this.left = left;
            this.right = right;
        }
    }
}
