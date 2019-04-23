package SmallestIntegerDivisibleByKContainingOnly1;

public class Solution {
    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK(5));
    }

    public static int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0)
            return -1;
        int r = 0;
        for (int N = 1; N <= K; ++N) {
            r = (r * 10 + 1) % K;
            if (r == 0) return N;
        }

        return -1;
    }
}

