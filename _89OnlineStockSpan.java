//Leetcode - 901 - Online Stock Span

/*
Push every pair of <price, result> to a stack.
Pop lower price from the stack and accumulate the count.

One price will be pushed once and popped once.
So 2 * N times stack operations and N times calls.
I'll say time complexity is amortized O(1)
*/

// So even if array is [5,4,3,2,1,6]
// We only compare with top, so its one call for each and answer would be [1,1,1,1,1,6] , but for checking the span for price 6 would require individually checking all the previously added prices on the stack which is O(n). 

//time comp - O(n) - n is no. of prices
//space comp - O(n)

class StockSpanner {
    // just a slight variation of next greater element to left
    // stack of pair <curr price, max no. of consecutive days>
    Stack<int[]> stk;

    public StockSpanner() {
        stk = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stk.isEmpty() && stk.peek()[0] <= price) {
            span += stk.pop()[1];
        }
        stk.push(new int[] { price, span });
        return span;
    }
}