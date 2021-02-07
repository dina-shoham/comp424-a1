package SixPuzzle;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  
  public static void main(String[] args) {
    int[] initState = new int[] {1, 4, 2, 0, 3, 5};
    int[] goalState = new int[] {0, 1, 2, 3, 4, 5};
    
    System.out.println("-------------DEPTH FIRST SEARCH-------------");
    ArrayList<int[]> dfspath = DepthFirstSearch.depthFirstSearch(initState, goalState);
    for(int[] st : dfspath) {
      System.out.println(Arrays.toString(st));
    }
    
    System.out.println("\n-------------BREADTH FIRST SEARCH-------------");
    ArrayList<int[]> bfspath = BreadthFirstSearch.breadthFirstSearch(initState, goalState);
    for(int[] st : bfspath) {
      System.out.println(Arrays.toString(st));
    }
    
    
  }

  /* takes a state and returns possible next states
   * 
   * states represented by array of 6 ints
   * elements 0-2 represent top row left to right
   * elements 3-6 represent bottom row right to left
   * empty slot represented by 0
   * eg. | 1 | 4 | 2 | is represented by [1, 4, 2, 0, 3, 5]
   *     | 5 | 3 |   |
   */
  public static ArrayList<int[]> getNextStates(int[] curState) {
    ArrayList<int[]> nextStates = new ArrayList<int[]>();
    
    // determine indeces of tiles that can move depending on where the space is
    int i = getIndexOfSpace(curState);
    // System.out.println("space is in index " + i);
    ArrayList<int[]> movableTiles = new ArrayList<int[]>();
    
    switch (i) {
      case 0:
//        System.out.println("case 0");
        movableTiles.add(new int[] {0, 1});
        movableTiles.add(new int[] {0, 5});
        break;       
      case 1: 
//        System.out.println("case 1");
        movableTiles.add(new int[] {1, 0});
        movableTiles.add(new int[] {1, 2});
        movableTiles.add(new int[] {1, 4});
        break;
      case 2: 
//        System.out.println("case 2");
        movableTiles.add(new int[] {2, 1});
        movableTiles.add(new int[] {2, 3});
        break;
      case 3: 
//        System.out.println("case 3");
        movableTiles.add(new int[] {3, 2});
        movableTiles.add(new int[] {3, 4});
        break;
      case 4: 
//        System.out.println("case 4");
        movableTiles.add(new int[] {4, 1});
        movableTiles.add(new int[] {4, 3});
        movableTiles.add(new int[] {4, 5});
        break;
      case 5: 
//        System.out.println("case 5");
        movableTiles.add(new int[] {5, 0});
        movableTiles.add(new int[] {5, 4});
        break;  
      default: 
        new IllegalArgumentException("smth wrong with your state");
        break;
    }
    
    // generate list of new states
    for(int j = 0; j < movableTiles.size(); j++) {
      int[] newState = swapElements(curState, movableTiles.get(j)[0], movableTiles.get(j)[1]);
      //System.out.println("adding new state "+Arrays.toString(newState));
      nextStates.add(newState);
    }
    
    return nextStates;
  }
  
  // gets index of array that contains 0
  public static int getIndexOfSpace (int[] state) {
    int i;
    for(i = 0; i < 6; i++) {
      if(state[i] == 0) break;
    }
    return i;
  }
  
  // creates a new state that is the provided state, but with elements at index i and j swapped
  public static int[] swapElements (int[] state, int i, int j) {
    //System.out.println("swapping "+state[i]+" with "+state[j]);
    int[] swapped = new int[6];
    for (int k = 0; k < 6; k++) {
      if (k == i) {
        swapped[k] = state[j];
      }
      else if (k == j) {
        swapped[k] = state[i];
      }
      else {
        swapped[k] = state[k];
      }
    }
    return swapped;
  }
  
  //if state already visited return true
   public static Boolean isStateVisited(int[] state, ArrayList<int[]> visitedStates) {
     for(int[] s : visitedStates) {
       if (Arrays.equals(state, s)) {
         return true;
       }
     }
     return false;
   }
  
}
