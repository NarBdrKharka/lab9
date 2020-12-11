import java.util.NoSuchElementException;
import java.util.*;
import java.util.LinkedList;

public class Lab009 {

    private final int V; // number of vertices
    private int E; // number of edges
    private LinkedList<Integer>[] adj;

    /**
     * Initializes an empty graph with {@code V} vertices and 0 edges. param V the
     * number of vertices
     * 
     * @param V number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Lab009(int V) {
        if (V < 0)
            throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }
    /**
     * Initializes a graph from the specified input stream. The format is the number
     * of vertices <em>V</em>, followed by the number of edges <em>E</em>, followed
     * by <em>E</em> pairs of vertices, with each entry separated by whitespace.
     * 
     * @param in the input stream
     * @throws IllegalArgumentException if {@code in} is {@code null}
     * @throws IllegalArgumentException if the endpoints of any edge are not in
     *                                  prescribed range
     * @throws IllegalArgumentException if the number of vertices or edges is
     *                                  negative
     * @throws IllegalArgumentException if the input stream is in the wrong format
     */
    // public Graph(In in) {

    // }
    /**
     * Returns the number of vertices in this graph.
     * 
     * @return the number of vertices in this graph
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int E() {
        return E;

    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));

    }

    /**
     * Adds the undirected edge v-w to this graph.
     * 
     * @param v one vertex in the edge
     * @param w the other vertex in the edge
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and
     *                                  {@code 0 <= w < V}
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);

    }

    /**
     * Returns the vertices adjacent to vertex {@code v}.
     * 
     * @param v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns a string representation of this graph.
     * 
     * @return the number of vertices <em>V</em>, followed by the number of edges
     *         <em>E</em>, followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Unit tests the {@code Graph} data type.
     * 
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Lab009 object = new Lab009(6);
        object.addEdge(0, 1);
        object.addEdge(0, 3);
        object.addEdge(1, 2);
        object.addEdge(1, 3);
        object.addEdge(1, 4);
        object.addEdge(3, 4);
        object.addEdge(4, 5);
        object.addEdge(2, 5);

        object.validateVertex(3);

        System.out.println(object.toString());
    }
}