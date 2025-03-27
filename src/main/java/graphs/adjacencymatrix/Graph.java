package graphs.adjacencymatrix;

import java.util.Stack;

public class Graph {
    private int[][] adjacencyMatrix;

    public Graph(int n) {
        adjacencyMatrix = new int[n][n];
    }

    public void addEdge(int n1, int n2) {
        adjacencyMatrix[n1][n2] = 1;
    }

    public void printNodesWithoutOutgoingEdges() {
        for (int i = 0 ; i < adjacencyMatrix.length; i++) {
            boolean hasNeighbor = false;
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j] == 1)
                    hasNeighbor = true;
            }
            if (!hasNeighbor)
                System.out.println(i);
        }
    }

    public void printNodesWithoutIncomingEdges() {
        for (int i = 0 ; i < adjacencyMatrix.length; i++) {
            boolean flag = false;
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[j][i] == 1)
                    flag = true;
            }
            if (!flag)
                System.out.println(i);
        }
    }

    /** A helper method for dfsMain - runs DFS once from the given source vertex
     *
     * @param vertex source vertex
     * @param visited an array, where for each vertex id we store true if it has been visited,
     * and false otherwise
     */
    public void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(vertex);
        // Iterate over outgoing edges of this vertex
        // For each edge, get the neighbor, and if it has not been visited, call dfs recursively on the neighbor
        for (int j = 0; j < adjacencyMatrix.length; j++) {
            if (adjacencyMatrix[vertex][j] == 1 && !visited[j])
                dfs(j,visited);
        }

    }

    /**
     * Iterative DFS implementation that uses a stack.
     * @param vertex source vertex
     * @param addedToStack array that stores true for each vertex id that has been already added to the stack, and false otherwise
     */
    public void dfsWithStack(int vertex, boolean[] addedToStack) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex); // push the source vertex onto the stack
        addedToStack[vertex] = true;

        while (!stack.isEmpty()) {
            // pop the vertex from the stack, mark it as "addedToStack"
            // iterate over the neighbors
            // if the neighbor has not been added to the stack, push it onto the stack
            int currVertex = stack.pop();
            System.out.println(currVertex); // this is when we formally visit the vertex during DFS
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[currVertex][j] == 1 && !addedToStack[j]) {
                    addedToStack[j] = true; // to prevent adding duplicates to the stack
                    stack.push(j);
                }
            }
        }

    }


    /** Runs dfs starting from each vertex that has not been visited.
     * Makes sure all vertices are visited (may involve running dfs several times).
     * If the graph is connected, it would be enough to run dfs once.
     */
    public void dfsMain() {
        boolean visited[]  = new boolean[adjacencyMatrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                dfs(i, visited);
            // dfsWithStack(i, visited); // instead of calling recursive dfs, we could call dfsWithStack
        }
    }

}
