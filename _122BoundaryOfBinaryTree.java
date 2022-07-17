//GFG/leetcode/LintCode - 878 - Boundary Of Binary Tree

//time comp - O(n) + O(n) + O(n) ≈ O(n)
//space comp - O(n)

public class Solution {
    /**
     * @param root: a TreeNode
     * @return: a list of integer
     */
    private boolean isLeaf(TreeNode node){
        return (node.left == null) && (node.right == null);
    }
    private void leftBoundary(TreeNode node, List<Integer> list){
        TreeNode curr = node;
        while(curr!=null){
            if(!isLeaf(curr)) 
                list.add(curr.val);
            if(curr.left!=null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }
    private void leafNodes(TreeNode node, List<Integer> list){
        if(isLeaf(node)){
            list.add(node.val);
            return;
        }
        if(node.left!=null)
            leafNodes(node.left, list);
        if(node.right!=null)
            leafNodes(node.right, list);
    }
    private void rightBoundary(TreeNode node, List<Integer> list){
        //we've to put it in reverseOrder
        List<Integer> tempList = new ArrayList<>();
        TreeNode curr = node;
        while(curr!=null){
            if(!isLeaf(curr))
                tempList.add(curr.val);
            if(curr.right!=null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        //put the tempList in reverseOrder into list
        for(int i = tempList.size()-1;i>=0;i--){
            list.add(tempList.get(i));
        }
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        //if root is not a leaf node
        if(!isLeaf(root)) 
            list.add(root.val);
        leftBoundary(root.left, list);
        leafNodes(root, list);
        rightBoundary(root.right, list);
        return list;
    }
}