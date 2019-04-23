package LargestSumAfterKNegations;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int A[] = {-2, 9, 9, 8, 4};
        int K = 5;
        System.out.println(largestSumAfterKNegations(A, K));
    }

    public static int largestSumAfterKNegations(int[] A, int K) {
        int n = A.length;
        for (int i = 1; i <= K; i++) {
            int min = +2147483647;
            int index = -1;
            for (int j = 0; j < n; j++) {
                if (A[j] < min) {
                    min = A[j];
                    index = j;
                }
            }
            if (min == 0)
                break;
            A[index] = -A[index];
        }

        // Calculate sum of array
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += A[i];
        return sum;
    }
}
