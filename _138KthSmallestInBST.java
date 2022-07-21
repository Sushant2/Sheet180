//Leetcode - 230 - Kth Smallest Element in a BST

//Naive approach
//do BFS/DFS/ traversal, store the elements in array/arraylist
//sort the arraylist
//return kth element from starting

//time comp - O(n*logn)
//space comp - O(n)

//Better approach 
//do inorder traversal, & store the inorder traversal in array/arraylist
//return kth smallest from starting

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

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        return inorder.get(k - 1);
    }
}


// Most optimised approach
// using morris traversal

// time comp - O(n)
// space comp - O(1)

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // using morris traversal
        int ans = 0;
        TreeNode curr = root;
        while (curr != null) {
            // if left does not exists
            if (curr.left == null) {
                k--;
                if (k == 0)
                    ans = curr.val;
                curr = curr.right;
            } else {
                // if left exists, find inorder predecessor of the node
                TreeNode iop = curr.left;
                while (iop.right != null && iop.right != curr)
                    iop = iop.right;

                // if left is not processed
                if (iop.right == null) {
                    iop.right = curr;
                    curr = curr.left;
                } else {
                    k--;
                    if (k == 0)
                        ans = curr.val;
                    iop.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}