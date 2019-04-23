package partitionLabels;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int lastIndex = S.lastIndexOf(ch);
            for (int j = i; j < lastIndex; j++) {
                char innerChar = chars[j];
                int lastIndexOfInner = S.lastIndexOf(innerChar);
                if (lastIndexOfInner > lastIndex) {
                    lastIndex = lastIndexOfInner;
                }
            }
            result.add(lastIndex - i+1);
            i = lastIndex;
        }
        return result;
    }
}