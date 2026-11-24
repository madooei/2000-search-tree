package demo;

import bst.BinarySearchTree;

/** A demo of BinarySearchTree on the chapter's example tree. */
public final class BinarySearchTreeDemo {

  private BinarySearchTreeDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();

    // Adding in this order builds the chapter's example tree, with 50 at the root.
    int[] values = {50, 30, 70, 20, 40, 60, 80};
    for (int value : values) {
      tree.add(value);
    }

    // 60 is in the tree and 35 is not. Expect true, then false.
    System.out.println("contains 60: " + tree.contains(60));
    System.out.println("contains 35: " + tree.contains(35));

    // Expect 20 30 40 50 60 70 80.
    System.out.print("in sorted order:");
    for (int value : tree) {
      System.out.print(" " + value);
    }
    System.out.println();

    // 35 goes to the left of 40. Expect true.
    System.out.println("add 35");
    tree.add(35);
    System.out.println("contains 35: " + tree.contains(35));

    // 50 is the root and has two children, so its in-order successor 60 takes its place.
    System.out.println("remove 50");
    tree.remove(50);
    System.out.println("contains 50: " + tree.contains(50));

    // Expect 20 30 35 40 60 70 80.
    System.out.print("in sorted order:");
    for (int value : tree) {
      System.out.print(" " + value);
    }
    System.out.println();
  }
}
