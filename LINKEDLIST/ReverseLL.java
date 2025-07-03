

class Node {
    int val;
    Node next;

    Node() {}

    Node(int val){ this.val = val; }

    Node(int val, Node next) { this.val = val; 
        this.next = next; }
}


public class ReverseLL {
        public Node reverseList(Node head) {
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            Node front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
        
    }
    
}
