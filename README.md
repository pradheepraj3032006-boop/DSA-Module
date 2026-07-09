# Module 2 – Data Structures & Algorithms (Java)
### Cognizant Digital Nurture 5.0 – Java Full Stack Engineer Track

This repository contains hands-on Java implementations for Module 2, covering
Arrays, Linked Lists, Searching, Sorting, and Complexity Analysis — matching
the sub-topics listed in the module's learning references (GeeksforGeeks).

## 📁 Repository Structure
```
DSA-Module2/
├── README.md
└── src/
    ├── complexity/
    │   └── ComplexityAnalysis.java     # Time/space complexity demos, Big-O examples
    ├── arrays/
    │   └── ArrayOperations.java        # Traversal, insertion, deletion, memory layout notes
    ├── linkedlist/
    │   ├── SinglyLinkedList.java
    │   ├── CircularSinglyLinkedList.java
    │   ├── DoublyLinkedList.java
    │   └── CircularDoublyLinkedList.java
    ├── searching/
    │   └── SearchingAlgorithms.java    # Linear search, Binary search (iterative + recursive)
    ├── sorting/
    │   └── SortingAlgorithms.java      # Bubble, Insertion, Quick, Merge, Heap sort
    └── Main.java                       # Menu-driven runner to demo everything
```

## 🎯 Learning Objectives Mapped to Code
| Objective | Where it's demonstrated |
|---|---|
| Choose appropriate DS | `arrays/`, `linkedlist/` — comments explain when to use each |
| Apply searching algorithms | `searching/SearchingAlgorithms.java` |
| Utilize sorting algorithms | `sorting/SortingAlgorithms.java` |
| Analyze complexity | `complexity/ComplexityAnalysis.java` + Big-O table below |
| Design scalable solutions | `Main.java` ties everything together in one runnable demo |

## ⏱ Complexity Cheat Sheet

**Sorting**
| Algorithm | Best | Average | Worst | Space | Stable |
|---|---|---|---|---|---|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | No |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| Heap Sort | O(n log n) | O(n log n) | O(n log n) | O(1) | No |

**Searching**
| Algorithm | Best | Average | Worst | Requires |
|---|---|---|---|---|
| Linear Search | O(1) | O(n) | O(n) | Nothing (unsorted OK) |
| Binary Search | O(1) | O(log n) | O(log n) | Sorted array |

**Linked List Operations**
| Operation | Singly | Doubly |
|---|---|---|
| Insert at head | O(1) | O(1) |
| Insert at tail (no tail ptr) | O(n) | O(n) |
| Delete at head | O(1) | O(1) |
| Search | O(n) | O(n) |
| Traverse backward | Not possible | O(n) |

## 🚀 How to Run
```bash
# From the src/ folder
javac -d out $(find . -name "*.java")
java -cp out Main
```

## 📅 Suggested 3-Day Plan
- **Day 1**: Analysis of Algorithms (Big-O, best/avg/worst case) + Arrays — read GfG links, implement `ComplexityAnalysis.java` and `ArrayOperations.java`.
- **Day 2**: Linked Lists — implement all four variants (singly, circular singly, doubly, circular doubly) with insert/delete/traverse/search.
- **Day 3**: Searching + Sorting — implement linear/binary search and all five sorting algorithms, run `Main.java` end-to-end, write complexity notes, push to GitHub.

## 📚 Reference Links
- Design & Analysis of Algorithms: https://www.geeksforgeeks.org/design-and-analysis-of-algorithms/
- Sorting Algorithms: https://www.geeksforgeeks.org/sorting-algorithms/
- Array Data Structure: https://www.geeksforgeeks.org/array-data-structure-guide/
- Linked List in Java: https://www.geeksforgeeks.org/linked-list-in-java/
- Searching Algorithms: https://www.geeksforgeeks.org/searching-algorithms/

## 📤 Pushing to GitHub
```bash
git init
git add .
git commit -m "Module 2: Data Structures and Algorithms - DSA implementations"
git branch -M main
git remote add origin https://github.com/<your-username>/DSA-Module2.git
git push -u origin main
```
