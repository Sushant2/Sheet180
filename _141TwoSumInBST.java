//leetcode - 653 - Two Sum IV - Input is a BST

//Naive/Brute force
//time comp - O(n*logn) ~ O(n*h) ; h is height of BST
//space comp - O(n)

class Solution {

    private boolean find(TreeNode root, int target) {
        if (root == null)
            return false;

        if (root.val == target)
            return true;

        if (root.val < target)
            return find(root.right, target);
        else if (root.val > target)
            return find(root.left, target);
        else
            return true;
    }

    private boolean findTargetUtil(TreeNode root, TreeNode curr, int k) {
        if (curr == null)
            return false;

        boolean left = findTargetUtil(root, curr.left, k);

        int remSum = k - curr.val;
        if (remSum > curr.val) {
            if (find(root, remSum))
                return true;
        }

        boolean right = findTargetUtil(root, curr.right, k);

        return left || right;

    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        return findTargetUtil(root, root, k);
    }
}


//Better Approach
//time comp - O(n)
//space comp - O(n)

class Solution {
    private void getInorder(TreeNode root, ArrayList<Integer> inorder) {
        if (root == null)
            return;

        getInorder(root.left, inorder);
        inorder.add(root.val);
        getInorder(root.right, inorder);
    }

    public boolean findTarget(TreeNode root, int k) {
        // using better approach
        if (root == null)
            return false;
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // now apply 2 pointer in sorted list
        int low = 0, high = inorder.size() - 1;
        while (low < high) {
            int currSum = inorder.get(low) + inorder.get(high);
            if (currSum == k)
                return true;
            else if (currSum < k)
                low++;
            else
                high--;
        }
        return false;
    }
}


//Most Optimised Code

//time comp - O(n)
//space comp - O(h)

public class BSTIterator {
    private Stack<TreeNode> stk = new Stack<>();
    // reverse (true => before() iterator) / (false => next() iterator)
    boolean reverse = true;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    // return whether we've next number or not
    public boolean hashNext() {
        return !stk.isEmpty();
    }

    // return the next number
    public int next() {
        TreeNode node = stk.pop();
        if (reverse == false)
            pushAll(node.right);
        else
            pushAll(node.left);
        return node.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stk.push(node);
            if (reverse == false)
                node = node.left;
            else
                node = node.right;
        }
    }

}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // most optimized
        if (root == null)
            return false;
        BSTIterator nextObj = new BSTIterator(root, false);
        BSTIterator beforeObj = new BSTIterator(root, true);

        int i = nextObj.next();
        int j = beforeObj.next(); // we avoiding creating before(),

        while (i < j) {
            if (i + j == k)
                return true;
            if (i + j < k)
                i = nextObj.next();
            else
                j = beforeObj.next();
        }
        return false;
    }
}