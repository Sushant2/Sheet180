//leetcode - 1008 - Construct Binary Search Tree from Preorder Traversal

//naive/brute force
//time comp - O(n^2)
//space comp - O(1)

class Solution {
    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end)
            return null;

        TreeNode root = new TreeNode(preorder[start]);

        // find the index first node of right child
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > root.val)
                break;
        }

        root.left = helper(preorder, start + 1, i - 1);
        root.right = helper(preorder, i, end);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }
}


//better approach
//time comp - O(n*logn)
//space comp - O(n) + O(n) ~ O(n)


class Solution {
    private TreeNode constructBST(int[] preorder, int preStart, int preEnd,
            int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> inMap) {

        // base case
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inMap.get(root.val);
        // no. of nodes to be in left subtree
        int numsLeft = inRoot - inStart;

        root.left = constructBST(preorder, preStart + 1, preStart + numsLeft,
                inorder, inStart, inRoot - 1, inMap);
        root.right = constructBST(preorder, preStart + numsLeft + 1, preEnd,
                inorder, inRoot + 1, inEnd, inMap);

        return root;

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        // we know to construct a BST, we'll need preorder & inorder too!
        // we know inorder of BST is sorted in ascending order, so, we'll sort the given
        // array & store into "inorder" array
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);

        // hashmap to store inorder
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);

        return constructBST(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, inMap);
    }
}