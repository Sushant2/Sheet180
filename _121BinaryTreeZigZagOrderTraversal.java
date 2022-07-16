//Leetcode - 103 - Binary Tree Zigzag Level Order Traversal

//Approach 1 
//time comp - O(n)
//space comp - O(n)


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        
        boolean leftToRight = false;
        //false - left to right
        //true - right to left
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode node = q.remove();
                list.add(node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            if(leftToRight)
                Collections.reverse(list);

            ans.add(list);

            leftToRight = !leftToRight;
        }
        return ans;
    }
}