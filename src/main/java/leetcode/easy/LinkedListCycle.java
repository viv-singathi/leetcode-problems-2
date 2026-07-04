package leetcode.easy;

public class LinkedListCycle {
    //problem:
    //Given head, the head of a linked list, determine if the linked list has a cycle in it.
    //There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
    //
    //Return true if there is a cycle in the linked list. Otherwise, return false.
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        System.out.println(hasCycle(head)); //output: true
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null){return false;}
        ListNode behind = head;
        ListNode current = head.next;

        while (current != null && current != behind){
            behind = behind.next;
            current = current.next;
            if (current == behind || current == null){break;}
            current = current.next;
        }

        return current != null;
    }

    static class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
