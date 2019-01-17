public class avl 
{
    Node root;  

    private class Node
    { 
        int data;
        Node left;
        Node right;
        int height;

        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
            height = 1;
        }
    }

    int height(Node x) 
    {   
        return (x != null) ? x.height : 0;
    }


    int max(int a, int b) 
    {
        return (a > b) ? a : b;
    }


    int getBalance(Node root) 
    {
        return height(root.left) - height(root.right);
    }

    Node rightRotate(Node x) 
    {
        Node y = x.left;
        Node t2 = y.right;
        y.right = x;
        x.left = t2;
        return y;
    }

    Node leftRotate(Node x) 
    {
        Node y = x.right;
        Node t2 = y.left;
        y.left = x;
        x.right = t2;
        return y;
    }

    Node insert(Node root, int data) 
    {
        if(root == null) 
        {
            Node nn = new Node(data);
            return nn;
        }
        if(root.data > data) 
        {
            root.left = insert(root.left,data);
        }
        if(root.data < data)
        { 
            root.right = insert(root.right,data);
        }

        root.height = max(height(root.left),height(root.right)) +1;

        if(getBalance(root) >1) 
        {
            if(getBalance(root.left) >= 1) 
            {   
                return rightRotate(root);
            }
            else
            {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }
        else if(getBalance(root) <-1) 
        {
            if(getBalance(root.right) <= 1) 
            {
                return leftRotate(root);
            }
            else 
            {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }
        return root;
    }

    void display(Node root) 
    {
        if(root == null)
            return ;

        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }

    public static void main(String[] args) 
    {
        avl a = new avl();
        a.root = null;
          
        a.root = a.insert(a.root,5);
        a.root = a.insert(a.root,3);
        a.root = a.insert(a.root,6);
        a.root = a.insert(a.root,2);
        a.root = a.insert(a.root,4);
        a.root = a.insert(a.root,1);
        a.root = a.insert(a.root,3);
             
        a.display(a.root);
    }
}