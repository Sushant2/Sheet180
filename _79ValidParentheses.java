//Leetcode - 20 - Valid Parentheses

//first approach  - using stack normally
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[')
                stk.push(c);
            else {
                if (c == '}' && !stk.isEmpty() && stk.peek() == '{')
                    stk.pop();
                else if (c == ')' && !stk.isEmpty() && stk.peek() == '(')
                    stk.pop();
                else if (c == ']' && !stk.isEmpty() && stk.peek() == '[')
                    stk.pop();
                else
                    return false;
            }
        }
        return stk.isEmpty();
    }
}