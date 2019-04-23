package clumsyFactorial;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(clumsy(2));
    }

    public static int clumsy(int N) {
        StringBuilder factorialString = new StringBuilder();
        Character[] ops = {'*', '/', '+', '-'};
        int j = 0;
        for (int i = N; i > 0; i--) {
            factorialString = factorialString.append(i + " " + ops[j] + " ");
            j = (++j) % 4;
        }
        String substring = factorialString.substring(0, factorialString.length() - 2);
        System.out.println(substring);
        String[] split = substring.split(" ");
        Stack<String> stack = new Stack<>();
        String next = "", prev = "";
        int nextInt, prevInt;
        int result = 0;
        for (int i = 0; i < split.length; i++) {
            String curr = split[i];
            if (curr.equals("*") || curr.equals("/")) {
                prev = stack.pop();
                next = split[++i];
                prevInt = Integer.parseInt(prev);
                nextInt = Integer.parseInt(next);
                if (curr.equals("*")) {
                    result = prevInt * nextInt;
                } else {
                    result = prevInt / nextInt;
                }
                stack.push(String.valueOf(result));
            } else {
                stack.push(curr);
            }
        }
        if (stack.size() == 1)
            return Integer.parseInt(stack.pop());
        Stack<String> reverseStack = new Stack<>();
        while (!stack.isEmpty()) {
            reverseStack.push(stack.pop());
        }

        result = 0;
        while (!reverseStack.isEmpty()) {
            String curr = reverseStack.pop();
            if (curr.equals("+") || curr.equals("-")) {
                prevInt = Integer.parseInt(prev);
                nextInt = Integer.parseInt(reverseStack.pop());
                if (curr.equals("+")) {
                    result = prevInt + nextInt;
                } else {
                    result = prevInt - nextInt;
                }
                prev = String.valueOf(result);
            } else {
                prev = curr;
            }
        }
        return result;
    }
}
