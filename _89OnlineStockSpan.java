//Leetcode - 901 - Online Stock Span

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