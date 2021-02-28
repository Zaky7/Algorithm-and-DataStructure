package heap;

public class HeapDriver {

  public static void main(String[] args) {
    //    HeapDriver driver = new HeapDriver();
    //    driver.heapDriver2();

    BinaryMinHeap<String> binaryHeap = new BinaryMinHeap<>();

    binaryHeap.add(10, "A");
    binaryHeap.add(1, "B");
    binaryHeap.add(5, "C");
    binaryHeap.add(6, "D");

    binaryHeap.toString();

    System.out.println(binaryHeap.containsKey("C"));
    System.out.println(binaryHeap.containsKey("F"));

    binaryHeap.decrease("A", 2);

    binaryHeap.toString();

    binaryHeap.poll();

    binaryHeap.toString();
  }

  private void heapDriver1() {
    MaxIntHeap mh = new MaxIntHeap(10);
    int[] arr = { 100, 20, 1, 8, 14, 56, 6, 0, 20 };
    print(mh.getCapacity());

    for (int element : arr) mh.add(element);

    mh.printHeap();

    mh.poll();
    // mh.poll();
    mh.printHeap();
  }

  public static void print(Object o) {
    System.out.println(o.toString());
  }
}
