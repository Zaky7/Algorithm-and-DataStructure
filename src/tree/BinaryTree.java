package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E extends Comparable<E>> {
  private Node<E> root;
  private int size = 0;

  /**
   * Method to add a node to tree
   *
   * @param value
   */
  public void addNode(E value) {
    if (size == 0) {
      root = new Node<E>(value);
      size++;
    } else {
      addNode(root, value);
    }
  }

  public void addNodeLevelOrderWise(E value) {
    if (size == 0) {
      root = new Node<E>(value);
      size++;
    } else {
      addNodeLevelOrderWise(root, value);
    }
  }

  /**
   *
   * @param rootNode
   * @param value
   * @return
   */
  private Node<E> addNode(Node<E> rootNode, E value) {
    /* If root is null, return null */
    if (rootNode == null) {
      return null;
    }

    /* Create a new node */
    Node<E> newNode = new Node<E>(value);

    /* Compare with root, if small, insert left else insert right */
    if ((newNode.data).compareTo(rootNode.data) <= 0) {
      if (rootNode.left != null) {
        rootNode.left = addNode(rootNode.left, value);
      } else {
        rootNode.left = newNode;
      }
    } else {
      if (rootNode.right != null) {
        rootNode.right = addNode(rootNode.right, value);
      } else {
        rootNode.right = newNode;
      }
    }

    /* Increase the size and return rootNode */
    size++;
    return rootNode;
  }

  private Node<E> addNodeLevelOrderWise(Node<E> rootNode, E value) {
    /* If root is null, return null */
    if (rootNode == null) {
      return null;
    }

    /* Create a new node */
    Node<E> newNode = new Node<E>(value);
    Queue<Node<E>> queue = new LinkedList<>();

    queue.add(rootNode);

    while (!queue.isEmpty()) {
      Node<E> node = queue.poll();

      // First Insert in Left
      if (node.left != null) {
        queue.add(node.left);
      } else {
        node.left = newNode;
        break;
      }

      if (node.right != null) {
        queue.add(node.right);
      } else {
        node.right = newNode;
        break;
      }
    }

    queue.clear();
    /* Increase the size and return rootNode */
    size++;
    return rootNode;
  }

  /**
   * Method to find the root of the Tree
   *
   * @return {@link Node}
   */
  public Node<E> root() {
    if (isEmpty()) {
      return null;
    } else {
      return root;
    }
  }

  /**
   * Check whether Binary Tree is Empty or not
   *
   * @return the Size of Binary Tree
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return size(root);
  }

  /**
   * Size of Binary Tree
   *
   * @param root
   * @return
   */
  private int size(Node<E> root) {
    if (root != null) {
      return 1 + Math.max(size(root.left), size(root.right));
    } else {
      return 0;
    }
  }

  /**
   * @param node
   * @return True if a given node is root else False
   */
  public boolean isRoot(Node<E> node) {
    return root == node;
  }

  /**
   * Method for find the parent of given Node
   *
   * @param node
   * @return {@link Node}
   */
  public Node<E> findParent(Node<E> node) {
    return findParent(node.data, root, null);
  }

  /**
   * @param data
   * @param root
   * @param parent
   * @return {@link Node}
   */
  private Node<E> findParent(E data, Node<E> root, Node<E> parent) {
    if (root == null) {
      return null;
    }

    // Compare with root if found equal return parent
    // else find parent in left subtree if not found then find parent in Right subTree.
    if ((root.data).compareTo(data) != 0) {
      parent = findParent(data, root.left, parent);

      if (parent == null) {
        parent = findParent(data, root.right, parent);
      }
    }

    return parent;
  }

  /**
   * Method for finding if a node has Parent
   *
   * @param node
   * @return
   */
  public boolean hasParent(Node<E> node) {
    return findParent(node) != null;
  }

  /***
   * Method to check if given Node has right
   */
  public boolean hasRight(Node<E> node) {
    return node.right != null;
  }

  /**
   * Find the Right Node of given Node
   *
   * @param node
   * @return
   */
  public Node<E> right(Node<E> node) {
    if (hasRight(node)) return node.right;
    return null;
  }

  /***
   * Method to check if given Node has Left
   */
  public boolean hasLeft(Node<E> node) {
    return node.left != null;
  }

  /**
   * Find the left Node of given Node
   *
   * @param node
   * @return
   */
  public Node<E> left(Node<E> node) {
    if (hasLeft(node)) return node.left;
    return null;
  }

  /**
   * Method to check if is a leaf Node
   *
   * @param node
   * @return
   */
  public boolean isLeaf(Node<E> node) {
    return !hasLeft(node) && !hasRight(node);
  }

  /**
   * Method to get depth of the tree
   * This is considered as Level as well
   *
   * @param node
   * @return {@link int}
   */
  public int getDepth(Node<E> node) {
    /* If given node is null, size is zero */
    if (node == null) {
      return 0;
    }
    /* Get the depth of left and right.
     * Whichever is greater, return that and add
     * one for root */
    int left = getDepth(node.left);
    int right = getDepth(node.right);
    return left > right ? left + 1 : right + 1;
  }

  /**
   * Method to print the tree InOrder
   * InOrder : Left -> Root -> Right
   *
   * @param node
   */
  public void printInOrder(Node<E> node) {
    /* If root is null, return else print
     * in order specified above */
    if (node == null) {
      return;
    }
    printInOrder(node.left);
    System.out.print(node.data + " ");
    printInOrder(node.right);
  }

  /**
   * Method to print the tree PreOrder
   * PreOrder : Root -> Left -> Right
   *
   * @param node
   */
  public void printPreOrder(Node<E> node) {
    /* If root is null, return else print
     * in order specified above */
    if (node == null) {
      return;
    }
    System.out.print(node.data + " ");
    printPreOrder(node.left);
    printPreOrder(node.right);
  }

  /**
   * Print the Tree in PreOrder Fashion using Iterative Algorithm
   * @param node
   */
  public void printPreOrderRecursive(Node<E> node) {
    if (node == null) {
      return;
    }

    Stack<Node> stk = new Stack<Node>();
    stk.add(node);

    System.out.println();
    while (!stk.empty()) {
      Node treeNode = stk.pop();
      System.out.print(treeNode.data + " ");

      if (treeNode.right != null) {
        stk.add(treeNode.right);
      }

      if (treeNode.left != null) {
        stk.add(treeNode.left);
      }
    }
    System.out.println();
  }

  public void printPostOrderIterative(Node<E> root) {
    if (root == null) {
      return;
    }

    Stack<Node> stack = new Stack<>();
    stack.push(root);
    Node previousNode = null;

    while (!stack.isEmpty()) {
      Node currentNode = stack.pop();

      if (!isLeaf(currentNode)) {
        if (
          (currentNode.right != null && currentNode.right == previousNode) ||
          (currentNode.right == null && currentNode.left == previousNode)
        ) {
          System.out.print(currentNode.data + " ");
        } else {
          stack.push(currentNode);
          if (currentNode.right != null) {
            stack.push(currentNode.right);
          }

          if (currentNode.left != null) {
            stack.push(currentNode.left);
          }
        }
      } else {
        System.out.print(currentNode.data + " ");
      }

      previousNode = currentNode;
    }
  }

  /**
   * Method to print the tree PostOrder
   * PostOrder : Left -> Right -> Root
   *
   * @param node
   */
  public void printPostorder(Node<E> node) {
    /* If root is null, return else print
     * in order specified above */
    if (node == null) {
      return;
    }
    printPostorder(node.left);
    printPostorder(node.right);
    System.out.print(node.data + " ");
  }
}
