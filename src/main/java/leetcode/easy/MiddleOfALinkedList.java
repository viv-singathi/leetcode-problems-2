package leetcode.easy;

public class MiddleOfALinkedList {
    //problem: Given the head of a singly linked list, return the middle node of the linked list.
    //If there are two middle nodes, return the second middle node.

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);

        System.out.println(middleNode(h).val); //output: 3

    }

    public static ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode current = head;
        while (current != null){
            len++;
            current = current.next;
        }

        current = head;
        len = len/2;

        while (len > 0){
            len--;
            current = current.next;
        }

        return current;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
