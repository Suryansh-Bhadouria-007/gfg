package mock4.singleRepeatingElement;

public class Solution {
    public static void main(String[] args) {
        int nums[] = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {

        int length = nums.length;
//        return search(nums, 0, length - 1);
        int start = 0, mid = Integer.MIN_VALUE;
        int end = length - 1;
        while (start <= end) {
            mid = (start + end + 1) / 2;
            if (end - start < 3) {
                if (nums[start] == nums[mid])
                    return nums[end];
                else if (nums[end] == nums[mid])
                    return nums[start];
            } else {
                if (mid % 2 != 0) {
                    if (nums[mid] == nums[mid - 1]) {
                        start = mid + 1;
                    } else if (nums[mid] == nums[mid + 1]) {
                        end = mid;
                    } else {
                        break;
                    }
                } else {
                    if (nums[mid] == nums[mid - 1]) {
                        end = mid;
                    } else if (nums[mid] == nums[mid + 1]) {
                        start = mid + 1;
                    } else {
                        break;
                    }
                }
            }
        }
        return nums[mid];
    }

//    public static int search(int[] arr, int low, int high) {
//        if (low > high)
//            return -1;
//        if (low == high) {
//            return arr[low];
//        }
//
//        // Find the middle point
//        int mid = (low + high) / 2;
//
//        // If mid is even and element next to mid is
//        // same as mid, then output element lies on
//        // right side, else on left side
//        if (mid % 2 == 0) {
//            if (arr[mid] == arr[mid + 1])
//                return search(arr, mid + 2, high);
//            else
//                return search(arr, low, mid);
//        }
//        // If mid is odd
//        else if (mid % 2 == 1) {
//            if (arr[mid] == arr[mid - 1])
//                return search(arr, mid + 1, high);
//            else
//                return search(arr, low, mid - 1);
//        }
//        return -1;
//    }
}
