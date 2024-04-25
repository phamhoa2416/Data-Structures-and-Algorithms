public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void TraversalLinkedList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    public boolean SearchingLinkedList(ListNode head, int target) {
        ListNode current = head;

        while (current != null) {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public int FindingLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public void InsertAtBeginning(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;

    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(15);
        ListNode fourth = new ListNode(4);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        sll.InsertAtBeginning(2);
        sll.TraversalLinkedList(sll.head);

    }
}
