public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode headNode = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = headNode.next;
            headNode.next = head;
            head = next;
        }
        return headNode.next;
    }
}
