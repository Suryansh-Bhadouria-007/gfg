package BinaryStringWithSubstringsRepresenting1ToN;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getIntegersFromSubString("10100"));
    }

    public boolean queryString(String S, int N) {
        Set<Integer> processedIntegers = new HashSet<>();
        for (int i = N; i > 1; i--) {
            if (!processedIntegers.contains(i)) {
                String binaryStringFromInteger = getBinaryStringFromInteger(i);
                if (!S.contains(binaryStringFromInteger))
                    return false;
                processedIntegers.add(i);
                processedIntegers.addAll(getIntegersFromSubString(binaryStringFromInteger));
            }
        }
        return true;
    }

    private static String getBinaryStringFromInteger(int X) {
        StringBuilder result = new StringBuilder();
        int r = 0;
        while (X > 0) {
            r = X % 2;
            result.append(r);
            X /= 2;
        }
        return result.reverse().toString();
    }

    private static Set<Integer> getIntegersFromSubString(String binaryStringFromInteger) {
        int l = binaryStringFromInteger.length();
        Set<Integer> processedInts = new HashSet<>();
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l+1; j++) {
                processedInts.add(getIntegerFromBinaryString(binaryStringFromInteger.substring(i, j)));
            }
        }
        return processedInts;
    }

    private static Integer getIntegerFromBinaryString(String s) {
        StringBuilder input = new StringBuilder(s);
        StringBuilder reverse = input.reverse();
        int sum = 0;
        for (int i = 0; i < reverse.length(); i++) {
            sum += Math.pow(2, i) * (reverse.charAt(i) == '0' ? 0 : 1);
        }
        return sum;
    }
}
