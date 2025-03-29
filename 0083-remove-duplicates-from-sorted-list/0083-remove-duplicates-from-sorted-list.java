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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode answer = head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode nextNode = head.next;
        while(nextNode != null) {
            if(set.add(nextNode.val)) {
                head.next = nextNode;
                head = head.next;
                nextNode = head.next;
            }
            else
                nextNode = nextNode.next;
        }
        head.next = null;
        return answer;
    }
}