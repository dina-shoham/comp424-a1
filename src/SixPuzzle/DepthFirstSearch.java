package SixPuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class DepthFirstSearch {
  
  public static Stack<Node> stack = new Stack<Node>();
  public static ArrayList<int[]> visitedStates = new ArrayList<int[]>();
  
  public static ArrayList<int[]> depthFirstSearch (int[] initState, int[] goalState) {   
    // push initial node onto stack
    Node startNode = new Node(initState, null, -1);    
    Node curNode = startNode;
    stack.push(startNode);
    
    // keep track of visited states
    visitedStates.add(initState);
    
    // while goal state has not been reached, keep searching (DFS)
    while(!Arrays.equals(curNode.state, goalState)) {
      curNode = stack.pop();
      
      ArrayList<Node> nextNodes = Main.getNextNodes(curNode);
      Collections.reverse(nextNodes); // have to reverse nextStates so that we prefer moving lower-numbered tiles
      
      for(Node n : nextNodes) {
        // push all unvisited states
        if (!Main.isStateVisited(n.state, visitedStates)) {
          visitedStates.add(n.state);
          n.par = curNode;
          stack.push(n);
        }
      }      
    }
    
    // rebuild solution path
    ArrayList<int[]> solutionPath = new ArrayList<int[]>();
    while(curNode.par != null) {
      solutionPath.add(curNode.state);
      curNode = curNode.par;
    }
    solutionPath.add(initState);
    
    Collections.reverse(solutionPath);
    return solutionPath;
    
  }
     
}
