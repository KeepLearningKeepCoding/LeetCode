public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode headNode = new ListNode(-1, head);
        ListNode pre = headNode, p = head;
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
            } else {
                pre = p;
            }
            p = p.next;
        }
        return headNode.next;
    }
}
