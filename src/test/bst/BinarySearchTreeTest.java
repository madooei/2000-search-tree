package bst;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/** Tests for the binary search tree. */
public class BinarySearchTreeTest {

  private BinarySearchTree<Integer> tree;

  @BeforeEach
  public void setUp() {
    tree = new BinarySearchTree<>();
  }

  @Test
  public void newTreeContainsNothing() {
    assertFalse(tree.contains(50));
  }

  @Test
  public void newTreeContainsIterativeNothing() {
    assertFalse(tree.containsIterative(50));
  }

  @Test
  public void newTreeIteratorHasNoNext() {
    assertFalse(tree.iterator().hasNext());
  }

  @Test
  public void nextOnNewTreeThrows() {
    Iterator<Integer> it = tree.iterator();
    try {
      it.next();
      fail("expected NoSuchElementException on an empty tree");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void removeFromNewTreeLeavesItEmpty() {
    tree.remove(50);
    assertFalse(tree.iterator().hasNext());
  }

  @Test
  public void addedValueIsFound() {
    tree.add(50);
    assertTrue(tree.contains(50));
  }

  @Test
  public void addedValueIsFoundIteratively() {
    tree.add(50);
    assertTrue(tree.containsIterative(50));
  }

  @Test
  public void iteratorReturnsTheOnlyValue() {
    tree.add(50);
    assertValues(new Integer[] {50});
  }

  @Test
  public void removeOnlyValueLeavesTreeEmpty() {
    tree.add(50);
    tree.remove(50);
    assertFalse(tree.iterator().hasNext());
  }

  @Test
  public void containsFindsRoot() {
    buildExample();
    assertTrue(tree.contains(50));
  }

  @Test
  public void containsFindsLeaf() {
    buildExample();
    assertTrue(tree.contains(60));
  }

  @Test
  public void containsMissingValueIsFalse() {
    buildExample();
    assertFalse(tree.contains(35));
  }

  @Test
  public void containsIterativeFindsRoot() {
    buildExample();
    assertTrue(tree.containsIterative(50));
  }

  @Test
  public void containsIterativeFindsLeaf() {
    buildExample();
    assertTrue(tree.containsIterative(60));
  }

  @Test
  public void containsIterativeMissingValueIsFalse() {
    buildExample();
    assertFalse(tree.containsIterative(35));
  }

  @Test
  public void iteratorVisitsValuesInSortedOrder() {
    buildExample();
    assertValues(new Integer[] {20, 30, 40, 50, 60, 70, 80});
  }

  @Test
  public void iteratorIsSortedForAnotherInsertionOrder() {
    int[] values = {40, 80, 20, 70, 50, 30, 60};
    for (int value : values) {
      tree.add(value);
    }
    assertValues(new Integer[] {20, 30, 40, 50, 60, 70, 80});
  }

  @Test
  public void iteratorIsSortedForSortedInsertionOrder() {
    int[] values = {20, 30, 40, 50, 60, 70, 80};
    for (int value : values) {
      tree.add(value);
    }
    assertValues(new Integer[] {20, 30, 40, 50, 60, 70, 80});
  }

  @Test
  public void drainedIteratorHasNoNext() {
    buildExample();
    Iterator<Integer> it = tree.iterator();
    for (int i = 0; i < 7; i++) {
      it.next();
    }
    assertFalse(it.hasNext());
  }

  @Test
  public void nextOnDrainedIteratorThrows() {
    buildExample();
    Iterator<Integer> it = tree.iterator();
    for (int i = 0; i < 7; i++) {
      it.next();
    }
    try {
      it.next();
      fail("expected NoSuchElementException after the last value");
    } catch (NoSuchElementException e) {
      return;
    }
  }

  @Test
  public void addNewValueIsFound() {
    buildExample();
    tree.add(35);
    assertTrue(tree.contains(35));
  }

  @Test
  public void addNewValueKeepsSortedOrder() {
    buildExample();
    tree.add(35);
    assertValues(new Integer[] {20, 30, 35, 40, 50, 60, 70, 80});
  }

  @Test
  public void addDuplicateDoesNothing() {
    buildExample();
    tree.add(40);
    assertValues(new Integer[] {20, 30, 40, 50, 60, 70, 80});
  }

  @Test
  public void removeLeafDeletesIt() {
    buildExample();
    tree.remove(20);
    assertFalse(tree.contains(20));
  }

  @Test
  public void removeLeafKeepsOtherValues() {
    buildExample();
    tree.remove(20);
    assertValues(new Integer[] {30, 40, 50, 60, 70, 80});
  }

  @Test
  public void removeNodeWithOneChildDeletesIt() {
    buildOneChildExample();
    tree.remove(30);
    assertFalse(tree.contains(30));
  }

  @Test
  public void removeNodeWithOneChildKeepsOtherValues() {
    buildOneChildExample();
    tree.remove(30);
    assertValues(new Integer[] {40, 50, 70, 80});
  }

  @Test
  public void removeNodeWithTwoChildrenDeletesIt() {
    buildExample();
    tree.remove(50);
    assertFalse(tree.contains(50));
  }

  @Test
  public void removeNodeWithTwoChildrenKeepsOtherValues() {
    buildExample();
    tree.remove(50);
    assertValues(new Integer[] {20, 30, 40, 60, 70, 80});
  }

  @Test
  public void removeMissingValueChangesNothing() {
    buildExample();
    tree.remove(35);
    assertValues(new Integer[] {20, 30, 40, 50, 60, 70, 80});
  }

  @Test
  public void removeEveryValueLeavesTreeEmpty() {
    buildExample();
    int[] values = {50, 30, 70, 20, 40, 60, 80};
    for (int value : values) {
      tree.remove(value);
    }
    assertFalse(tree.iterator().hasNext());
  }

  // Builds the chapter's example tree: 50 with children 30 and 70; 30 with
  // children 20 and 40; 70 with children 60 and 80.
  private void buildExample() {
    int[] values = {50, 30, 70, 20, 40, 60, 80};
    for (int value : values) {
      tree.add(value);
    }
  }

  // Builds 50 with children 30 and 70, where 30 has only a right child 40 and
  // 70 has only a right child 80.
  private void buildOneChildExample() {
    int[] values = {50, 30, 70, 40, 80};
    for (int value : values) {
      tree.add(value);
    }
  }

  // Asserts that the iterator returns exactly the expected values, in order.
  private void assertValues(Integer[] expected) {
    Iterator<Integer> it = tree.iterator();
    for (int i = 0; i < expected.length; i++) {
      assertTrue(it.hasNext());
      assertEquals(expected[i], it.next());
    }
    assertFalse(it.hasNext());
  }
}
