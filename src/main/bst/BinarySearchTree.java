package bst;

import java.util.Iterator;
import java.util.NoSuchElementException;
import stack.LinkedStack;
import stack.Stack;

/**
 * A binary search tree of Comparable values. It stores no duplicates.
 *
 * @param <T> the type of value stored in the tree.
 */
public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

  private Node<T> root;

  private static class Node<T> {
    T value;
    Node<T> left;
    Node<T> right;

    Node(T value) {
      this.value = value;
    }
  }

  public BinarySearchTree() {
    root = null;
  }

  public boolean contains(T value) {
    return contains(root, value);
  }

  // Searches the subtree rooted at node.
  private boolean contains(Node<T> node, T value) {
    if (node == null) {
      return false;  // fell off the tree
    }

    int cmp = value.compareTo(node.value);
    if (cmp == 0) {
      return true;
    } else if (cmp < 0) {
      return contains(node.left, value);
    } else {
      return contains(node.right, value);
    }
  }

  // The same search as contains, written as a loop.
  public boolean containsIterative(T value) {
    Node<T> current = root;
    while (current != null) {
      int cmp = value.compareTo(current.value);
      if (cmp == 0) {
        return true;
      } else if (cmp < 0) {
        current = current.left;
      } else {
        current = current.right;
      }
    }
    return false;
  }

  // Does nothing if value is already in the tree.
  public void add(T value) {
    root = add(root, value);
  }

  // Adds value to the subtree rooted at node and returns that subtree's root.
  private Node<T> add(Node<T> node, T value) {
    if (node == null) {
      return new Node<>(value);
    }

    int cmp = value.compareTo(node.value);
    if (cmp < 0) {
      node.left = add(node.left, value);
    } else if (cmp > 0) {
      node.right = add(node.right, value);
    }
    return node;
  }

  // Does nothing if value is not in the tree.
  public void remove(T value) {
    root = remove(root, value);
  }

  // Removes value from the subtree rooted at node and returns that subtree's
  // new root.
  private Node<T> remove(Node<T> node, T value) {
    if (node == null) {
      return null;
    }

    int cmp = value.compareTo(node.value);
    if (cmp < 0) {
      node.left = remove(node.left, value);
      return node;
    } else if (cmp > 0) {
      node.right = remove(node.right, value);
      return node;
    }

    if (node.left == null) {
      return node.right;
    } else if (node.right == null) {
      return node.left;
    } else {
      Node<T> successor = minNode(node.right);
      node.value = successor.value;
      node.right = remove(node.right, successor.value);
      return node;
    }
  }

  // Returns the node with the smallest value in the subtree rooted at node.
  // Throws IllegalArgumentException if node is null.
  private Node<T> minNode(Node<T> node) {
    if (node == null) {
      throw new IllegalArgumentException("empty subtree");
    }
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  // Returns the node with the largest value in the subtree rooted at node.
  // Throws IllegalArgumentException if node is null.
  private Node<T> maxNode(Node<T> node) {
    if (node == null) {
      throw new IllegalArgumentException("empty subtree");
    }
    while (node.right != null) {
      node = node.right;
    }
    return node;
  }

  // Returns the values in ascending order.
  @Override
  public Iterator<T> iterator() {
    return new BinarySearchTreeIterator();
  }

  // Walks the tree in-order, keeping the nodes still to visit on a stack.
  private class BinarySearchTreeIterator implements Iterator<T> {
    private Stack<Node<T>> stack = new LinkedStack<>();

    BinarySearchTreeIterator() {
      pushLeftSpine(root);
    }

    // Pushes node and every node on the path of left children below it.
    private void pushLeftSpine(Node<T> node) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
    }

    @Override
    public boolean hasNext() {
      return !stack.isEmpty();
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Node<T> node = stack.top();
      stack.pop();
      T value = node.value;
      pushLeftSpine(node.right);
      return value;
    }
  }
}
