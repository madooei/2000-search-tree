# Search Tree

The companion code for the Binary Search Tree chapter: a generic `BinarySearchTree<T extends Comparable<T>>` class that stores values with no duplicates, with search, add, and remove. The tree implements `Iterable<T>`, so an enhanced `for` loop visits its values in sorted order. There is a JUnit suite.

## Prerequisites

- JDK 17+ (JUnit 6 requires it).
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      bst/
        BinarySearchTree.java           # contains, add, remove, iterator
      stack/
        Stack.java                      # the Stack ADT from the stack chapter
        LinkedStack.java                # the stack the iterator uses
      demo/
        BinarySearchTreeDemo.java       # demo over the chapter's example tree
    test/
      bst/
        BinarySearchTreeTest.java
  scripts/
    run.sh                              # compile and run one demo
    test.sh                             # compile and run the JUnit tests
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh bst.BinarySearchTreeTest` — compiles everything and runs only that test class.
- `scripts/run.sh demo.BinarySearchTreeDemo` — compiles everything and runs that one demo. Every class you implement has its own demo, `<Class>Demo`.

## What's here

- `bst.BinarySearchTree<T>` — the binary search tree. It has `contains`, `add`, `remove`, and `iterator`. Each recursive operation is a public method that starts at the root and a private helper that works on a node. The private `minNode` and `maxNode` find the smallest and largest node in a subtree; `remove` uses `minNode` to find the in-order successor. The iterator is the iterative in-order traversal from the tree chapter's practice problems, with the stack kept in a field.
- `demo.BinarySearchTreeDemo` — the demo for `BinarySearchTree`. It builds the chapter's example tree, searches it, adds and removes values, and prints the values in sorted order.
- `stack.Stack<T>` and `stack.LinkedStack<T>` — the Stack ADT and its linked implementation from the stack chapter, included so this code compiles and runs on its own.
