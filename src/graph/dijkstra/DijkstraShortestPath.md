# Dijkstra Shortest Path

        /**
         *
         *    C-- ----2-----  E
         *    |               |
         *    3               4
         *    |               |
         *    A---------8----- D
         *    \                |
         *     1               2
         *      \              |
         *       F -----3----- B
         **/

Pseudocode of Dijkstra

Binary Heap

- Extract Min O(1)
- Contains: O(1)
- Decrease value O(log n)
- Add O(logn)

HashMap of vertices and their current shortest distance

Another HashMap of vertices and thier parent
