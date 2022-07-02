//Java/Coding Ninja - Celebrity Problem

//Solution 1 - using stack
//pop 2, push 1 potential celeb
//time comp - O(n)
//space comp - O(n)

class Solution {
    // Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n) {
        // code here
        Stack<Integer> possCelebs = new Stack<>();
        // push all possible celebs
        int c = 0;
        while (c != n) {
            possCelebs.push(c);
            c++;
        }

        // now pop 2-2 celebs till only 1 celebs left in the stack
        while (possCelebs.size() > 1) {
            int b = possCelebs.pop();
            int a = possCelebs.pop();
            if (M[a][b] == 0) {
                // b can't be a celeb
                possCelebs.push(a);
            }
            if (M[a][b] == 1) {
                // a can't be a celeb
                possCelebs.push(b);
            }
        }
        // confirmation check that the last celeb is actually a celeb or not
        int celeb = possCelebs.pop();
        // if celeb - it's row should be zero except it's cell
        for (int j = 0; j < n; j++) {
            if (j == celeb)
                continue;
            if (M[celeb][j] == 1)
                return -1;
        }
        // if celeb - it's col should be one except it's cell
        for (int i = 0; i < n; i++) {
            if (i == celeb)
                continue;
            if (M[i][celeb] == 0)
                return -1;
        }
        return celeb;
    }
}