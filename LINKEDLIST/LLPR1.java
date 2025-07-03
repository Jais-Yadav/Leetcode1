//Middle of the LinkedList



 class Node {
    int val;
    Node next;

    Node() {}

    Node(int val){ this.val = val; }

    Node(int val, Node next) { this.val = val; 
        this.next = next; }
}

public class LLPR1 {
    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        // tortoise algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
