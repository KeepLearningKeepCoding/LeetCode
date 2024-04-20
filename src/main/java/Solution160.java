public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1 = getLength(headA);
        int length2 = getLength(headB);
        ListNode fast, slow;
        int diff;
        if (length1 > length2) {
            fast = headA;
            slow = headB;
            diff = length1 - length2;
        } else {
            fast = headB;
            slow = headA;
            diff = length2 - length1;
        }

        while (diff > 0) {
            fast = fast.next;
            diff--;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
