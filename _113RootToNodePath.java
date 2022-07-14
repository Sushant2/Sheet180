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


//Pepcoding - Node to root path

class Solution {
    private static boolean getPath(Node root, int target, ArrayList<Integer> list) {
        if (root == null)
            return false;
        if (root.data == target){
            list.add(root.data);
            return true;
        }
        boolean left = getPath(root.left, target, list);
        if (left) {
            list.add(root.data);
            return true;
        }

        boolean right = getPath(root.right, target, list);
        if (right) {
            list.add(root.data);
            return true;
        }
        return false;
    }

    public static ArrayList<Integer> nodeToRoot(Node root, int target) {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        getPath(root, target, ans);
        return ans;
    }
}