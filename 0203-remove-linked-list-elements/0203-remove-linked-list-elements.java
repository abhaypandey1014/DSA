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
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;
        ListNode ans = new ListNode(-1);
        ListNode prev = ans;
        while(temp!=null){
            if(temp.val == val){
                temp = temp.next;
            }
            else{
            prev.next = temp;
            temp = temp.next;
            prev = prev.next;
            }
        } 
        prev.next =  null;
        return ans.next;
    }
}