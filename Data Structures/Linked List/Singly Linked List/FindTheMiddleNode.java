public class FindTheMiddleNode extends SinglyLinkedList {
    public Node head;

    public void findTheMiddleNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println(slow.data);
    }
}
