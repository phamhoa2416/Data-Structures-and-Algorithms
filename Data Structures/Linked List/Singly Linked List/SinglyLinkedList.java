import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;

    public boolean elementExists(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void addlast(int data) {
        if (elementExists(data)) {
            return;
        }
        append(data);
    }

    public void addfirst(int data) {
        if (elementExists(data)) {
            return;
        }

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addafter(int data, int key) {
        if (elementExists(data)) {
            return;
        }

        Node newNode = new Node(data);
        if (head == null) {
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.data == key) {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
    }

    public void addbefore(int data, int key) {
        if (elementExists(data)) {
            return;
        }

        Node newNode = new Node(data);
        if (head == null) {
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.next.data == key) {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
    }

    public void remove(int key) {
        if (elementExists(key) == false) {
            return;
        }

        if (head == null) {
            return;
        }

        Node current = head;
        if (current != null && current.data == key) {
            head = current.next;
            return;
        }

        while (current != null) {
            if (current.next.data == key) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void findTheMiddleNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println(slow.data);
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();

        for (int i = 0; i < size; ++i) {
            int value = input.nextInt();
            sll.addlast(value);
        }

        while (input.hasNext()) {
            String command = input.next();
            if (command.equals("addlast")) {
                int value = input.nextInt();
                sll.addlast(value);
            } else if (command.equals("addfirst")) {
                int value = input.nextInt();
                sll.addfirst(value);
            } else if (command.equals("addafter")) {
                int value = input.nextInt();
                int key = input.nextInt();
                sll.addafter(value, key);
            } else if (command.equals("addbefore")) {
                int value = input.nextInt();
                int key = input.nextInt();
                sll.addbefore(value, key);
            } else if (command.equals("remove")) {
                int key = input.nextInt();
                sll.remove(key);
            } else if (command.equals("reverse")) {
                sll.reverse();
            } else if (command.equals("Find the middle node of the list")) {
                sll.findTheMiddleNode();
            } else if (command.equals("#")) {
                break;
            }
        }
        sll.display();
        input.close();
    }
}
