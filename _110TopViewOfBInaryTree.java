//GFG - Top view of binary tree

//time comp - O(n)
//space comp - O(n)

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    public static class Pair {
        Node node;
        int vVal;

        Pair(Node node, int vVal) {
            this.node = node;
            this.vVal = vVal;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        int minvVal = 0, maxvVal = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair p = q.remove();
                if (p.vVal < minvVal)
                    minvVal = p.vVal;
                if (p.vVal > maxvVal)
                    maxvVal = p.vVal;

                // update map once
                if (map.containsKey(p.vVal) == false)
                    map.put(p.vVal, p.node);
                if (p.node.left != null)
                    q.add(new Pair(p.node.left, p.vVal - 1));
                if (p.node.right != null)
                    q.add(new Pair(p.node.right, p.vVal + 1));
            }
        }
        for (int i = minvVal; i <= maxvVal; i++) {
            ans.add(map.get(i).data);
        }
        return ans;
    }
}