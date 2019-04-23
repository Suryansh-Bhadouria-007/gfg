package RemovePrimitiveParantheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
* For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
* */
public class Solution {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }

    public static String removeOuterParentheses(String S) {
        List<String> primitives = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            Character ch = S.charAt(i);
            current = current.append(ch);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                    if (stack.size() == 0) {
                        primitives.add(current.toString());
                        current = new StringBuilder();
                    }
                } else {
                    //unbalanced string
                    return null;
                }
            }
        }
        String result = "";
        for (String str : primitives) {
            result += str.substring(1, str.length() - 1);
        }
        return result;
    }
}
