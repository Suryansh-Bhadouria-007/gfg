package mock3.removeKDigitsToMinimizeNumber;

public class Solution {
    public static void main(String[] args) {
        System.out.println(removeKdigits("9", 1));
    }

    public static String removeKdigits(String num, int k) {
        if(num.length()==k)
            return "0";
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < sb.length() - 1 && k > 0; i++) {
            Integer c0 = Integer.parseInt(sb.charAt(i) + "");
            Integer c1 = Integer.parseInt(sb.charAt(i + 1) + "");
            if (c0 > c1) {
                sb.deleteCharAt(i);
                k--;
                i--;
            }
        }
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '0') {
                sb.deleteCharAt(i);
                if (sb.charAt(i) != '0')
                    break;
            }
        }
        return sb.toString();
    }
}
