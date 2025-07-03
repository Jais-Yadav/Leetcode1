// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

// Do not modify the linked list // inshort find the starting point of ll loop

class Node {
    int val;
    Node next;

    Node() {}

    Node(int val){ this.val = val; }

    Node(int val, Node next) { this.val = val; 
        this.next = next; }
}

public class LLPR3 {
        public Node detectCycle(Node head) {
        //using tortoise algorithm
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){ // it means a loop is there
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
