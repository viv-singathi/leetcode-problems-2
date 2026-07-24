package leetcode.easy;

public class RemoveDuplicates {
    //problem: Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
    // Return the linked list sorted as well.
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(1);
        h.next.next = new ListNode(2);
        h = deleteDuplicates(h);

        System.out.println(h.val + ", " + h.next.val); //output: 1, 2
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){return null;}
        ListNode current = head;

        while (current.next != null){
            if (current.val == current.next.val){
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
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
