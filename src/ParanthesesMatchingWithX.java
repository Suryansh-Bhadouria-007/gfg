import java.util.Stack;

// program to determine whether given
// expression is balanced/ parenthesis
// expression or not.
// Function to check if two brackets are matching
// or not.
public class ParanthesesMatchingWithX {
    static boolean isMatching(char a, char b) {
        if ((a == '{' && b == '}') || (a == '[' && b == ']')
                || (a == '(' && b == ')') || a == 'X')
            return true;
        return false;
    }

    // Recursive function to check if given expression
// is balanced or not.
    static boolean isBalanced(char[] s, Stack<Character> ele, int ind) {

        // Base case.
        // If the string is balanced then all the opening
        // brackets had been popped and stack should be
        // empty after string is traversed completely.
        if (ind == s.length)
            return ele.isEmpty();

        // variable to store element at the top of the stack.
        char topEle;

        // variable to store result of recursive call.
        boolean res;

        // Case 1: When current element is an opening bracket
        // then push that element in the stack.
        if (s[ind] == '{' || s[ind] == '(' || s[ind] == '[') {
            ele.push(s[ind]);
            return isBalanced(s, ele, ind + 1);
        }

        // Case 2: When current element is a closing bracket
        // then check for matching bracket at the top of the
        // stack.
        else if (s[ind] == '}' || s[ind] == ')' || s[ind] == ']') {

            // If stack is empty then there is no matching opening
            // bracket for current closing bracket and the
            // expression is not balanced.
            if (ele.empty())
                return false;

            topEle = ele.peek();
            ele.pop();

            // Check bracket is matching or not.
            if (!isMatching(topEle, s[ind]))
                return false;

            return isBalanced(s, ele, ind + 1);
        }

        // Case 3: If current element is 'X' then check
        // for both the cases when 'X' could be opening
        // or closing bracket.
        else if (s[ind] == 'X') {
            Stack<Character> tmp = ele;
            tmp.push(s[ind]);
            res = isBalanced(s, tmp, ind + 1);
            if (res)
                return true;
            if (ele.empty())
                return false;
            ele.pop();
            return isBalanced(s, ele, ind + 1);
        }
        return false;
    }

    public static void main(String args[]) {
        String s = "{(X}[]";
        Stack<Character> ele = new Stack<>();
        if (isBalanced(s.toCharArray(), ele, 0))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}




