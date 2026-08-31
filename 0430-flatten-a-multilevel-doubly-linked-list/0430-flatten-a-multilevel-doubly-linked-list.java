/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node child = curr.child;
                Node next = curr.next;
                // Connect curr with child
                curr.next = child;
                child.prev = curr;
                // Find the end of child list
                Node temp = child;
                while (temp.next != null) {
                    temp = temp.next;
                }
                // Connect child list with original next
                temp.next = next;
                if (next != null) {
                    next.prev = temp;
                }
                // Remove child
                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }
}