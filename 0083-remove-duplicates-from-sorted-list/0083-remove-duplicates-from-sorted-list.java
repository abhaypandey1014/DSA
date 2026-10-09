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
        ListNode prev = null;
        ListNode curr = head;
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        while(curr!=null){
            if(curr.next!=null&&curr.val!=curr.next.val){
                temp.next = curr;
                temp = temp.next;
                curr = curr.next;
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        temp.next = prev;
        return ans.next;
    }
}