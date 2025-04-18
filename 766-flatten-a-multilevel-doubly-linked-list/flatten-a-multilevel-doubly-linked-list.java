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
        if(head==null)  return head;

        flattenChild(head);
        return head;
    }

    public Node flattenChild(Node node){
        Node curr = node;
        Node last = null;
        while(curr != null){
            Node next = curr.next;
            if(curr.child!=null){
                Node child = curr.child;
                Node childTail = flattenChild(child);

                curr.next = child;
                child.prev = curr;

                if(next!=null){
                    childTail.next = next;
                    next.prev = childTail;
                }
                curr.child = null;
                last = childTail;
            } else{
                last = curr;
            }
            curr = next;
        }
        return last;
    }
}