package csci2081.L30;

import java.util.Arrays;
import java.util.Stack;

public class Graph {

    // variables:
    int [][] adjMatrix;
    boolean[] visited;
    int nNodes;

    // constructor:
    public Graph (int[][] adjMatrix){
        this.adjMatrix = adjMatrix;
        nNodes = adjMatrix.length;
        visited = new boolean[nNodes];
    }

    // methods:

    public void DFS()
    {
        // DFS uses a Stack data structure

        Stack<Integer> s = new Stack<Integer>();   // I use Stack class in Java's library

        // Clear visited[]
        Arrays.fill(visited, false);

        s.push(0);  // Start the "to visit" at node 0

      /* ===========================================
         Loop as long as there are "active" node
         =========================================== */
        while( ! s.isEmpty() )
        {
            int nextNode;                // Next node to visit
            int i;

            nextNode = s.pop();

            if ( ! visited[nextNode] )
            {
                visited[nextNode] = true;    // Mark node as visited
                System.out.println("nextNode = " + nextNode );

                for ( i = nNodes-1; i >= 0; i-- )
                    if ( adjMatrix[nextNode][i] > 0 && ! visited[i] )
                        s.push(i);
            }
        }
    }

    public static void main(String[] args)
    {
//                        0  1  2  3  4  5  6  7  8
// ===================================================
        int[][] conn =
                {
                        { 0, 1, 0, 1, 0, 0, 0, 0, 1 },  // 0
                        { 1, 0, 0, 0, 0, 0, 0, 1, 0 },  // 1
                        { 0, 0, 0, 1, 0, 1, 0, 1, 0 },  // 2
                        { 1, 0, 1, 0, 1, 0, 0, 0, 0 },  // 3
                        { 0, 0, 0, 1, 0, 0, 0, 0, 1 },  // 4
                        { 0, 0, 1, 0, 0, 0, 1, 0, 0 },  // 5
                        { 0, 0, 0, 0, 0, 1, 0, 0, 0 },  // 6
                        { 0, 1, 1, 0, 0, 0, 0, 0, 0 },  // 7
                        { 1, 0, 0, 0, 1, 0, 0, 0, 0 }
                };// 8


        Graph G = new Graph(conn);

        G.DFS();

    }
}
