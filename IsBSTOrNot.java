

public class IsBSTOrNot{
    
    class Node{
        int data;
        Node right;
        Node left;
    
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        } 
    }
    public Node root;
    boolean isBSTutil(Node root, int min, int max) {
        if(root == null) 
        return true;
         
        if(root.data < min || root.data >max)
        return false;

        return isBSTutil(root.left, min, root.data-1)
                && isBSTutil(root.right, root.data+1, max);
    }
    boolean isBST() {
        return isBSTutil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static void main(String[] args) {
        IsBSTOrNot obj = new IsBSTOrNot();
        obj.root = obj.new Node(4);
        obj.root.left = obj.new Node(8);
        obj.root.right = obj.new Node(5);
        obj.root.left.left = obj.new Node(1);
        obj.root.left.right = obj.new Node(3);
        if(obj.isBST() == true){
            System.out.println("Is BST");
        }
        else{
            System.out.println("Not BST");
        }
    }
}