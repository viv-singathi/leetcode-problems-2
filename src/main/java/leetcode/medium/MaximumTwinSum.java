package leetcode.medium;

public class MaximumTwinSum {
    //problem:In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
    //The twin sum is defined as the sum of a node and its twin.
    //Given the head of a linked list with even length, return the maximum twin sum of the linked list.
    public static void main(String[] args) {
        ListNode h = new ListNode(5);
        h.next = new ListNode(4);
        h.next.next = new ListNode(2);
        h.next.next.next = new ListNode(1);

        System.out.println(pairSum(h)); //output: 6
    }

    public static int pairSum(ListNode head) {
        int max = 0;
        int len = 0;
        ListNode current = head;

        while (current != null){
            len++;
            current = current.next;
        }

        ListNode prev = head;
        ListNode twin = head.next;
        prev.next = null;

        for (int i = 0; i < len/2 - 1; i++){
            ListNode next = twin.next;
            twin.next = prev;
            prev = twin;
            twin = next;
        }

        current = prev;

        for (int i = 0; i < len/2; i++){

            if (current.val + twin.val > max){
                max = current.val + twin.val;
            }

            twin = twin.next;
            current = current.next;
        }

        return max;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
