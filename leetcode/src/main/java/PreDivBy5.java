import java.util.Arrays;

public class PreDivBy5 {
    private static String processNumber(int A[]) {
        int length = A.length;
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();

        if (length % 2 != 0) {
            sb.append('0');
            length += 1;
        }

        for (int elem : A) {
            sb.append(elem);
        }

        for (int i = length - 1; i >= 0; i = i - 2) {
            char lsbChar = sb.charAt(i);
            char msbChar = sb.charAt(i - 1);
            int lsb = lsbChar == '0' ? 0 : 1;
            int msb = msbChar == '0' ? 0 : 1;
            int base4Digit = lsb * 1 + msb * 2;
            result.append(base4Digit);
        }
        return result.reverse().toString();
    }

    private static boolean checkDivisibiltyBy11(String number) {
        int isOddDigit = 1;
        int odd_sum = 0, even_sum = 0;

        for (int i = 0; i < number.length(); i++) {
            // if digit of base 4 is at odd place, then
            // add it to odd_sum
            if (isOddDigit != 0)
                odd_sum += number.charAt(i);
                // else digit of base 4 is at even place,
                // add it to even_sum
            else
                even_sum += number.charAt(i);

            isOddDigit ^= 1;
        }
        if (Math.abs(odd_sum - even_sum) % 5 == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
    }
}
