package greedy;

public class SP_KrushkalsMST {
    
}
import java.util.*;

class SP_KrushkalsMST {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    };

    class subset {
        int parent, rank;
    };

    int V, E;
    Edge edge[];

    SP_KrushkalsMST(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    int find(subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void KruskalMST() {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);

        subset subsets[] = new subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new subset();

        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;

        while (e < V - 1) {
            Edge next_edge = edge[i++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }

        int minimumCost = 0;
        for (i = 0; i < e; ++i)
            minimumCost += result[i].weight;
        
        System.out.println(minimumCost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        Solution graph = new Solution(V, E);
        for (int i = 0; i < E; i++) {
            graph.edge[i].src = sc.nextInt();
            graph.edge[i].dest = sc.nextInt();
            graph.edge[i].weight = sc.nextInt();
        }

        graph.KruskalMST();
    }
}
/*You are given a connected, undirected, and weighted graph with V vertices and E edges. 
Your task is to implement Kruskal's Algorithm to find the Minimum Spanning Tree (MST) of the given graph. 
The graph is represented using an edge list, where each edge connects two vertices with a specific weight.

Kruskal’s Algorithm is a greedy algorithm that sorts all the edges in non-decreasing order of their weight and picks the smallest edge, as long as it doesn’t form a cycle with the already included edges in the MST. The algorithm stops when exactly V-1 edges have been added to the MST.

Input Format:
--------------
Line-1: Two integers V and E, where V is the number of vertices and E is the number of edges.
Line-2 to E: Three integers each: u, v, and w, where u is the source vertex, v is the destination vertex, and w is the weight of the edge connecting u and v.

Output Format:
---------------
Line-1: An integer, the Minimum Cost of the spanning tree.

Constraints:
------------
*2 ≤ V ≤ 100
*1 ≤ E ≤ V(V-1)/2
*The graph is connected and undirected.
*Weights of the edges are positive integers.

Sample Input-1:
---------------
4 5
0 1 10
0 2 6
0 3 5
1 3 15
2 3 4

Sample Output-1:
----------------
19

Sample Input-2:
---------------
3 3
0 1 1
1 2 2
0 2 3

Sample Output-2:
----------------
3
 */