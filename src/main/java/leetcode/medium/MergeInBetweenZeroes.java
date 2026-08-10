package leetcode.medium;

public class MergeInBetweenZeroes {
    //problem: You are given the head of a linked list, which contains a series of integers separated by 0's.
    // The beginning and end of the linked list will have Node.val == 0.
    //For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes.
    // The modified list should not contain any 0's.
    //Return the head of the modified linked list.
    public static void main(String[] args) {
        ListNode h = new ListNode(0);
        h.next = new ListNode(2, new ListNode(3, new ListNode(0)));
        System.out.println(mergeNodes(h).val); //output: 5
    }

    public static ListNode mergeNodes(ListNode head) {
        ListNode start = head;
        ListNode prevStart = null;
        ListNode current = head.next;

        while (current != null){
            int s = 0;

            while (current.val != 0){
                s += current.val;
                current = current.next;
            }

            start.val = s;
            prevStart = start;
            start = start.next;

            current = current.next;
        }

        if (prevStart != null){
            prevStart.next = null;
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
