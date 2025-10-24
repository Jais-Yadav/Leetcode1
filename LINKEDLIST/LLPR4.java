// Sort a LL of 0's 1's and 2's

class ListNode {
    int val;
    ListNode next;

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

public class LLPR4 {
     public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode zero=new ListNode(-1);
        ListNode one=new ListNode(-1);
        ListNode two=new ListNode(-1);
        ListNode temp=head;
        ListNode zerohead=zero;
        ListNode onehead=one;
        ListNode twohead=two;
        ListNode newHead=zerohead.next;
        while(temp!=null){
            if(temp.val==0){
                zero.next=temp;
                zero=temp; // zero ko aage badhao
            }else if(temp.val==1){
                one.next=temp;
                one=temp; // one ko aage badhao
            }else{
                two.next=temp;
                two=temp; // two ko aage badhao
            }
            temp=temp.next;
        }
        zero.next=onehead.next;
        one.next=twohead.next;
        two.next=null;
        return newHead;


    }
    
}
