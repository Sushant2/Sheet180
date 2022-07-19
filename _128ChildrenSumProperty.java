//Coding Ninjas - Children Sum property

//time comp - O(n)
//space comp - O(1)

public class Solution {
    public static void changeTree(BinaryTreeNode<Integer> root) {
        // Write your code here.
        if (root == null)
            return;
        int child = 0;
        if (root.left != null)
            child += root.left.data;
        if (root.right != null)
            child += root.right.data;

        if (child < root.data) {
            if (root.left != null)
                root.left.data = root.data;
            if (root.right != null)
                root.right.data = root.data;
        }
        if (child >= root.data)
            root.data = child;

        changeTree(root.left);
        changeTree(root.right);
        int newTotal = 0;
        if (root.left != null)
            newTotal += root.left.data;
        if (root.right != null)
            newTotal += root.right.data;
        // that should noe be a leaf node
        if (root.left != null || root.right != null)
            root.data = newTotal;
    }
}