public class InvertBinaryTree
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
    InvertBinaryTree() {
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
    
    public void invert() {
        root = invert(root);
    }
    
    public Node invert(Node root) {
        if (root == null) return null;
        
        Node left = invert(root.left);
        Node right = invert(root.right);
        root.left = right;
        root.right = left;
        
        return root;
    }
    
    public void preorder() {
        preorder(root);
    }
    public void preorder(Node root) {
        if (root == null) return;
        
        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);
    }
	
	public static void main(String[] args) {
	    InvertBinaryTree obj = new InvertBinaryTree();
	    //           10                        10
	    //       5      11      --->     11         5
      //     3   9       15 	     15         9        3     
      int arr[] = {10, 5, 3, 9, 11, 15};
      for (int i = 0; i < arr.length; i++) {
          obj.insert(arr[i]);
      }
      obj.preorder();
      obj.invert();
      System.out.println();
      obj.preorder();
	}
}
