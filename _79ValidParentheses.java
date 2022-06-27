//Leetcode - 20 - Valid Parentheses

//first approach  - using stack normally
//time comp - O(n) for string traversal
//space comp - O(n)

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

//smart approach - using deque & switch or we can solve it with the same approach using stack too

class Solution {
    public boolean isValid(String s) {
        // using deque & switch
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || c != stack.pop())
                        return false;
            }
        }
        return stack.isEmpty();
    }
}

class Solution {
    public boolean isValid(String s) {
        // using stack & same previous technique
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
}