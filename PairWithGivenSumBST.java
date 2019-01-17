import java.util.ArrayList;


class Node {
    int data;
    Node right, left;
    
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class PairWithGivenSumBST{
    Node root;

    Node insert(int data) {
        return insert(root, data);
    }
    Node insert(Node root ,int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }
        if(root.data > data) {
            root.left = insert(root.left, data);
        }
        else if(root.data < data) {
            root.right = insert(root.right, data);
        }
        else {
            return root;
        }
        return root;
    }
    boolean checkForPair(int pair) {
        ArrayList<Integer>al = new ArrayList<>();
        storeInList(root, al);
        int size = al.size();
        System.out.println(size);
        return findPair(al, size, pair);
    }

    boolean findPair(ArrayList<Integer>al, int size, int pair) {
        int l = 0, r = size - 1;
        while(l < r) {
           if(al.get(l) + al.get(r) == pair) {
               return true;
           }
           else if(al.get(l) + al.get(r) > pair) {
               r--;
           }
           else {
               l++;
           }
        }
        return false;
    }
    void print(){
        print(root);
    }
    void print(Node root) {
        if(root == null) return ;

        print(root.left);
        System.out.println(root.data + " ");
        print(root.right);
    }

    void storeInList(Node root, ArrayList<Integer>al) {
        if(root == null) return;
        storeInList(root.left, al);
        al.add(root.data);
        storeInList(root.right, al);
    }
    public static void main(String[] args) {
        PairWithGivenSumBST obj = new PairWithGivenSumBST();
        for(int i = 1; i < 8; i++) {
           obj.root =  obj.insert(i);
        }
        obj.print();
        System.out.println(obj.checkForPair(8));
    }
}