package leetcode.medium;

public class DeleteMiddle {

    //problem: You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);

        h = deleteMiddle(h);

        while (h != null){
            System.out.print(h.val + ", ");
            h = h.next;
        } //output: 1, 2, 4,
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head.next == null){return null;}

        ListNode current = head.next;
        ListNode middle = head;
        int len = 1;

        while (current.next != null){
            current = current.next;
            if (len % 2 == 0){
                middle = middle.next;
            }
            len++;
        }

        middle.next = middle.next.next;

        return head;
    }

    public static class ListNode {
        int val;
        DeleteMiddle.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, DeleteMiddle.ListNode next) { this.val = val; this.next = next; }
    }
}
