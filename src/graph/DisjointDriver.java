package graph;

public class DisjointDriver {

  public static void main(String[] args) {
    DisjointSet ds = new DisjointSet();
    ds.makeSet(1);
    ds.makeSet(2);
    ds.makeSet(3);
    ds.makeSet(4);
    ds.makeSet(5);
    ds.makeSet(6);
    ds.makeSet(7);

    ds.union(1, 2);
    ds.union(2, 3);
    ds.union(4, 5);
    ds.union(6, 7);
    ds.union(5, 6);
    ds.union(3, 7);

    System.out.println(ds.findSet(1));
    System.out.println(ds.findSet(2));
    System.out.println(ds.findSet(3));
    System.out.println(ds.findSet(4));
    System.out.println(ds.findSet(5));
    System.out.println(ds.findSet(6));
    System.out.println(ds.findSet(7));
  }
}
