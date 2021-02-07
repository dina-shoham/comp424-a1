package SixPuzzle;

import java.util.Comparator;

public class Node implements Comparator<Node> {
  int[] state; // state
//  int depth; // depth in tree
  Node par; // parent node
  int tileMoved; // operation to get from prev state to this one. tileMoved = -1 indicates start position

  public Node() {}
  
  public Node(int[] state, Node par, int tileMoved) {
    this.state = state;
//    this.depth = depth;
    this.par = par;
    this.tileMoved = tileMoved;
  }
  
  public Node(int[] state, int tileMoved) {
    this.state = state;
//    this.depth = depth;
    this.tileMoved = tileMoved;
  }
  
  @Override 
  public int compare(Node n1, Node n2) {
    //sort by increasing tileMoved
    if(n1.tileMoved < n2.tileMoved) {
      return -1;
    }
    else if(n1.tileMoved > n2.tileMoved) {
      return 1;
    }
    else {
      return 0;
    }
  }   

}
