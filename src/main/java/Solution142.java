public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
