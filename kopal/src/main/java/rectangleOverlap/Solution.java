package rectangleOverlap;

class Solution {
    public static void main(String[] args) {
        int a[] = {0, 0, 1, 1};
        int b[] = {1, 0, 2, 1};
        System.out.println(isRectangleOverlap(a, b));
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x11 = rec1[0];
        int y11 = rec1[1];
        int x12 = rec1[2];
        int y12 = rec1[3];

        int x21 = rec2[0];
        int y21 = rec2[1];
        int x22 = rec2[2];
        int y22 = rec2[3];

        if (y12 <= y21 || y22 <= y11)
            return false;
        if (x12 <= x21 || x22 <= x11)
            return false;
        return true;

    }
}
