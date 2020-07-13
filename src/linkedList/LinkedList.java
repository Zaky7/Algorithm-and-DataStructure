package linkedList;

import static java.lang.System.out;

class LinkedList {

    private Node head;
    private Node last;
    private int _size = 0;

    static class Node   {

        private int value;
        private Node next;


        Node(int val) {
            this.value = val;
            this.next = null;
        }

        public static Node createNewNode(int val) {
            return new Node(val);
        }

    }


    public void add(int ele) {
        Node newNode = Node.createNewNode(ele);
        _size++;

        if(head == null) {
            head = newNode;
            last = newNode;
            return;
        }

        Node start = last;
        start.next = newNode;
        // point last to new Node
        last = newNode;
    }


    public void displayLL() {
        Node current = head;
        while (current != null) {
            out.print(current.value + " --> ");
            current = current.next;
        }
        out.println();
    }

    public int size() {
        return this._size;
    }
}