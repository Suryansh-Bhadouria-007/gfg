package mock5.LinkedListNumSum;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      /*  int length1, length2;
        length1 = 0;
        length2 = 0;
        ListNode l1Temp = l1;
        ListNode l2Temp = l2;
        while (l1Temp != null) {
            length1++;
            l1Temp = l1Temp.next;
        }
        while (l2Temp != null) {
            length2++;
            l2Temp = l2Temp.next;
        }
        ListNode temp;
        //make sure l1 is longer than l2
        if (length1 < length2) {
            temp = l1;
            l1 = l2;
            l2 = temp;
        }
        int diff = length1 - length2;*/
        ListNode res = new ListNode(-1);
        int sum, carry = 0;
        ListNode head = res;
        while (l1 != null || l2 != null) {
            int i = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            sum = i % 10;
            carry = i / 10;
            res.next = new ListNode(sum);
            res = res.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry != 0) {
            res.next = new ListNode(carry);
        }
        return head.next;
    }
}