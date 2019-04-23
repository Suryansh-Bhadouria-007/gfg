package BinarySearch;

public class BinarySearchFirstOccurence {

    private static boolean isGreaterThanEqualTo(int[] a, int index, int key) {
        if (a[index] >= key) return true;

        return false;
    }

    public static int findFirstOccurrence(int[] a, int start, int end, int key) {

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (isGreaterThanEqualTo(a, mid, key)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return (a[start] == key) ? start : -1;
    }

    public static void main(String[] args) {
        int[] input = {3, 10, 11, 15, 17, 17, 17, 20};

        int index = findFirstOccurrence(input, 0, input.length - 1, 17);
        System.out.print(index == -1 ? "Element not found" : "Element found at : " + index);
    }
}