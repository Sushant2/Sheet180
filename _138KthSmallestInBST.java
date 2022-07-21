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