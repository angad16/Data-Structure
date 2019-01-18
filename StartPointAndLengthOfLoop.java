public class StartPointAndLengthOfLoop {
    Node head;
    class Node {
        int data;
        Node next;
        public Nodme(int data) {
            this.data =data;
            this.next = null;
        }
    }
    void push(int data) {
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

    void startPoint() {
        Node slow = head, fast = head;
        int flag = 0;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                flag = 1;
                break;
            }
        }
        if(flag == 0) {
            System.out.println("No Loop present");
            return;
        }
        if(flag == 1) {
            slow = head;
        }
        while(slow != null && fast != null  && slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println("Statrting point of loop is " + slow.data + " ");
    }
    
    void length() {
        Node slow = head, fast = head;
        int count = 0;
    
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
      Node temp = slow;
        while(temp.next != slow) {
            
            count++;
            temp = temp.next;
        }
        count++;
        System.out.println("length of loop is " + count);
    }

    public static void main(String[] args) {
        StartPointAndLengthOfLoop obj = new StartPointAndLengthOfLoop();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.head.next.next.next.next.next = obj.head.next; // loop at node with value 2 
        obj.startPoint();
        obj.length();
    }
}