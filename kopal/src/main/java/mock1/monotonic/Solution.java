package mock1.monotonic;

class Solution {
    public static void main(String[] args) {
        int A[] = {1, 1, 1};
        System.out.println(isMonotonic(A));
    }

    public static boolean isMonotonic(int[] A) {
        int N = A.length;
        if (N == 0 || N == 1)
            return true;
        int index = containsSameElements(A, N);
        if (index == N)
            return true;
        boolean increasing = (A[index] - A[index - 1] > 0) ? true : false;

        if (increasing) {
            for (int i = index; i < N; i++) {
                if (A[i] < A[i - 1]) {
                    return false;
                }
            }
        } else {
            for (int i = index; i < N; i++) {
                if (A[i] > A[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int containsSameElements(int A[], int N) {
        int i = -1;
        for (i = 1; i < N; ++i) {
            if (A[i] != A[i - 1])
                break;
        }
        return i;
    }
}