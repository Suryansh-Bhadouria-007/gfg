package PartitionArrayInto3EqualSumParts;

public class Solution {
    public static void main(String[] args) {
        int A[] = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        System.out.println(canThreePartsEqualSum(A));
    }

    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0)
            return false;
        sum /= 3;
        int numberOfParts = 0;
        int localSum = 0;

        for (int i = 0; i < A.length; i++) {
            localSum += A[i];
            if (localSum == sum) {
                localSum = 0;
                numberOfParts++;
            }
        }
        if (numberOfParts == 3)
            return true;
        return false;

    }
}
