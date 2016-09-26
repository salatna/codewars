package ru.antalas.codewars;

public class LongestConsec {
    public static String longestConsec(String[] strarr, int k) {
        if (strarr.length == 0 || k > strarr.length || k <= 0) {
            return "";
        }

        int consecLength = firstConsec(strarr, k);
        int maxLength = consecLength;
        int maxConsecAt = 0;

        for (int i = k; i < strarr.length; i++) {
            consecLength = slideConsec(strarr, i, k, consecLength);
            if (consecLength > maxLength) {
                maxLength = consecLength;
                maxConsecAt = i - k + 1;
            }
        }

        return result(strarr, maxConsecAt, k);
    }

    private static int firstConsec(String[] strarr, int k) {
        int totalLength = 0;
        for (int i = 0; i < k; i++) {
            totalLength += strarr.length;
        }
        return totalLength;
    }

    private static int slideConsec(String[] strarr, int slideAt, int consecSize, int consecLength) {
        int slideFrom = slideAt - consecSize;
        return consecLength + strarr[slideAt].length() - strarr[slideFrom].length();
    }

    private static String result(String[] strarr, int maxChainStart, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = maxChainStart; i < maxChainStart + k; i++) {
            sb.append(strarr[i]);
        }
        return sb.toString();
    }
}
