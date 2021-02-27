package graph;

import java.util.Objects;

public class Node<T> {

  T key;
  int weight;

  public Node(int weight, T key) {
    this.key = key;
    this.weight = weight;
  }

  public int getWeight() {
    return weight;
  }

  public T getKey() {
    return key;
  }

  private void setWeight(int weight) {
    this.weight = weight;
  }

  public void update(int newWeight) {
    this.setWeight(newWeight);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Node<?> node = (Node<?>) o;
    return weight == node.weight && Objects.equals(key, node.key);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, weight);
  }

  @Override
  public String toString() {
    return "(" + key + "," + weight + ")";
  }
}
