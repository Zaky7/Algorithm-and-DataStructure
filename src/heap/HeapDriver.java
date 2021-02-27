package heap;

public class HeapDriver {

  public static void main(String[] args) {
    HeapDriver driver = new HeapDriver();
    driver.heapDriver3();
  }

  private void heapDriver3() {
    MinIntHeap2 mh = new MinIntHeap2(14);
    int[] arr = { 100, 20, 1, 8, 14, 56, 6, 0, 21, 34, 5, 6, 23, 13, 22 };
    print(mh.getCapacity());

    for (int element : arr) mh.add(element);

    mh.printHeap();

    while (mh.heapSize != 0) {
      mh.poll();
      mh.printHeap();
    }
  }

  private void heapDriver2() {
    MaxIntHeap2 mh = new MaxIntHeap2(10);
    int[] arr = { 100, 20, 1, 8, 14, 56, 6, 0, 21, 34, 5, 6, 23, 13, 22 };
    print(mh.getCapacity());

    for (int element : arr) mh.add(element);

    mh.printHeap();

    while (mh.heapSize != 0) {
      mh.poll();
      mh.printHeap();
    }
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
