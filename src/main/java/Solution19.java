public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headNode = new ListNode(-1, head);
        ListNode pre = headNode, fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        return headNode.next;
    }
}
