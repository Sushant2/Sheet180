//Leetcode - 133 - Clone a graph

//using DFS
//time comp - O(E.V)
//E - for all edges, C - for all vertices
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