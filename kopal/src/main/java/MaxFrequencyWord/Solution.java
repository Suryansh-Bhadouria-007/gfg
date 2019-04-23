package MaxFrequencyWord;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String banned[] = {};
        System.out.println(mostCommonWord("a.", banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        List<String> bannedList = Arrays.asList(banned);
        Map<String, Integer> wordToFrequencyMap = new HashMap<>();
        String wordWithMaxFrequency = null;
        Integer maxFrequency = Integer.MIN_VALUE;
        for (String token : words) {
            if (!bannedList.contains(token)) {
                Integer freq = 1;
                if (wordToFrequencyMap.containsKey(token)) {
                    freq += wordToFrequencyMap.get(token);
                    wordToFrequencyMap.put(token, freq);
                } else {
                    wordToFrequencyMap.put(token, 1);
                }
                if (freq > maxFrequency) {
                    maxFrequency = freq;
                    wordWithMaxFrequency = token;
                }
            }
        }
        return wordWithMaxFrequency;
    }
}