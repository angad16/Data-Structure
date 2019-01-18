public class SegregateEvenOddNodes {
    Node head;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node segregate(Node head) {

        Node curr = head;
        Node end = head;
        Node prev = null;

        while(end.next != null) {
            end = end.next;
        }

        Node new_end = end;

        while(curr.data % 2 != 0 && curr != end) {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }

        if(curr.data % 2 == 0 ) {
            head = curr;
            while(curr != end) {
                if(curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                }
                else {
                    prev.next = curr.next;
                    curr.next = null;
                    new_end.next = curr;
                    new_end = curr;
                    curr = prev.next;
                }
            }
        }
        else {
            prev = curr;
        }

        if(new_end != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }
        return head;
    }

    void print(Node root) {
        Node temp = root;
        while(temp != null) {
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
    }
    public  static void main(String[] args) {
        SegregateEvenOddNodes obj = new SegregateEvenOddNodes();
        obj.head = obj.new Node(1);
        obj.head.next = obj.new Node(2);
        obj.head.next.next = obj.new Node(4);
        obj.head.next.next.next = obj.new Node(9);
        obj.head.next.next.next.next = obj.new Node(5);
        obj.head.next.next.next.next.next = obj.new Node(6);
        obj.head.next.next.next.next.next.next = obj.new Node(13);
        obj.print(obj.head);
        obj.head = obj.segregate(obj.head);
        obj.print(obj.head);
        //javac SegregsteEvenOddNode.java   
    }
}