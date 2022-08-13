//Leetcode - 133 - Clone a graph

//using DFS
//time comp - O(E.V)
//E - for all edges, C - for all vertices
//space comp - O(V) - recursions tack space
// (fully connected graph)

class Solution {
    private void dfsTrav(Node node, Node copyN, Node[] vis){
        vis[copyN.val] = copyN;
        for(Node n : node.neighbors){
            if(vis[n.val] == null){
                Node newCopyN = new Node(n.val);
                copyN.neighbors.add(newCopyN);
                dfsTrav(n, newCopyN, vis);
            }else{
                copyN.neighbors.add(vis[n.val]);
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Node[] vis = new Node[101]; //bydefault initialsed with null values
        Node copyN = new Node(node.val);
        dfsTrav(node, copyN, vis);
        return copyN;
    }
}


//using BFS
//time comp - O(E.V)
//E - for all edges, C - for all vertices
//space comp - O(V) - queue + O(101) - constant - visited array

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Node[] vis = new Node[101]; //bydefault initialsed with null values
        Deque<Node> q = new ArrayDeque<>();
        Node copyN = new Node(node.val);
        vis[copyN.val] = copyN;
        q.add(node);
        while(!q.isEmpty()){
            Node currN = q.poll();
            for(Node n : currN.neighbors){
                if(vis[n.val] == null){
                    Node newNode = new Node(n.val);
                    vis[n.val] = newNode;
                    q.add(n);
                }
                vis[currN.val].neighbors.add(vis[n.val]);
            }
        }
        
        return copyN;
    }
}