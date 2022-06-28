//Coding Ninjas - Sort a stack
//only using recursion & pus(), pop(), isEmpty()
//can't use any loops

//time comp - O(n)
//space comp - O(n) - stack space

import java.util.*;

public class Solution {

    private static void sortInDesc(Stack<Integer> stack, int holdX) {
        if (stack.isEmpty() == true || holdX > stack.peek())
            stack.push(holdX);
        else {
            int currHoldX = stack.pop();
            sortInDesc(stack, holdX);
            stack.push(currHoldX);
        }
    }

    public static void sortStack(Stack<Integer> stack) {
        // Write your code here.
        if (stack.size() > 0) {
            int holdX = stack.pop();
            sortStack(stack);
            sortInDesc(stack, holdX);
        }
    }

}