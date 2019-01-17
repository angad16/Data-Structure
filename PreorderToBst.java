class Index{
    int index = 0;
}
public class PreorderToBst{
    
    Index ind = new Index();
    class Node{
        int data;
        Node right, left;

        public Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    Node convertUtil(int pre[], int size, int d, Index ind, int min, int max) {
    
        if(ind.index >= size)
        return null;
        
        Node root = null;
        if(d > min && d < max) {
            root = new Node(d);
            ind.index = ind.index + 1;
            if(ind.index < size) {
                root.left = convertUtil(pre, size, pre[ind.index], ind, min, d);
            
                root.right = convertUtil(pre, size, pre[ind.index], ind, d ,max);
            }
        }
        return root;
    }
    Node convert(int pre[], int size){
        return convertUtil(pre, size, pre[0], ind, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    void Inorder(Node root){
        if(root == null){
            return ;
        }
        Inorder(root.left);
        System.out.println(root.data + " ");
        Inorder(root.right);
    }

    public static void main(String[] args) {
        PreorderToBst obj = new PreorderToBst();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root1 = obj.convert(pre, size);
        obj.Inorder(root1);
    }
}