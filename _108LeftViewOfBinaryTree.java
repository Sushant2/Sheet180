//GFG - Left View Of Binary Tree

//time comp - O(n)
//space comp - O(n)


class Tree {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            ans.add(q.peek().data);
            int size = q.size();
            while (size-- > 0) {
                Node node = q.remove();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }
        return ans;
    }
}