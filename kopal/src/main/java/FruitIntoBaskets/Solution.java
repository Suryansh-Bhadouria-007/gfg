package FruitIntoBaskets;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        int tree[] = {0, 1, 6, 6, 4, 4, 6};
        System.out.println(totalFruit(tree));
    }

    public static int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0)
            return 0;
        if (tree.length == 1)
            return 1;
        int maxCount = Integer.MIN_VALUE;
        Set<Integer> uniqueTypes = new HashSet<>();
        int start = 0, end = 0;
        for (int i = 0; i < tree.length; i++) {
            uniqueTypes.add(tree[i]);
            if (uniqueTypes.size() == 3) {
                end = i - 1;
                uniqueTypes.remove(tree[i]);
                if (end - start > maxCount) {
                    maxCount = end - start;
                }
                int startElem = tree[i - 1];
                for (int j = i - 1; j > 0; j--) {
                    if (startElem == tree[j])
                        start = j;
                    else break;
                }
                uniqueTypes.clear();
                uniqueTypes.add(startElem);
                uniqueTypes.add(tree[i]);
            }
            if ((uniqueTypes.size() <= 2) && (i == tree.length - 1)) {
                end = i;
                if (end - start > maxCount)
                    maxCount = end - start;
            }
        }
        return maxCount + 1;
    }
}