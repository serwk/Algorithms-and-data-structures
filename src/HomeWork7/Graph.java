package HomeWork7;

import java.util.*;

public class Graph {

    private boolean[][] adjMat;
    private List<Vertex> vertexes;


    public Graph(int maxVertexes) {
        this.adjMat = new boolean[maxVertexes][maxVertexes];
        this.vertexes = new LinkedList<>();
    }

    public void addVertex(String label) {
        Vertex vertex = new Vertex(label);
        vertexes.add(vertex);
    }

    public boolean addEdge(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex   = indexOf(endLabel);

        if ( startIndex == -1 || endIndex == -1 ) {
            return false;
        }

        adjMat[startIndex][endIndex] = true;
        adjMat[endIndex][startIndex] = true;

        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexes.size(); i++) {
            if (vertexes.get(i).getLabel().equals(label)) {
                return i;
            }
        }

        return -1;
    }

    public void display() {
        System.out.println("-------------");
        for (int i = 0; i < vertexes.size(); i++) {
            Vertex vertex = vertexes.get(i);

            StringBuilder sb = new StringBuilder(vertex.getLabel());

            for (int j = 0; j < vertexes.size(); j++) {
                if (adjMat[i][j]) {
                    sb.append(" -> " + vertexes.get(j).getLabel());
                }
            }
            System.out.println(sb.toString());
        }
        System.out.println("-------------");
    }

    public int getSize() {
        return vertexes.size();
    }

    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Unknown vertex: " + startLabel);
        }

        System.out.println("DFS:");
        System.out.println("-------------");

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexes.get(startIndex);

        visitVertex(vertex);
        stack.push(vertex);

        while ( !stack.isEmpty() ) {
            vertex = getAdjUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(vertex);
                stack.push(vertex);
            }
            else {
                stack.pop();
            }
        }

        System.out.println("-------------");

        resetVertexState();
    }

    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Unknown vertex: " + startLabel);
        }

        System.out.println("BFS:");
        System.out.println("-------------");

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexes.get(startIndex);

        visitVertex(vertex);
        queue.add(vertex);

        while ( !queue.isEmpty() ) {
            vertex = getAdjUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(vertex);
                queue.add(vertex);
            }
            else {
                queue.remove();
            }
        }

        System.out.println("-------------");

        resetVertexState();
    }

    private void resetVertexState() {
        for (Vertex vertex : vertexes) {
            vertex.setWasVisited(false);
        }
    }

    private Vertex getAdjUnvisitedVertex(Vertex vertex) {
        int index = vertexes.indexOf(vertex);
        for (int i = 0; i < vertexes.size(); i++) {
            if ( adjMat[index][i] && !vertexes.get(i).isWasVisited() ) {
                return vertexes.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Vertex vertex) {
        System.out.println(vertex);
        vertex.setWasVisited(true);
    }

    public Stack<String> findShortPathViaBfs(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Queue<Vertex> queue = new ArrayDeque();

        Vertex vertex = vertexes.get(startIndex);
        visitVertex(vertex);
        queue.add(vertex);

        while ( !queue.isEmpty()) {
            vertex = getAdjUnvisitedVertex(queue.peek());
            if (vertex == null) {
                queue.remove();
            }
            else {
                visitVertex(vertex);
                queue.add(vertex);
                vertex.setPreviousVertex(queue.peek());
                if (vertex.getLabel().equals(finishLabel)) {
                    return buildPath(vertex);
                }
            }
        }

        resetVertexState();
        return null;
    }

    private Stack<String> buildPath(Vertex vertex) {
        Stack<String> stack = new Stack();
        Vertex current = vertex;
        while (current != null) {
            stack.push(current.getLabel());
            current = current.getPreviousVertex();
        }

        resetVertexState();
        return stack;
    }

}
