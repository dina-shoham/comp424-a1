package SixPuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BreadthFirstSearch {
  public static ArrayList<Node> queue = new ArrayList<Node>();
  public static ArrayList<int[]> visitedStates = new ArrayList<int[]>();
  
  public static ArrayList<int[]> breadthFirstSearch (int[] initState, int[] goalState) {  
    // enqueue initial node
    Node startNode = new Node(initState, 0, null);    
    Node curNode = startNode;
    queue.add(startNode);
    
    // keep track of visited states
    visitedStates.add(initState);
    
    // while goal state has not been reached, keep searching (DFS)
    while(!Arrays.equals(curNode.state, goalState)) {
      // dequeue first node in queue
      curNode = queue.get(0);
      queue.remove(0);
      
      // get next states
      ArrayList<int[]> nextStates = Main.getNextStates(curNode.state);
      for(int[] st : nextStates) {       
        // enqueue all unvisited states
        if (!Main.isStateVisited(st, visitedStates)) {
          visitedStates.add(st);
          Node n = new Node(st, curNode.depth++, curNode);
          queue.add(n);
        }
      }      
    }
    
    // rebuild solution path
    ArrayList<int[]> solutionPath = new ArrayList<int[]>();
    while(curNode.par != null) {
      solutionPath.add(curNode.state);
      curNode = curNode.par;
    }
    
    Collections.reverse(solutionPath);
    return solutionPath;
    
  }
    
}
