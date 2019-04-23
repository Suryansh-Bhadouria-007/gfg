import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class PrefixDivisibleBy5 {
    public static void main(String[] args) {
        System.out.println(prefixesDivBy5());
    }

    public static List<Boolean> prefixesDivBy5() {
        int[] A = {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1};
        int l = A.length;
        System.out.println("length" + l);
        List<Boolean> answer = new ArrayList<Boolean>();
        BigInteger sum = BigInteger.ZERO;
        for (int i = l - 1; i >= 0; i--) {
//            System.out.println(i);
            int index = -1 * (i - (l - 1));
            long val = A[index] * (long) Math.pow(2, i);
            sum = sum.add(BigInteger.valueOf(val));
            if (sum.mod(BigInteger.valueOf(5l)).equals(BigInteger.ZERO))
                answer.add(true);
            else
                answer.add(false);
            System.out.println(index + ":\t" + sum);
        }
        return answer;
    }
}