//Pepcoding/Coding Ninja - Preorder inorder postorder in a single traversal

//time comp - o(n)
//space comp - o(n)

public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
        this.node = node;
        this.state = state;
    }

}

public static void iterativePrePostInTraversal(Node node) {
    String pre = "";
    String in = "";
    String post = "";

    Stack<Pair> stk = new Stack<>();
    stk.push(new Pair(node, 1));
    while(!stk.isEmpty()){
        Pair p = stk.peek();
        if(p.state == 1){
        //pre order
        pre = pre + p.node.data +" ";
        if(p.node.left!=null)
            stk.push(new Pair(p.node.left, 1));
        p.state++;
        }else if(p.state == 2){
        //in order
        in = in + p.node.data + " ";
        if(p.node.right!=null)
            stk.push(new Pair(p.node.right, 1));
        p.state++;
        }else{
        //post order
        post = post + p.node.data + " ";
        stk.pop();
        }
    }
    System.out.println(pre);
    System.out.println(in);
    System.out.println(post);
}
