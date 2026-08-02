package leetcode.medium;

public class InsertGCDInLinkedList {
    //problem: Given the head of a linked list head, in which each node contains an integer value.
    //Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.
    //Return the linked list after insertion.
    //The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers
    public static void main(String[] args) {
        ListNode h = new ListNode(12, new ListNode(3));
        insertGreatestCommonDivisors(h);
        System.out.println(h.val + ", " + h.next.val + ", " + h.next.next.val); //output: 12, 3, 3
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null){return null;}
        ListNode current = head;

        while (current.next != null){
            current.next = new ListNode(gcd(current.val, current.next.val), current.next);
            current = current.next.next;
        }

        return head;
    }

    public static int gcd(int x, int y){
        if (y == 1){return 1;}
        if (x % y == 0) {return y;}
        return gcd(y, x % y);
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
