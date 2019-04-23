package mock4.frequentStack;

import java.util.*;

public class FreqStack {
    public static void main(String[] args) {
        FreqStack obj = new FreqStack();
        obj.push(5);
        obj.push(7);
        obj.push(5);
        obj.push(7);
        obj.push(4);
        obj.push(5);

        int param_2 = obj.pop();
        param_2 = obj.pop();
        param_2 = obj.pop();
        param_2 = obj.pop();

    }

    Map<Integer, List<Integer>> frequencyToElementsMap;
    Map<Integer, Integer> elementToFrequencyMap = new HashMap<>();
    List<Integer> elements;
    int top;

    public FreqStack() {
        frequencyToElementsMap = new TreeMap<>(Collections.reverseOrder());
        elementToFrequencyMap = new HashMap<>();
        elements = new ArrayList<>();
        top = -1;
    }

    public void push(int x) {
        elements.add(x);
        top++;
        if (elementToFrequencyMap.containsKey(x)) {
            Integer freq = elementToFrequencyMap.get(x);
            //update frequencyToElementsMap
            List<Integer> elems = frequencyToElementsMap.get(freq);
            elems.remove(new Integer(x));
            frequencyToElementsMap.put(freq, elems);
            freq++;
            List<Integer> integers = frequencyToElementsMap.get(freq);
            if (null == integers || integers.size() == 0)
                integers = new ArrayList<>();
            integers.add(x);
            frequencyToElementsMap.put(freq, integers);
            //update elementToFrequencyMap
            elementToFrequencyMap.put(x, freq);
        } else {
            elementToFrequencyMap.put(x, 1);
            List<Integer> elems = frequencyToElementsMap.get(1);
            if (elems != null && elems.size() > 1) {
                elems.add(x);
            } else {
                elems = new ArrayList<>();
                elems.add(x);
            }
            frequencyToElementsMap.put(1, elems);
        }

    }

    public int pop() {
        if (top < 0)
            return Integer.MIN_VALUE;
        List<Integer> maxFreqElements = null;
        Integer maxFreq = Integer.MIN_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : frequencyToElementsMap.entrySet()) {
            maxFreqElements = entry.getValue();
            maxFreq = entry.getKey();
            break;
        }
        Integer elementToBeRemoved = maxFreqElements.get(maxFreqElements.size() - 1);

        if (maxFreq > 1) {
            elementToFrequencyMap.put(elementToBeRemoved, maxFreq - 1);
            List<Integer> integers = frequencyToElementsMap.get(maxFreq);
            integers.remove(new Integer(elementToBeRemoved));
            if (integers.size() > 0) {
                frequencyToElementsMap.put(maxFreq, integers);
            } else {
                frequencyToElementsMap.remove(new Integer(maxFreq));
            }
            List<Integer> integers1 = frequencyToElementsMap.get(maxFreq - 1);
            integers1.add(elementToBeRemoved);
            frequencyToElementsMap.put(maxFreq - 1, integers1);
        } else {
            elementToFrequencyMap.remove(elementToBeRemoved);
            List<Integer> integers = frequencyToElementsMap.get(maxFreq);
            integers.remove(new Integer(elementToBeRemoved));
            frequencyToElementsMap.put(maxFreq, integers);

        }
        int index = -1;
        for (int i = elements.size() - 1; i > -1; i--) {
            if (elements.get(i).equals(elementToBeRemoved)) {
                index = i;
                break;
            }
        }
        elements.remove(index);
        top--;
        return elementToBeRemoved;
    }
}
