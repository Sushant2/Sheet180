//Leetcode - 987 Vertical Order Traversal Of A Binary Tree

//Using hashmap & priority queue - comparable

//time comp - O(n*log(n))
//space comp - O(n)

class Solution {
    private class Pair implements Comparable<Pair>{
        TreeNode node;
        int verLevel;
        int horLevel;
        Pair(TreeNode node, int verLevel, int horLevel){
            this.node = node;
            this.verLevel = verLevel;
            this.horLevel = horLevel;
        }
        public int compareTo(Pair other){
            if(this.horLevel == other.horLevel){
                return this.node.val - other.node.val;
            }else{
                return this.horLevel - other.horLevel;
            }
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        
        HashMap<Integer, PriorityQueue<Pair>> map = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        
        q.add(new Pair(root, 0, 1));
        
        int minVL = 0, maxVL = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
  
            Pair p = q.remove();
            
            
            if(p.verLevel < minVL)
                minVL = p.verLevel;
            if(p.verLevel > maxVL)
                maxVL = p.verLevel;

            if(map.containsKey(p.verLevel)==false){
                map.put(p.verLevel, new PriorityQueue<>());
                map.get(p.verLevel).add(p);
            }else{
                map.get(p.verLevel).add(p);
            }


            if(p.node.left!=null)
                q.add(new Pair(p.node.left, p.verLevel-1, p.horLevel+1));
            if(p.node.right!=null)
                q.add(new Pair(p.node.right, p.verLevel+1, p.horLevel+1));
    
        }
        
        for(int i = minVL;i<=maxVL;i++){
            List<Integer> list = new ArrayList<>();
            PriorityQueue<Pair> pq = map.get(i);
            while(!pq.isEmpty()){
                list.add(pq.remove().node.val);
            }
            ans.add(list);
        }
       return ans; 
    }
}


//Another solution  - same as above just using arraylist istead of priority queue & later sorting

class Solution {
    private class Pair implements Comparable<Pair> {
        TreeNode node;
        int verLevel;
        int horLevel;

        Pair(TreeNode node, int verLevel, int horLevel) {
            this.node = node;
            this.verLevel = verLevel;
            this.horLevel = horLevel;
        }

        public int compareTo(Pair other) {
            if (this.horLevel == other.horLevel) {
                return this.node.val - other.node.val;
            } else {
                return this.horLevel - other.horLevel;
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();

        q.add(new Pair(root, 0, 0));

        int minVL = 0, maxVL = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            Pair p = q.remove();

            if (p.verLevel < minVL)
                minVL = p.verLevel;
            if (p.verLevel > maxVL)
                maxVL = p.verLevel;

            if (map.containsKey(p.verLevel) == false) {
                map.put(p.verLevel, new ArrayList<>());
                map.get(p.verLevel).add(p);
            } else {
                map.get(p.verLevel).add(p);
            }

            if (p.node.left != null)
                q.add(new Pair(p.node.left, p.verLevel - 1, p.horLevel + 1));
            if (p.node.right != null)
                q.add(new Pair(p.node.right, p.verLevel + 1, p.horLevel + 1));

        }

        for (int i = minVL; i <= maxVL; i++) {
            List<Integer> list = new ArrayList<>();
            ArrayList<Pair> unsortedList = map.get(i);
            Collections.sort(unsortedList);
            for (Pair x : unsortedList) {
                list.add(x.node.val);
            }
            ans.add(list);
        }
        return ans;
    }
}