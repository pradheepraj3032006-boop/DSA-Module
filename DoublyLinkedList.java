package linkedlist;

/** Doubly Linked List: each node has prev & next pointers -> supports backward traversal. */
public class DoublyLinkedList {

    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    private Node head, tail;

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = tail = newNode; return; }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insertAtTail(int data) { // O(1) since we keep a tail pointer
        Node newNode = new Node(data);
        if (tail == null) { head = tail = newNode; return; }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public boolean delete(int data) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) {
                if (curr.prev != null) curr.prev.next = curr.next; else head = curr.next;
                if (curr.next != null) curr.next.prev = curr.prev; else tail = curr.prev;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void traverseForward() {
        Node curr = head;
        StringBuilder sb = new StringBuilder("Forward:  NULL <- ");
        while (curr != null) {
            sb.append(curr.data).append(" <-> ");
            curr = curr.next;
        }
        sb.append("NULL");
        System.out.println(sb);
    }

    public void traverseBackward() {
        Node curr = tail;
        StringBuilder sb = new StringBuilder("Backward: NULL <- ");
        while (curr != null) {
            sb.append(curr.data).append(" <-> ");
            curr = curr.prev;
        }
        sb.append("NULL");
        System.out.println(sb);
    }

    public static void run() {
        System.out.println("=== Doubly Linked List Demo ===");
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtHead(5);
        list.traverseForward();
        list.traverseBackward();
        list.delete(20);
        list.traverseForward();
    }
}
