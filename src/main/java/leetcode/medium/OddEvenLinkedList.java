package leetcode.medium;

public class OddEvenLinkedList {
    //problem: Given the head of a singly linked list, group all the nodes with odd indices together followed
    // by the nodes with even indices, and return the reordered list.
    //The first node is considered odd, and the second node is even, and so on.
    //Note that the relative order inside both the even and odd groups should remain as it was in the input
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        oddEvenList(h);
        System.out.println(h.val + ", " + h.next.val + ", " + h.next.next.val); //output: 1, 3, 2
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null){return head;}

        ListNode end = head;
        int len = 1;

        while (end.next != null){
            end = end.next;
            len++;
        }

        ListNode currentNode = head;
        ListNode newEnd = end;
        int i = 0;

        while (i < len / 2 ){
            ListNode tmp = currentNode.next.next;

            newEnd.next = currentNode.next;
            newEnd.next.next = null;
            newEnd = currentNode.next;
            currentNode.next = tmp;
            currentNode = tmp;
            i++;
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
}
