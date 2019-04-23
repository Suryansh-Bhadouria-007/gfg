package mock6.anagram;

class Solution {
    public static void main(String[] args) {
        String a="rat";
        String b="car";
        System.out.println(isAnagram(a,b));
    }
    public static boolean isAnagram(String a, String b) {
        if (a == null && b == null)
            return true;
        if (a.length() == 0 && b.length() == 0)
            return true;
        if (a.length() != b.length())
            return false;
        int charCount[] = new int[26];
        for (int i = 0; i < a.length(); i++) {
            charCount[a.charAt(i) - 'a']++;
            charCount[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0)
                return false;
        }
        return true;
    }
}