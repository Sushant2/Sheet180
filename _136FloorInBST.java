//Coding Ninjas - Floor in BST

//time comp - O(h)
//space comp - O(1)

public class Solution {
    public static int floorInBST(TreeNode<Integer> root, int key) {
        // Write your code here.
        int floor = 0;
        while (root != null) {
            if (root.data == key) {
                floor = root.data;
                return floor;
            }
            if (key < root.data)
                root = root.left;
            else {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}