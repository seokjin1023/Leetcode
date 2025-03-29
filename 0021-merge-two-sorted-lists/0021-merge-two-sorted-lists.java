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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode firstNode = root;
        while(list1 != null || list2 != null) {
            if(list1 == null) {
                root.next = list2;
                root = root.next;
                list2 = list2.next;
            }
            else if(list2 == null) {
                root.next = list1;
                root = root.next;
                list1 = list1.next;
            }
            else {
                if(list1.val > list2.val) {
                    root.next = list2;
                    root = root.next;
                    list2 = list2.next;
                }
                else {
                    root.next = list1;
                    root = root.next;
                    list1 = list1.next;
                }
            }
        }
        return firstNode.next;
    }
}