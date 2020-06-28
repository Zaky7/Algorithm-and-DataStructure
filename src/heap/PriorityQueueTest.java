package heap;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String args[]) 
    { 
        // Creating empty priority queue 
		// Asc order
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((a,b) -> (b - a)); 
        
        // Desc order
//        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((a,b) -> (b - a)); 
  
        // Adding items to the pQueue using add() 
        pQueue.add(10); 
        pQueue.add(20); 
        pQueue.add(15); 
  
        // Printing the top element of PriorityQueue 
        System.out.println(pQueue.peek()); 
  
        // Printing the top element and removing it 
        // from the PriorityQueue container 
        System.out.println(pQueue.poll()); 
  
        // Printing the top element again 
        System.out.println(pQueue.peek()); 
    } 
}
