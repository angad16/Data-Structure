class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class IsArrayBST {
    Node root1 = null;
    boolean isValidBST(Node root, int min, int max) {
        if(root == null) return true;

        if(root.data < min || root.data > max) return false;

        return isValidBST(root.left, min, root.data-1) &&
                isValidBST(root.right, root.data+1, max);
    }
    boolean check(int arr[]){
        root1 = new Node(arr[0]);
        Node root = root1;
        for(int i = 1; i < arr.length; i++) {
            if(root.data > arr[i]) {
                root.left = new Node(arr[i]);
                root = root.left;
            }
            else{
                root.right = new Node(arr[i]);
                root = root.right;
            }
        }
        return isValidBST(root1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        IsArrayBST obj = new IsArrayBST();
        int arr[] = new int[]{2,4,1};
        System.out.println(obj.check(arr));
    }

}