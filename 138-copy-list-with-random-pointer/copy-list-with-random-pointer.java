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
        insertInBetween(head);
        connectRandom(head);
        return connectNext(head);
    }

    public void insertInBetween(Node head){
        Node temp = head;
        while(temp != null){
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
    }

    public void connectRandom(Node head){
        Node temp = head;
        while(temp != null){
            Node copyNode = temp.next;
            if(temp.random != null){
                copyNode.random = temp.random.next;
            }
            else{
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
    }

    public Node connectNext(Node head){
        Node dNode = new Node(-1);
        Node res = dNode;
        Node temp = head;
        while(temp != null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dNode.next;
    }
}