// Given head, the head of a linked list, determine if the linked list has a cycle in it.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

// Return true if there is a cycle in the linked list. Otherwise, return false.
// detect the loop in the linked list;
class Node {
    int val;
    Node next;

    Node() {}

    Node(int val){ this.val = val; }

    Node(int val, Node next) { this.val = val; 
        this.next = next; }
}

public class LLPR2 {
        public boolean hasCycle(Node head) {
        //Tortoise method
        Node slow=head;
        Node faster=head;
        while(faster!=null && faster.next!=null){
            slow=slow.next;
            faster=faster.next.next;
            if(slow==faster) return true;
        }
        return false;
    }
    
}
