package leetcode.medium;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);

        h = removeNthFromEnd(h, 2);
        while (h != null){
            System.out.print(h.val + ", ");
            h = h.next;
        }
        //output: 1, 2, 3, 5,
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null){return null;}
        ListNode current = head;
        ListNode prev = null;

        for (int i = 0; i < n-1; i++){
            current = current.next;
        }

        while (current.next != null){
            current = current.next;
            prev = prev == null ? head : prev.next;
        }

        if (prev == null){
            return head.next;
        }

        prev.next = prev.next.next;

        return head;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
