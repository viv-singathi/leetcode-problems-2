package leetcode.medium;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);

        ListNode res = addTwoNumbers(n1, n2);

        while (res != null){
            System.out.print(res.val);
            res = res.next;
        }

        //output: 708

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode prev_node = null;
        ListNode current_node = head;

        int r = 0;

        while (l1 != null || l2 != null || r > 0){

            int s;

            if (l1 != null && l2 != null){
                s = l1.val + l2.val + r;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null){
                s = l1.val + r;
                l1 = l1.next;
            } else if (l2 != null) {
                s = l2.val + r;
                l2 = l2.next;
            } else {
                s = r;
            }

            current_node.val = s % 10;
            r = s/10;
            ListNode next_node = new ListNode(-1);

            if (prev_node != null){
                prev_node.next = current_node;
            }

            prev_node = current_node;
            current_node = next_node;

        }

        return head;

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
