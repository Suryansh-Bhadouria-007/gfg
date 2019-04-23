package oddEvenProblem;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int A[] = {5,1,3,4,2};
        System.out.println(oddEvenJumps(A));
    }

    public static int oddEvenJumps(int[] A) {
        int n = A.length;
        int odd[] = new int[n];
        int even[] = new int[n];
        Map<Integer, List<Integer>> arrayValueToIndexMapOdd = null;
        Map<Integer, List<Integer>> arrayValueToIndexMapEven = new TreeMap<>();

        for (int i = n - 1; i >= 0; i--) {
            //put in map
            List<Integer> indeces = arrayValueToIndexMapEven.get(A[i]);
            if (indeces != null && indeces.size() > 0) {
                ((LinkedList<Integer>) indeces).addFirst(i);
            } else {
                indeces = new LinkedList<>();
                ((LinkedList<Integer>) indeces).addFirst(i);
            }
            arrayValueToIndexMapEven.put(A[i], indeces);

            //handling even iters
            List<Integer> indecesToBeConsideredEvenPrev = null;
            List<Integer> indecesToBeConsideredEvenSame = null;

            for (Map.Entry<Integer, List<Integer>> entry : arrayValueToIndexMapEven.entrySet()) {
                if (entry.getKey() < A[i]) {
                    indecesToBeConsideredEvenPrev = entry.getValue();
                } else if (entry.getKey() == A[i]) {
                    indecesToBeConsideredEvenSame = entry.getValue();
                } else
                    break;
            }
            if (indecesToBeConsideredEvenSame != null && indecesToBeConsideredEvenSame.size() >= 1) {
                int index = indecesToBeConsideredEvenSame.get(0);
                if (i == n - 1)
                    index = indecesToBeConsideredEvenSame.get(0);
                else if (index == i && indecesToBeConsideredEvenSame.size() > 1)
                    index = indecesToBeConsideredEvenSame.get(1);
                else if (indecesToBeConsideredEvenSame.size() == 1 && indecesToBeConsideredEvenPrev != null && indecesToBeConsideredEvenPrev.size() > 0) {
                    index = indecesToBeConsideredEvenPrev.get(0);
                } else
                    index = -1;
                even[i] = index;
            } else
                even[i] = -1;

            arrayValueToIndexMapOdd = new TreeMap<>(Collections.reverseOrder());
            arrayValueToIndexMapOdd.putAll(arrayValueToIndexMapEven);
            //handling odd iters
            List<Integer> indecesToBeConsideredOddSame = null;
            List<Integer> indecesToBeConsideredOddPrev = null;

            for (Map.Entry<Integer, List<Integer>> entry : arrayValueToIndexMapOdd.entrySet()) {
                if (entry.getKey() > A[i]) {
                    indecesToBeConsideredOddPrev = entry.getValue();
                } else if (entry.getKey() == A[i]) {
                    indecesToBeConsideredOddSame = entry.getValue();
                } else
                    break;
            }
            if (indecesToBeConsideredOddSame != null && indecesToBeConsideredOddSame.size() >= 1) {
                int index = indecesToBeConsideredOddSame.get(0);
                if (i == n - 1)
                    index = indecesToBeConsideredOddSame.get(0);
                else if (index == i && indecesToBeConsideredOddSame.size() > 1)
                    index = indecesToBeConsideredOddSame.get(1);
                else if (indecesToBeConsideredOddSame.size() == 1 && indecesToBeConsideredOddPrev != null && indecesToBeConsideredOddPrev.size() > 0)
                    index = indecesToBeConsideredOddPrev.get(0);
                else
                    index = -1;
                odd[i] = index;
            } else
                odd[i] = -1;
        }
        int count = 0;
        boolean oddTurn = true;
        int currentIndex;
        for (int i = 0; i < n; ) {
            currentIndex = i;
            while (currentIndex != -1 && currentIndex != n-1) {
                if (oddTurn) {
                    currentIndex = odd[currentIndex];
                } else {
                    currentIndex = even[currentIndex];
                }
                oddTurn = !oddTurn;
            }
            if (currentIndex == n - 1) {
                count++;
            }
            i++;
            oddTurn = true;
        }
        return count;
    }
}
