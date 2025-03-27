package graphs.adjacencymatrix;

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
}
