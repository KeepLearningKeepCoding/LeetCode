import java.util.HashMap;
import java.util.Map;

public class Solution138 {
    public Node copyRandomList(Node head) {
        Node headNode = new Node(-1);
        Node p = head, q = headNode;
        Map<Node, Node> map = new HashMap<>();
        while (p != null) {
            q.next = new Node(p.val);
            q = q.next;
            map.put(p, q);
            p = p.next;
        }
        
        p = head;
        q = headNode.next;
        while (p != null) {
            if (p.random == null) {
                q.random = null;
            } else {
                q.random = map.get(p.random);
            }
            p = p.next;
            q = q.next;
        }
        return headNode.next;
    }
}
