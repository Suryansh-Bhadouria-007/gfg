package mock1.numberEncoding;

/*
* A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }

    public static int numDecodings(String s) {
        if(s.startsWith("0"))
            return 0;
        char[] digits = s.toCharArray();
        int n = digits.length;
        return countDecoding(digits, n);
    }

    static int countDecoding(char[] digits, int n) {
        if (n == 0 || n == 1)
            return 1;

        int count = 0;

        if (digits[n - 1] > '0')
            count = countDecoding(digits, n - 1);


        if (digits[n - 2] == '1' ||
                (digits[n - 2] == '2' && digits[n - 1] < '7'))
            count += countDecoding(digits, n - 2);

        return count;
    }
}
