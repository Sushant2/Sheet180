//GFG - Bottom View of Binary Tree

class Solution {
    // Function to return a list containing the bottom view of the given tree.
    private class Pair {
        Node node;
        int vVal = 0;

        Pair(Node node, int vVal) {
            this.node = node;
            this.vVal = vVal;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        int minvVal = 0, maxvVal = 0;
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair p = q.remove();
                // update min vVal & max vVal
                if (p.vVal < minvVal)
                    minvVal = p.vVal;
                if (p.vVal > maxvVal)
                    maxvVal = p.vVal;
                // update the node at corresponding vVal to get the last node
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