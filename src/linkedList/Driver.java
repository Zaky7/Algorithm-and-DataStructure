package linkedList;

import static java.lang.System.out;

class Driver {

  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.add(2);
    ll.displayLL();

    ll.add(3);
    ll.add(5);
    ll.add(4);

    ll.displayLL();

    out.println(ll.size());
  }
}
