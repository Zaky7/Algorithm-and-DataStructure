# Bellman Ford ShortestPath

Given a graph and a source vertex v, find **shortest path** from src to all vertices in the given graph. The graph may contain the negative edges. 😬

Dijkstra doesnot work for Graph with negative weight cycle and it is a greedy Algorithm with time Complexity of _O(VLogV)_.

Bellman ford on the other hand is much simpler algorithm then Dijkstra and suits well for the distributed systems. But time complexity is **O(VE)** 🤧

### Pseudocode

```java

## Sample Graph

            B ----2----- C
           /             |
          5              3
         /               |
        A---------9----- D
        \                |
         2               2
          \              |
           E -----3----- F

- First we need to declare two maps
  > vertex to minDistance
  > vertex to parentVertex

- Now we take all edge list in any order and for each edge we would check if it can be relaxed if yes then we would update the above maps

- Also we would repeat this for all edge V - 1 times since in worst case for finding edge between given vertex we need to go V - 1. (explained in more detail later).


## Relax an Edge Logic
if (distance.get(u) + edge.getWeight() < distance.get(v)) {
    distance.put(v, distance.get(u) + edge.getWeight());
    parent.put(v, u);
}


### Dry run

## Map

Vertex  |  distance   |  parent
A       |    ∞        |  null
B       |    ∞        |  null
C       |    ∞        |  null
D       |    ∞        |  null
E       |    ∞        |  null
F       |    ∞        |  null

## Edges

U    V   Weight
A -> B = 5
B -> C = 2
C -> D = 3
D -> F = 2
F -> E = 3
E -> A = 2

Vertex  |  distance    |  parent
A       |    0         |  null
B       |    5         |  A
C       |    7        |  B
D       |    7        |  C
E       |    2        |  F
F       |    5        |  D



## Edges

U    V   Weight
A -> B = 5
B -> C = 2
C -> D = 3
D -> F = 2
F -> E = 3
E -> A = 2



5 + 0 <  INF


```
