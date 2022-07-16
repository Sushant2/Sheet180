//Leetcode - 103 - Binary Tree Zigzag Level Order Traversal

//Approach 1 BFS + collections.reverse
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

//Another approach - using 2 stacks
//time comp - O(n)
//space comp - O(n)

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //using 2 stacks
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        
        Stack<TreeNode> ms = new Stack<>();
        Stack<TreeNode> cs = new Stack<>();
        ms.push(root);
        int level = 1;
        List<Integer> list = new ArrayList<>();
        while(!ms.isEmpty()){
            TreeNode curr = ms.pop();
            list.add(curr.val);
            //odd levels 1,3,5...ke lie uske childrens(levels 2,4,6...) ko right to left add krna hai, to stack mein left to right push krenge!
            if(level%2 == 1){
                if(curr.left!=null)
                    cs.push(curr.left);
                if(curr.right!=null)
                    cs.push(curr.right);
            }else{

                if(curr.right!=null)
                    cs.push(curr.right);
                if(curr.left!=null)
                    cs.push(curr.left);
            }
            
            if(ms.size() == 0){
                ms = cs;
                ans.add(list);
                cs = new Stack<>();
                list = new ArrayList<>();
                level++;
                
            }
        }
        return ans;
    }
}

//Another approach - suing linkedlist + BFS
//time comp - O(n)
//space comp - O(n)

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // using BFS + linkedlist
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean leftToRight = false;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> list = new LinkedList<>();
            while (size-- > 0) {
                TreeNode node = q.remove();
                if (leftToRight)
                    list.addFirst(node.val);
                else
                    list.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            leftToRight = !leftToRight;
            ans.add(list);
        }
        return ans;
    }
}