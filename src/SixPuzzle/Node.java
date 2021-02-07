package SixPuzzle;

public class Node {
  int[] state; // state
  int depth; // depth in tree
  Node par; // parent node
//  int[] op; // operation to get from prev state to this one

  public Node(int[] state, int depth, Node par) {
    this.state = state;
    this.depth = depth;
    this.par = par;
//    this.op = op;
  }

}
