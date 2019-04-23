package mock6.excelColumnTitleToNumber;

public class Solution {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }

    public static int titleToNumber(String s) {
        int l = s.length();
        int num = 0;
        for (int i = l - 1; i >= 0; i--) {
            int ch = s.charAt(l - 1 - i) - 'A' + 1;
            num += Math.pow(26, i) * ch;
        }
        return num;
    }
}