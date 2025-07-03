
class Node {

    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

};

public class LinkedList {

    private static Node ConvertArr2ll(int[] arr) {
        Node Head = new Node(arr[0]);
        Node mover = Head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return Head;
    }

    public static int LengthOfll(Node head) {
        int count = 0;
        Node Temp = head;
        while (Temp != null) {
            count++;
            Temp = Temp.next;
        }
        return count;
    }

    public static boolean SearchElement(Node head, int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static Node removeHead(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        return head;
    }

    public static Node removeTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node Temp = head;
        if (Temp.next.next != null) {
            Temp = Temp.next;
        }
        Temp.next = null;
        return head;
    }

    public static Node removeElement(Node head, int k) {
        if (head == null) {
            return head;
        }
        if (k == 1) {
            Node temp = head;
            head = head.next;
            return head;
        }
        int count = 0;
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            count++;
            if (count == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
                while (temp != null) { //for traversal
            System.out.println(temp.data + " ");
            temp = temp.next;

        }
        Traverse(head);
        return head;
    }
    public static void Traverse(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data + " ");
            temp=temp.next;

        }
    }
    public static Node InsertHead(Node head,int val){
        Node value=new Node(val,head);

        return value;
    }
    public static Node InsertTail(Node head,int val){
        Node temp=head;
        Node value=new Node(val);
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=value;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        Node x = new Node(arr[2]);
        System.out.println(x.next);
        Node z = ConvertArr2ll(arr);
        System.out.println(z.next);
        Node temp = z;
        while (temp != null) { //for traversal
            System.out.println(temp.data + " ");
            temp = temp.next;

        }
        System.out.println("length of the LinkedList=" + LengthOfll(z));
        System.out.println(SearchElement(temp, 7));
        Node y = removeHead(z); // to remove the head of the linkedList
        System.out.println(y.data);
        Node w = removeTail(z); // to remove the tail of the linkedList
        System.out.println(w.data);
        Node q = removeElement(z, 2);
        System.out.println(q);
        Node a=InsertHead(temp, 9);
        System.out.println(a.data);
        Node b=InsertTail(z, 10);
        System.out.println(b.data);

    }

}
