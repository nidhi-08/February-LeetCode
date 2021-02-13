/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node newhead = new Node(-1);
    Node current = newhead;
    Map<Node, Node> oldNewMap = new HashMap();
    
    while(head != null) {
        Node next = oldNewMap.computeIfAbsent(head, k -> new Node(k.val));
        next.next = head.next;
        next.random = head.random == null ? null : oldNewMap.computeIfAbsent(head.random, k -> new Node(k.val));
        current.next = next;
        current = current.next;
        head = head.next;
    }
    return newhead.next == null ? null : newhead.next;
    }
}
