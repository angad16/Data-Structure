public class circumference
{
   private  class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int d)
        {
            data = d;
            left = null;
            right = null;
        }
    }
    public static Node root = null;

    /*public void add(int da)
    {
        root = add(root, da);
    }

    public Node add(Node root, int da)
    {
        if(root == null)
        {
            Node nn = new Node(da);
            return nn;
        }
        if(root.data > da)
        {
            root.left = new Node(da);
        }
        if(root.data < da)
        {
            root.right = new Node(da);
        }
        return root;
    }*/
    public void leftView(Node x)
    {
        if(x != null)
        {
            if(x.left != null)
            {
                System.out.println(x.data+" ");
                leftView(x.left);
            }
            else if(x.right != null)
            {
                System.out.println(x.data+" ");
                leftView(x.right);
            }
        }
    }
    public void printLeave(Node x)
    {
        if(x == null)
        {
            return ;
        }
        if(x != null)
        {
            printLeave(x.left);

            if(x.left == null && x.right == null)
            System.out.println(x.data+" ");

            printLeave(x.right);
        }
    }
    

    public void rightView(Node x)
    {
        if(x != null)
        {
            if(x.right != null)
            {
                System.out.println(x.data+" ");
                leftView(x.right);
            }
            else if(x.left != null)
            {
                System.out.println(x.data+" ");
                leftView(x.left);
            }
        }
    }
   
    public void circumferenceTree(Node root)
    {
        if(root != null)
        {
            System.out.println(root.data +" ");
            leftView(root.left);
            printLeave(root.left);
            printLeave(root.right);
            rightView(root.right);
        }
    }
   
    public static void main(String[] args)
    {
        circumference tree = new circumference();
       /* tree.add(20);
        tree.add(8);
        tree.add(4);
        tree.add(12);
        tree.add(10);
        tree.add(14);
        tree.add(22);
    
        tree.add(25);*/
       
        root = tree. new Node(20); 
        root.left = tree. new Node(8); 
        root.left.left = tree. new Node(4); 
        root.left.right = tree. new Node(12); 
        root.left.right.left = tree. new Node(10); 
        root.left.right.right = tree. new Node(14); 
        root.right = tree. new Node(22); 
        root.right.right = tree. new Node(25);
        
        tree.circumferenceTree(root);
    }
}