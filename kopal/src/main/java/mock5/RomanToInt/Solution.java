package mock5.RomanToInt;

import java.util.HashMap;
import java.util.Map;

/*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

* There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.*/
class Solution {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int num = 0;
        Map<Character, Integer> romanNumeralToIntegerValueMap = new HashMap<>();
        romanNumeralToIntegerValueMap.put('I', 1);
        romanNumeralToIntegerValueMap.put('V', 5);
        romanNumeralToIntegerValueMap.put('X', 10);
        romanNumeralToIntegerValueMap.put('L', 50);
        romanNumeralToIntegerValueMap.put('C', 100);
        romanNumeralToIntegerValueMap.put('D', 500);
        romanNumeralToIntegerValueMap.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            char ch0 = s.charAt(i);
            char ch1 = ((i + 1) < s.length()) ? s.charAt(i + 1) : ' ';
            if ((ch0 == 'I' && (ch1 == 'V' || ch1 == 'X'))
                    || (ch0 == 'X' && (ch1 == 'L' || ch1 == 'C'))
                    || (ch0 == 'C' && (ch1 == 'D' || ch1 == 'M'))) {
                if (ch0 == 'I') {
                    if (ch1 == 'V')
                        num += 4;
                    else num += 9;
                } else if (ch0 == 'X') {
                    if (ch1 == 'L')
                        num += 40;
                    else
                        num += 90;
                } else if (ch0 == 'C') {
                    if (ch1 == 'D')
                        num += 400;
                    else
                        num += 900;
                }
                i++;
            } else {
                num += romanNumeralToIntegerValueMap.get(ch0);
            }

        }
        return num;
    }
}