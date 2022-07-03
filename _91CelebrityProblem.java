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

// Another approach - Using graphs - indegree & outdegree of a person
// time comp - O(n^2)
// space comp - O(n)

class Solution {
    // Function to find if there is a celebrity in the party or not.
    int isIknowsJ(int[][] mat, int i, int j) {
        return mat[i][j];
    }

    int celebrity(int M[][], int n) {
        // code here
        // using graph - but not need to construct it,as matrix will help in filling
        // indegree & outdegree
        int[] indegree = new int[n];
        int[] outdegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = isIknowsJ(M, i, j);

                indegree[j] += x;
                outdegree[i] += x;

            }
        }
        // now celeb is - with indegree = n-1 & outdegree = 0
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0 && indegree[i] == n - 1)
                return i;
        }
        return -1;
    }
}

// Another Approach - using recursion
// time comp - O(n)
// space comp - O(1) & O(n) recursion stack space

class Solution {
    // Function to find if there is a celebrity in the party or not.
    int knows(int[][] M, int i, int j) {
        return M[i][j];
    }

    int findCeleb(int[][] M, int n) {
        // base case - when there are no people
        if (n == 0)
            return -1;
        // faith
        int id = findCeleb(M, n - 1);

        // if there are no celeb
        if (id == -1)
            return n - 1;

        // if the id knows nth person then, id can't be celeb, but nth person could be
        if (knows(M, id, n - 1) == 1)
            return n - 1;

        // if the nth person knows id then, nth person can't be a celeb but id could be
        else if (knows(M, n - 1, id) == 1)
            return id;
        // if there's no celeb
        return -1;
    }

    int celebrity(int M[][], int n) {
        // using recursion
        int id = findCeleb(M, n);

        // now check whether this id is really a celeb or not
        if (id == -1)
            return id;
        else {
            int outD = 0, inD = 0;
            for (int i = 0; i < n; i++) {
                if (i != id) {
                    outD += knows(M, id, i);
                    inD += knows(M, i, id);
                }
            }

            if (outD == 0 && inD == n - 1)
                return id;
            return -1;
        }
    }
}

// Most optimal - using 2 pointers

// time comp - O(n)
// space comp - O(1)

class Solution {
    // Function to find if there is a celebrity in the party or not.
int celebrity(int M[][], int n) {
    // code here
    // using 2 pointers
    int i = 0, j = n - 1;
    while (i < j) {
        if (M[i][j] == 0)
            j--;
        else
            i++;
    }
    int potCeleb = i;
    // confirmation
    for (int k = 0; k < n; k++) {
        if (k != potCeleb) {
            if (M[k][potCeleb] == 0 || M[potCeleb][k] == 1)
                return -1;
        }
    }
        return potCeleb;
    }
}