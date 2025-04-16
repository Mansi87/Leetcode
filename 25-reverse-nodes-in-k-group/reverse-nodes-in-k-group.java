/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1)  return head;
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null){
            ListNode kthNode = findK(temp, k);
            if(kthNode == null){
                if(prevNode!=null)  prevNode.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            ListNode newHead = reverse(temp);
            if(temp==head){
                head = newHead;
            }
            else{
                prevNode.next = newHead;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    public ListNode reverse(ListNode temp){
        ListNode prev = null;
        while(temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public ListNode findK(ListNode node, int k){
        k--;
        while(node!=null && k>0){
            k--;
            node = node.next;
        }
        return node;
    }
}