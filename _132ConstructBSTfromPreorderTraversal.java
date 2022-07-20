//leetcode - 1008 - Construct Binary Search Tree from Preorder Traversal

//naive/poor approach
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