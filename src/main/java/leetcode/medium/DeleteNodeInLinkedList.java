package leetcode.medium;

public class DeleteNodeInLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        deleteNode(n2);

        ListNode currentNode = n1;

        while (currentNode != null){
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }

        //output:
        // 4
        // 1
        // 9

    }

    public static void deleteNode(ListNode node) {
        ListNode currentNode = node;

        while (currentNode.next.next != null){
            currentNode.val = currentNode.next.val;
            currentNode = currentNode.next;
        }

        currentNode.val = currentNode.next.val;
        currentNode.next = null;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
