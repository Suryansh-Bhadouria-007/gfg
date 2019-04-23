package BinarySearch;

public class BinarySearchLastOccurence {
    private static boolean isLessThanEqualTo(int[] a, int index, int key) {
        if (a[index] <= key) return true;
        return false;
    }

    public static int findLastOccurrence(int[] a, int start, int end, int key) {
        while (start < end) {
            int mid = start + ((end - start) + 1) / 2;
            if (isLessThanEqualTo(a, mid, key)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return (a[start] == key) ? start : -1;
    }

    public static void main(String[] args) {
        int[] input = {3, 10, 11, 15, 17, 17, 17, 20};
        int index = findLastOccurrence(input, 0, input.length - 1, 17);
        System.out.print(index == -1 ? "Element not found" : "Element found at : " + index);
    }
}
