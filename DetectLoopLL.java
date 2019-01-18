public class DetectLoopLL {
    Node head;

    class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public void checkForLoop() {
        Node fast = head, slow = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                System.out.println("Loop present");
                return;
            }
        }
        System.out.println("Loop not present");

    }
    public void push(int data) {
       // add at end 1->2->3->4->5->null
        if(head == null) {
            head = new Node(data);
            return ;
             
        }   
        else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
            return;
        }     
    }

    public static void main(String[] args) {
        DetectLoopLL obj = new DetectLoopLL();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.head.next.next.next.next.next = obj.head.next.next; // code to create loop
        obj.checkForLoop();
    }
}