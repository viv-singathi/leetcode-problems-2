package leetcode.medium;

import leetcode.easy.RemoveDuplicates;

public class MergeInBetweenLinkedLists {
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new  ListNode(3);

        h = mergeInBetween(h, 1, 2, new ListNode(4));

        System.out.println(h.val + ", " + h.next.val); //output: 1, 4
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode end2 = list2;
        while (end2.next != null){
            end2 = end2.next;
        }

        ListNode current = list1;

        for (int i = 1; i < a; i++){
            current = current.next;
        }

        ListNode skip = current.next;
        current.next = list2;

        for (int i = a; i <= b; i++){
            skip = skip.next;
        }

        end2.next = skip;

        return list1;
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
