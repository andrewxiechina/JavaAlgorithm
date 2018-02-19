package andrew.xie.algorithm.graph;

public class EdgeWeightedDigraph {
    private final int V; // Number of vertices
    private int E;
    private Bag<DirectedEdge>[] adj; // Adjacency list
    private int[] indegree;
}
