package leetcode.easy;
public class RemoveLinkedListElements {
    //problem: Given the head of a linked list and an integer val, remove all the nodes of the
    // linked list that has Node.val == val, and return the new head
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(2);
        h.next.next.next = new ListNode(3);
        h = removeElements(h, 2);
        System.out.println(h.val +", " + h.next.val); //output : 1, 3
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null){return null;}

        while (head != null && head.val ==  val){
            head = head.next;
        }

        if (head == null) {return null;}

        ListNode current = head;

        while (current.next != null){
            if (current.next.val == val){
                current.next = current.next.next;
            } else{
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
