package linkedlist;

/** Circular Singly Linked List: last node points back to head instead of null. */
public class CircularSinglyLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = newNode; newNode.next = head; return; }
        Node curr = head;
        while (curr.next != head) curr = curr.next; // find last node
        newNode.next = head;
        head = newNode;
        curr.next = head;
    }

    public void insertAtTail(int data) {
        if (head == null) { insertAtHead(data); return; }
        Node newNode = new Node(data);
        Node curr = head;
        while (curr.next != head) curr = curr.next;
        curr.next = newNode;
        newNode.next = head;
    }

    public boolean delete(int data) {
        if (head == null) return false;
        if (head.data == data && head.next == head) { head = null; return true; }
        Node curr = head, prev = null;
        do {
            if (curr.data == data) {
                if (curr == head) {
                    Node last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                return true;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
        return false;
    }

    public void traverse() {
        if (head == null) { System.out.println("Empty list"); return; }
        Node curr = head;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(curr.data).append(" -> ");
            curr = curr.next;
        } while (curr != head);
        sb.append("(back to HEAD)");
        System.out.println(sb);
    }

    public static void run() {
        System.out.println("=== Circular Singly Linked List Demo ===");
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.insertAtHead(20);
        list.insertAtHead(10);
        list.insertAtTail(30);
        list.traverse();
        list.delete(20);
        list.traverse();
    }
}
