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
    Node startNode = new Node(initState, 0, null);    
    Node curNode = startNode;
    stack.push(startNode);
    
    // keep track of visited states
    visitedStates.add(initState);
    
    // while goal state has not been reached, keep searching (DFS)
    while(!Arrays.equals(curNode.state, goalState)) {
      curNode = stack.pop();
//      System.out.println("-------popping state "+Arrays.toString(curNode.state));
      
      ArrayList<int[]> nextStates = Main.getNextStates(curNode.state);
      for(int[] st : nextStates) {
        // push all unvisited states
        if (!Main.isStateVisited(st, visitedStates)) {
          visitedStates.add(st);
          Node n = new Node(st, curNode.depth++, curNode);
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
    
    Collections.reverse(solutionPath);
    return solutionPath;
    
  }
     
}
