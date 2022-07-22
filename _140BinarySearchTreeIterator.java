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


//using stack

//time comp - O(1) on average
//space comp - O(h)

class BSTIterator {
    private Stack<TreeNode> stk = new Stack<>();

    private void pushAll(TreeNode root) {
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode top = stk.pop();
        pushAll(top.right);
        return top.val;
    }

    public boolean hasNext() {
        return !stk.isEmpty();
    }
}
