package camelcaseMatching;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> answer = new ArrayList<>();
        String lowercase = "[a-z]*";
        String newPattern = lowercase;
        for (char ch : pattern.toCharArray()) {
            newPattern += ch + lowercase;
        }
        for (String query : queries) {
            answer.add(Pattern.compile(newPattern).matcher(query).matches());
        }
        return answer;
    }
}
