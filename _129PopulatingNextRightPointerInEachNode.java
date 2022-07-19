//Leetcode - 116 - Populating Next Right Pointers in Each Node

//uisng BFS - right to left
//time comp - O(n)
//space comp - O(width) = O(n)
//since the tree is perfect BTree, it's width is given as, width = (n+1)/2 ~ O(n)

class Solution {
    public Node connect(Node root) {
        // BFS - right to left
        if (root == null)
            return null;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node rightNode = null;
            while (size-- > 0) {
                Node curr = q.remove();
                curr.next = rightNode;
                rightNode = curr;

                // if right exist, no need to check left
                if (curr.right != null) {
                    q.add(curr.right);
                    q.add(curr.left);
                }
            }
        }
        return root;
    }
}