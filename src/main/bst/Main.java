package bst;

/** A small demo of the binary search tree on the chapter's example tree. */
public class Main {

  public static void main(String[] args) {
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();

    // Adding in this order builds the chapter's example tree.
    int[] values = {50, 30, 70, 20, 40, 60, 80};
    for (int value : values) {
      tree.add(value);
    }

    System.out.println("contains 60: " + tree.contains(60));
    System.out.println("contains 35: " + tree.contains(35));

    System.out.print("in sorted order:");
    for (int value : tree) {
      System.out.print(" " + value);
    }
    System.out.println();

    System.out.println("add 35");
    tree.add(35);
    System.out.println("contains 35: " + tree.contains(35));

    System.out.println("remove 50 (the root, two children)");
    tree.remove(50);
    System.out.println("contains 50: " + tree.contains(50));

    System.out.print("in sorted order:");
    for (int value : tree) {
      System.out.print(" " + value);
    }
    System.out.println();
  }
}
