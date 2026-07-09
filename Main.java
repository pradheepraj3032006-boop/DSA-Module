import arrays.ArrayOperations;
import complexity.ComplexityAnalysis;
import linkedlist.CircularDoublyLinkedList;
import linkedlist.CircularSinglyLinkedList;
import linkedlist.DoublyLinkedList;
import linkedlist.SinglyLinkedList;
import searching.SearchingAlgorithms;
import sorting.SortingAlgorithms;

/**
 * Module 2 - Data Structures & Algorithms
 * Runs a demo of every topic covered in the module.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("############################################");
        System.out.println("  Module 2: Data Structures & Algorithms Demo");
        System.out.println("############################################\n");

        ComplexityAnalysis.run();
        System.out.println();

        ArrayOperations.run();
        System.out.println();

        SinglyLinkedList.run();
        System.out.println();

        CircularSinglyLinkedList.run();
        System.out.println();

        DoublyLinkedList.run();
        System.out.println();

        CircularDoublyLinkedList.run();
        System.out.println();

        SearchingAlgorithms.run();
        System.out.println();

        SortingAlgorithms.run();
    }
}
