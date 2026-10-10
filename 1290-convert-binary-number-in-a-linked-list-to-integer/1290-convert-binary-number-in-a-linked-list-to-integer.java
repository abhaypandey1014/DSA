class Solution {
    public static ListNode rev(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public int getDecimalValue(ListNode head){
        ListNode curr = rev(head);
        int count = 0;
        int ans = 0;
        while(curr != null){
            ans = ans+curr.val*(int)Math.pow(2,count);
            count++;
            curr = curr.next;
        }
        return ans;
    }
}