package mock2.excelColumn;

class Solution {
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }

    public static String convertToTitle(int n) {
        StringBuilder columnName = new StringBuilder();
        int rem = 0;
        while (n > 0) {
            rem = n % 26;
            if (rem == 0) {
                columnName.append('Z');
                n = (n / 26) - 1;
            } else {
                columnName.append((char) (rem+64));
                n = n / 26;
            }
        }
        return columnName.reverse().toString();
    }
}