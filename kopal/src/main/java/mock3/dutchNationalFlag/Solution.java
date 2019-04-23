package mock3.dutchNationalFlag;

public class Solution {
    public static void main(String[] args) {
        int nums[] = {0, 1, 2, 2, 1, 0, 1};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        int n = nums.length;
        int lo = 0, mid = 0, hi = n - 1;
        int temp;
        while (mid <= hi) {
            switch (nums[mid]) {
                case 0:
                    //swap lo & mid
                    temp = nums[lo];
                    nums[lo] = nums[mid];
                    nums[mid] = temp;
                    lo++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    //swap mid and hi
                    temp = nums[hi];
                    nums[hi] = nums[mid];
                    nums[mid] = temp;
                    hi--;
                    break;
            }
        }
    }
}
