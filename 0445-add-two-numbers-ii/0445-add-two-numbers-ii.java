class Solution {
    public static ListNode rev(ListNode l) {
        ListNode prev = null;
        ListNode curr = l;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = rev(l1);
        ListNode temp2 = rev(l2);
        ListNode temp = new ListNode(-1);
        ListNode dummy = temp;
        int total = 0;
        int carry = 0;
        while (temp1 != null || temp2 != null) {
            total = carry;
            if (temp1 != null) {
                total = total + temp1.val;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                total = total + temp2.val;
                temp2 = temp2.next;
            }
            int num = total % 10;
            carry = total / 10;
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }
        if (carry != 0) {
            dummy.next = new ListNode(carry);
        }
        return rev(temp.next);
    }
}

