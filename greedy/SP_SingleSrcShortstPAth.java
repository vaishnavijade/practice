package greedy;

import java.util.*;
import java.io.*;

class SP_SingleSrcShortstPAth {
	static int V;

	int minDistance(int dist[], Boolean spt[]) {
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < V; v++) {
			if (spt[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		}
		return min_index;
	}

	void printSolution(int dist[], int src) {
		System.out.println("Vertex \t Distance from Source ");
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t " + dist[i]);
	}

	void dijkstra(int graph[][], int src) {
		int dist[] = new int[V];
		Boolean spt[] = new Boolean[V];
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			spt[i] = false;
		}
		dist[src] = 0;
		for (int count = 0; count < V - 1; count++) {
			int u = minDistance(dist, spt);
			spt[u] = true;
			for (int v = 0; v < V; v++) {
				if (!spt[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		printSolution(dist, src);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		V = r;
		int[][] graph = new int[r][r];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < r; j++)
				graph[i][j] = sc.nextInt();
		}
		SP_SingleSrcShortstPAth t = new SP_SingleSrcShortstPAth();
		int srcVertex = sc.nextInt();
		t.dijkstra(graph, srcVertex);
		sc.close();
	}
}
/*Given a directed graph represented by an adjacency matrix, where each entry graph[i][j] represents the weight of the edge from vertex i to vertex j. If graph[i][j] is 0, it means there is no direct edge between i and j.

Your task is to determine the shortest paths from a given source vertex to all other vertices using Dijkstra’s algorithm.

Input Format:
-------------
Line-1: An integer N, representing the number of vertices in the graph.
Next-N lines: Each line contains N space-separated integers representing the adjacency matrix graph.
Last-line: An integer src, representing the source vertex.

Output Format:
--------------
A line that says: "Vertex 		Distance from Source".
Followed by N lines, each containing the vertex number and its shortest distance from the source.

Constraints:
------------
*1 <= N <= 100
*0 <= graph[i][j] <= 1000
*0 <= src < N
*All weights are non-negative integers.

Sample Input-1:
---------------
5
0 6 5 0 13
6 0 12 9 5
5 12 0 0 0
0 9 0 0 7
13 5 0 7 0
2

Sample Output-1:
----------------
Vertex           Distance from Source
0                5
1                11
2                0
3                20
4                16

Sample Input-2:
---------------
9
0 4 0 0 0 0 0 8 0
4 0 8 0 0 0 0 11 0
0 8 0 7 0 4 0 0 2
0 0 7 0 9 14 0 0 0
0 0 0 9 0 10 0 0 0
0 0 4 14 10 0 2 0 0
0 0 0 0 0 2 0 1 6
8 11 0 0 0 0 1 0 7
0 0 2 0 0 0 6 7 0
5

Sample Output-2:
----------------
Vertex           Distance from Source
0                11
1                12
2                4
3                11
4                10
5                0
6                2
7                3
8                6 */
