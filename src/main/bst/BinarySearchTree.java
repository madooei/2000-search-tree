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
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  public boolean contains(T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Searches the subtree rooted at node.
  private boolean contains(Node<T> node, T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Does nothing if value is already in the tree.
  public void add(T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Adds value to the subtree rooted at node and returns that subtree's root.
  private Node<T> add(Node<T> node, T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Does nothing if value is not in the tree.
  public void remove(T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Removes value from the subtree rooted at node and returns that subtree's
  // new root.
  private Node<T> remove(Node<T> node, T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Assumes node is not null. Returns the node with the smallest value in
  // the subtree rooted at node.
  private Node<T> minNode(Node<T> node) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Assumes node is not null. Returns the node with the largest value in
  // the subtree rooted at node.
  private Node<T> maxNode(Node<T> node) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns the values in ascending order.
  @Override
  public Iterator<T> iterator() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Walks the tree in-order, keeping the nodes still to visit on a stack.
  private class BinarySearchTreeIterator implements Iterator<T> {
    private Stack<Node<T>> stack = new LinkedStack<>();

    BinarySearchTreeIterator() {
      // TODO: Implement me
      throw new UnsupportedOperationException("TODO: Implement me");
    }

    // Pushes node and every node on the path of left children below it.
    private void pushLeftSpine(Node<T> node) {
      // TODO: Implement me
      throw new UnsupportedOperationException("TODO: Implement me");
    }

    @Override
    public boolean hasNext() {
      // TODO: Implement me
      throw new UnsupportedOperationException("TODO: Implement me");
    }

    @Override
    public T next() {
      // TODO: Implement me
      throw new UnsupportedOperationException("TODO: Implement me");
    }
  }
}
