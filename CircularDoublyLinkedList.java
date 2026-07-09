package linkedlist;

/** Circular Doubly Linked List: combines circular linking with prev/next pointers. */
public class CircularDoublyLinkedList {

    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    private Node head;

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head.prev = head;
            return;
        }
        Node last = head.prev;
        newNode.next = head;
        newNode.prev = last;
        head.prev = newNode;
        last.next = newNode;
        head = newNode;
    }

    public void insertAtTail(int data) {
        if (head == null) { insertAtHead(data); return; }
        Node newNode = new Node(data);
        Node last = head.prev;
        last.next = newNode;
        newNode.prev = last;
        newNode.next = head;
        head.prev = newNode;
    }

    public boolean delete(int data) {
        if (head == null) return false;
        Node curr = head;
        do {
            if (curr.data == data) {
                if (curr.next == curr) { head = null; return true; }
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                if (curr == head) head = curr.next;
                return true;
            }
            curr = curr.next;
        } while (curr != head);
        return false;
    }

    public void traverse() {
        if (head == null) { System.out.println("Empty list"); return; }
        Node curr = head;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(curr.data).append(" <-> ");
            curr = curr.next;
        } while (curr != head);
        sb.append("(back to HEAD)");
        System.out.println(sb);
    }

    public static void run() {
        System.out.println("=== Circular Doubly Linked List Demo ===");
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtHead(5);
        list.traverse();
        list.delete(10);
        list.traverse();
    }
}
