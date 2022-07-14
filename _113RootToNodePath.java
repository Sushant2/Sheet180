//InterviewBit - Path to given node

//simple dfs traversal

//time comp - O(n)
//space comp - O(n)

public class Solution {
    private boolean getRootToNode(TreeNode root, int data, ArrayList<Integer> list) {
        if (root == null)
            return false;
        list.add(root.val);
        if (root.val == data)
            return true;

        boolean leftChild = getRootToNode(root.left, data, list);
        if (leftChild)
            return true;
        boolean rightChild = getRootToNode(root.right, data, list);
        if (rightChild)
            return true;

        list.remove(list.size() - 1);

        return false;
    }

    public int[] solve(TreeNode A, int B) {
        if (A == null)
            return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        getRootToNode(A, B, list);
        int[] path = new int[list.size()];
        int i = 0;
        for (int x : list)
            path[i++] = x;
        return path;
    }
}