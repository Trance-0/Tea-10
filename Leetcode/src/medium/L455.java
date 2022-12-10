package medium;

public class L455 {
    public class ListNode {
           int val;
           ListNode next;
           ListNode() {}
           ListNode(int val) { this.val = val; }
           ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse two nodes and add them from bottom to top
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        boolean carry = false;
        while (l1 != null || l2 != null) {
            // find value for l1 and l2, if null then set to zero.
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            // get sum of two nodes 
            int sum = x + y + (carry ? 1:0);
            // get value of next list node
            ListNode node = new ListNode(sum % 10);
            // find carry of the current sum.
            carry = sum>9;
            // add node to result.
            curr.next = node;
            // set current to next.
            curr = curr.next;
            // set l1 l2 to next.
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // if there is carry left over.
        if (carry) {
            ListNode node = new ListNode(1);
            curr.next = node;
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = null;
        ListNode prev = dummy;
        while (head != null) {
            // reverse the direction of ListNode
            ListNode temp = head.next;
            // set head's next node to previous node.
            head.next = prev;
            // set previous node for next iteration to head.
            prev = head;
            // set head to orginal head's next node.
            head = temp;
        }
        return prev;
    }
}
