import java.util.ArrayList;
import java.util.List;

public class MaxSumNonAdjacentCircularArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 1};
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            l1.add(arr[i]);
        }
        for (int i = 1; i < arr.length; i++) {
            l2.add(arr[i]);
        }
        MaxSumNonAdjacentArray maxSumNonAdjacentArray = new MaxSumNonAdjacentArray();
        Integer[] arr1 = new Integer[l1.size()];
        arr1 = l1.toArray(arr1);
        Integer[] arr2 = new Integer[l2.size()];
        arr2 = l1.toArray(arr1);
        int max = Math.max(maxSumNonAdjacentArray.findMaxSum(arr1, arr1.length), maxSumNonAdjacentArray.findMaxSum(arr2, arr2.length));
        System.out.println(max);
    }
}
