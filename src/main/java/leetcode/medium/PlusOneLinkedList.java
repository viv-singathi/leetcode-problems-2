package leetcode.medium;

import java.util.Stack;

public class PlusOneLinkedList {
    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);

        plusOne(n);

        System.out.println("" + n.val + n.next.val + n.next.next.val);
        //output: 124
    }
    public static ListNode plusOne(ListNode head) {

        Stack s = new Stack();
        ListNode current_node = head;

        while (current_node.next != null){
            s.push(current_node);
            current_node = current_node.next;
        }

        current_node.val += 1;

        while (current_node.val == 10){
            current_node.val = 0;

            if (!s.isEmpty()){
                current_node = (ListNode) s.pop();
                current_node.val += 1;
            } else {
                current_node = new ListNode(1);
                current_node.next = head;
                head = current_node;
            }
        }



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
