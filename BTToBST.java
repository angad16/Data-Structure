import java.util.*;
public class BTToBST{
    public Node root;
    class Node{
        int data;
        Node right ,left;
        public Node(int data) {
            this.data =data;
            this.left = null;
            this.right = null;
        }
    }
    
    static int x = 0;
    void reverseProcess(Node root, ArrayList<Integer> al) {
        if(root == null) return ;

        reverseProcess(root.left, al);
        root.data = al.get(x++);
        reverseProcess(root.right, al);
    }

    void storeInorder(Node root, ArrayList<Integer> al){
        if(root == null)
        return ;

        storeInorder(root.left, al);
        al.add(root.data);
        storeInorder(root.right, al);
    }
    public void convertBTToBST() {
        ArrayList<Integer>al = new ArrayList<Integer>();
        
        storeInorder(root, al);
        System.out.println(al.size());
        Collections.sort(al);
        reverseProcess(root, al);
    }
    void inorderBST(Node root){
        if(root == null) return ;

        inorderBST(root.left);
        System.out.println(root.data + " ");
        inorderBST(root.right);
    }
    public  static void main(String[] args) {
        BTToBST obj = new BTToBST();
        
        obj.root = obj.new Node(10);
        obj.root.left = obj.new Node(2);
        obj.root.right = obj.new Node(7);
        obj.root.left.right = obj.new Node(8);
        obj.root.left.right = obj.new Node(4);
        obj.convertBTToBST();
        obj.inorderBST(obj.root);
        

    }
}