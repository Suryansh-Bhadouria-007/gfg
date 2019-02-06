import java.util.*;
import java.util.stream.IntStream;

public class CandyProblem {
    static Map<Integer, List<Integer>> dayToCandyTypeMap = new HashMap<>();

    public static void main(String[] args) {
        Integer A[] = {7, 15, 2, 10};
        Integer B[] = {1, 5, 10, 0};
        Integer k = 5;
        Integer c[] = new Integer[A.length];
        Integer b[] = Arrays.copyOf(B, B.length);
        Arrays.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        int a[] = new int[A.length];
        int index = 0;
        for (int i = 0; i < b.length; i++) {
            index = findIndex(B, b[i]);
            a[i] = A[index];
            c[i] = index;
        }
        int day = 1;
        int i = 0;
        int sub = k;
        while (i < a.length && a[i] > 0) {
            if (a[i] - sub < 0) {
                sub = k + (k - a[i]);
                a[i] = -1;
                if (dayToCandyTypeMap.keySet().contains(day)) {
                    dayToCandyTypeMap.get(day).add(c[i]);
                    dayToCandyTypeMap.put(day, dayToCandyTypeMap.get(day));
                } else {
                    ArrayList<Integer> candyType = new ArrayList<>();
                    candyType.add(c[i]);
                    dayToCandyTypeMap.put(day, candyType);
                }
                i++;
            } else {
                a[i] = a[i] - sub;
                sub = k;
                if (dayToCandyTypeMap.keySet().contains(day)) {
                    dayToCandyTypeMap.get(day).add(c[i]);
                    dayToCandyTypeMap.put(day, dayToCandyTypeMap.get(day));
                } else {
                    ArrayList<Integer> candyType = new ArrayList<>();
                    candyType.add(c[i]);
                    dayToCandyTypeMap.put(day, candyType);
                }
                day++;
            }
        }
        isValid(1, 1);
        isValid(1, 2);
        isValid(1, 3);
        isValid(1, 6);
        isValid(2, 2);

    }

    public static boolean isValid(int candy_type, int day) {
        for (Map.Entry<Integer, List<Integer>> entry : dayToCandyTypeMap.entrySet()) {
            if (entry.getKey() == day) {
                List<Integer> candyTypes = entry.getValue();
                if (candyTypes.contains(candy_type)) {
                    System.out.println("yes");
                    return true;
                }
            }
        }
        System.out.println("no");
        return false;
    }

    public static int findIndex(Integer arr[], int t) {
        int len = arr.length;
        return IntStream.range(0, len)
                .filter(i -> t == arr[i])
                .findFirst() // first occurence
                .orElse(-1); // No element found
    }
}
