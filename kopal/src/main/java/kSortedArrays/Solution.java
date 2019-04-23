package kSortedArrays;
/*
* Given k sorted arrays, you need to select one element from each array such that
* the difference of maximum element and minimum element of the selected elements is minimum.
* Example for k = 3
*1 13 27 30
*16 20 29
*2 3 14 18 19 22 25 28

ans: 2 selected elements (27, 29, 28)
*
*/


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        int noOfArrays = k;
        List<List<Integer>> arrays = new ArrayList<>();
        while (noOfArrays-- > 0) {
            String split[] = sc.nextLine().split(" ");
            List<Integer> array1 = new ArrayList<>();
            for (String s : split) {
                array1.add(Integer.parseInt(s));
            }
            arrays.add(array1);
        }
        System.out.println(findRequiredArrayNew(arrays, k));
    }

    private static Set<Integer> findRequiredArrayNew(List<List<Integer>> arrays, int k) {
        Set<Integer> selected = new HashSet<>();
        Map<Integer, List<Integer>> elementToArrayMap = new TreeMap<>();
        int arrayId = 0;
        Integer min = Integer.MAX_VALUE;
        for (List<Integer> array : arrays) {
            arrayId++;
            for (Integer element : array) {
                if (elementToArrayMap.containsKey(element)) {
                    List<Integer> arrayIds = elementToArrayMap.get(element);
                    arrayIds.add(arrayId);
                    elementToArrayMap.put(element, arrayIds);
                } else {
                    List<Integer> arrayIds = new ArrayList<>();
                    arrayIds.add(arrayId);
                    elementToArrayMap.put(element, arrayIds);
                }
                if (element < min) {
                    min = element;
                }
            }
        }
        int diff = Integer.MAX_VALUE, localDiff;
        Set<Integer> localSelectedArrayIds = new HashSet<>();
        Set<Integer> localSelectedElements = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> entry : elementToArrayMap.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> value = entry.getValue();
            localSelectedElements.add(key);
            localSelectedArrayIds.addAll(value);

            if (localSelectedArrayIds.size() == k) {
                localDiff = key - min;
                if (localDiff <= diff) {
                    selected = createCopy(localSelectedElements);
                    diff = localDiff;
                }
                localSelectedArrayIds.clear();
                localSelectedElements.clear();
                localSelectedElements.add(key);
                localSelectedArrayIds.addAll(value);
                min = key;
            }
        }
        return selected;
    }

    private static Set<Integer> createCopy(Set<Integer> localSelectedElements) {
        Set<Integer> newSet = new HashSet<>();
        for (Integer i : localSelectedElements) {
            newSet.add(i);
        }
        return newSet;
    }


    private static List<Integer> findRequiredArray(List<List<Integer>> arrays, int k) {
        int pointers[] = new int[k];
        for (int i = 0; i < k; i++) {
            pointers[i] = 0;
        }
        Set<Integer> set = new LinkedHashSet<>();
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < k; i++) {
            Integer current = arrays.get(i).get(0);
            if (current < min) {
                min = current;
                minIndex = i;
            }
            if (current > max) {
                max = current;
                maxIndex = i;
            }
            set.add(current);
        }
        return null;
    }
}
