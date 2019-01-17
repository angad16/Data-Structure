import java.util.Queue;
import java.util.LinkedList;
//import sun.misc.Queue;

public class lcabst 
{
   private  Node root = null;

   public void add1(int d)
   {
       root = add1(root, d);
   }
   public Node add1(Node root, int d)
   {
 
       if(root == null) {
           root = new Node(d);
           return root;
       }
        if(root.data > d)
            root.left = add1(root.left, d);
        else
            root.right = add1(root.right, d);

        return root;
    }
    
    
    public Node findlca(Node root, int a, int b)
    {
        if(root == null)
        return null;

        if(root.data > a && root.data > b)
            return findlca(root.left, a, b);
        if(root.data < a && root.data < b)
            return findlca(root.right, a, b);
        else
            return root ;
    }
    public int findlca(int a, int b)
    {        
        Node lc = findlca(root, a, b);
        return lc.data;
    }
    public void print()
    {
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(root);
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            System.out.print(temp.data +" ");
            if(temp.left != null)
                q.add(temp.left);
            if(temp.right != null)
                q.add(temp.right);

        }
        System.out.println();
    }
   private class Node{
       int data;
       Node left;
       Node right;

       Node(int d)
       {
           data = d;
           left = null;
           right = null;
       }
   }
   public static void main(String[] args) {
       lcabst l = new lcabst();
       l.add1(5);
       l.add1(3);
       l.add1(6);
       l.add1(2);
       l.add1(4);
       l.print();

      int t = l.findlca(3,2);
      System.out.println(t);
   }
}