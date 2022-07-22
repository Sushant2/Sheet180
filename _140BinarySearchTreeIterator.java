//Leetcode - 173 - Binary Search Tree Iterator

//time comp - O(1)
//space comp - O(n) to store inorder into arraylist

class BSTIterator {
    ArrayList<Integer> list;
    int count = 0;

    private void getInorder(TreeNode root) {
        if (root == null)
            return;

        getInorder(root.left);
        list.add(root.val);
        getInorder(root.right);
    }

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        getInorder(root);
    }

    public int next() {
        return list.get(count++);
    }

    public boolean hasNext() {
        if (count == list.size())
            return false;
        else
            return true;
    }
}