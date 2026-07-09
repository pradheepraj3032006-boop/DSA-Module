package linkedlist;

/** Singly Linked List: insert, delete, search, traverse. Insert-at-head is O(1). */
public class SinglyLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtTail(int data) { // O(n) - no tail pointer kept
        Node newNode = new Node(data);
        if (head == null) { head = newNode; return; }
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = newNode;
    }

    public boolean delete(int data) { // O(n)
        if (head == null) return false;
        if (head.data == data) { head = head.next; return true; }
        Node curr = head;
        while (curr.next != null && curr.next.data != data) curr = curr.next;
        if (curr.next == null) return false;
        curr.next = curr.next.next;
        return true;
    }

    public boolean search(int data) { // O(n)
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) return true;
            curr = curr.next;
        }
        return false;
    }

    public void traverse() { // O(n)
        Node curr = head;
        StringBuilder sb = new StringBuilder("HEAD -> ");
        while (curr != null) {
            sb.append(curr.data).append(" -> ");
            curr = curr.next;
        }
        sb.append("NULL");
        System.out.println(sb);
    }

    public static void run() {
        System.out.println("=== Singly Linked List Demo ===");
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtHead(30);
        list.insertAtHead(20);
        list.insertAtHead(10);
        list.insertAtTail(40);
        list.traverse();
        System.out.println("Search 30 -> " + list.search(30));
        list.delete(20);
        list.traverse();
    }
}
