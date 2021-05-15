public class BSTInsertion
{
    public class Node {
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    BSTInsertion() {
        root = null;
    }
    
    public void insert(int data) {
        root = insert(root, data);
    }
    
    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        
        if (root.data > data) {
            root.left = insert(root.left, data);
        } else if (root.data < data) {
            root.right = insert(root.right, data);
        }
        return root;
    }
    
    public void inorder() {
        inorder(root);
    }
    public void inorder(Node root) {
        if (root == null) return;
        
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
	public static void main(String[] args) {
	    BSTInsertion obj = new BSTInsertion();
	    //           10
	    //       5      11
      //     3   9       15 	  
      int arr[] = {10, 5, 3, 9, 11, 15};
      for (int i = 0; i < arr.length; i++) {
          obj.insert(arr[i]);
      }
      obj.inorder();
	}
}
