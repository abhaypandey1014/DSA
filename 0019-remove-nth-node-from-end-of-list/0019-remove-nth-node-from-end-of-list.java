class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int c = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            c++;
        }
        int len = c-n;
        int x = 1;
        temp = head;
        if(head==null || head.next==null) return null;
        if(c!=n){
        while(x!=len){
            temp = temp.next;
            x++;
        }
        temp.next = temp.next.next;
        }
        else{
            return temp.next;
        }
        return head;
    }
}