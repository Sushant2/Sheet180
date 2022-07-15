//Leetcode - 662 - Maximum Width of Binary Tree

//Using BFS - level order traversal
//time comp - O(n)
//space comp - O(n)

class Solution {
    public class Pair {
        TreeNode node;
        int idx;

        Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int maxWidth = 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int mini = q.peek().idx;
            int firstIdx = 0, lastIdx = 0;
            for (int i = 0; i < size; i++) {
                int currIdx = q.peek().idx - mini;
                TreeNode node = q.remove().node;
                if (i == 0)
                    firstIdx = currIdx;
                if (i == size - 1)
                    lastIdx = currIdx;
                if (node.left != null)
                    q.add(new Pair(node.left, 2 * currIdx + 1));
                if (node.right != null)
                    q.add(new Pair(node.right, 2 * currIdx + 2));
            }
            maxWidth = Math.max(maxWidth, lastIdx - firstIdx + 1);
        }
        return maxWidth;
    }
}


//Using DFS
//time comp - O(n)
//space comp - O(n)

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }

    private int dfs(TreeNode root, int level, int idx, List<Integer> start, List<Integer> end) {
        if (root == null)
            return 0;

        if (start.size() == level) {
            start.add(idx);
            end.add(idx);
        } else {
            end.set(level, idx);
        }
        idx -= start.get(level);
        int currWidth = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2 * idx, start, end);
        int right = dfs(root.right, level + 1, 2 * idx + 1, start, end);

        return Math.max(currWidth, Math.max(left, right));
    }
}