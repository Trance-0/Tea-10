package medium;

public class L142_1 {
    // this is a magical dual pointer problem
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        //fast moves two steps per cycle
        ListNode fast=head;
        //slow moves one steps per cycle

        //no matter how long the cycle is, the two point will eventually meet after certain steps
        // where as the 2*(length of pointer traveled before cycle + length of pointer traveled in the cycle) - (length of pointer traveled before cycle + length of pointer traveled in the cycle) = numerous chasing * length of cycle
        ListNode slow=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            // when two pointer meet
            if(slow == fast)
            break;
        } 
        if (fast==null||fast.next==null)  
        return null;
        while (head!=slow){
            head=head.next;
            slow=slow.next;
        }
        return head;
    }
}
