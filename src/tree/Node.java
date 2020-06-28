package tree;

public class Node<T> {
  /* Left child, right child and data */
  public Node<T> left;
  public Node<T> right;
  public T data;

  /**
   * @param data
   */
  public Node(T data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  @Override
  public String toString() {
    return "Node [data=" + data + "]";
  }
}
