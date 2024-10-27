package greedy;


import java.util.*;

class Graph {
    private Map<String, List<String>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String v1, String v2) {
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
    }

    public void removeVertex(String vertex) {
        List<String> adjacentVertices = adjacencyList.get(vertex);
        if (adjacentVertices != null) {
            for (String adjacent : adjacentVertices) {
                adjacencyList.get(adjacent).remove(vertex);
            }
        }
        adjacencyList.remove(vertex);
    }

    public void displayGraph() {
        List<String> sortedCities = new ArrayList<>(adjacencyList.keySet());
        Collections.sort(sortedCities);

        for (String city : sortedCities) {
            List<String> neighbors = adjacencyList.get(city);
            Collections.sort(neighbors);
            System.out.print(city + ": ");
            System.out.println(neighbors);
        }
    }
}

class AP_removeVertex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); 

        Graph g = new Graph();

        for (int i = 0; i < n; i++) {
            String city = sc.nextLine();
            g.addVertex(city);
        }

        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            String[] edge = sc.nextLine().split(" ");
            g.addEdge(edge[0], edge[1]);
        }

        String cityToRemove = sc.nextLine();

        System.out.println("Before removing vertex " + cityToRemove);
        g.displayGraph();

        g.removeVertex(cityToRemove);

        System.out.println("After removing vertex " + cityToRemove);
        g.displayGraph();
    }
}
/*You are given an undirected graph that represents a set of cities, where each city is connected to other cities by direct routes. 
The graph is represented using an adjacency list. 
Your task is to remove a specific city (vertex), which will be provided as input by the user, and its associated routes (edges) from the graph.

Write a program that:
	-Takes the list of cities and direct routes between them as input.
	-Removes the city and its connections (if it exists) as specified by the user.
	-Prints the adjacency list of the graph before and after removing the vertex.

Input Format:
-------------
The first line contains an integer n (the number of cities).
The next n lines contain the names of the cities.
The following integer m represents the number of direct routes (edges) between cities.
The next m lines contain pairs of strings (v1, v2) representing a direct route between two cities.
The last line contains the name of the city to be removed.

Output Format:
--------------
First, print the adjacency list of the graph before removing the city.
Then, remove the city (if it exists) and print the adjacency list after removing the city.

Constraints:
------------
*There are no duplicate cities in the list.
*There are no duplicate edges in the graph.
*1 ≤ n ≤ 100
*1 ≤ m ≤ 500

Sample Input-1:
---------------
5
Dallas
Tokyo
Aspen
LosAngeles
HongKong
6
Dallas Tokyo
Dallas Aspen
HongKong Dallas
LosAngeles HongKong
LosAngeles Aspen
HongKong Tokyo
Aspen

Sample Output-1:
----------------
Before removing vertex Aspen
HongKong: [Dallas, LosAngeles, Tokyo]
Tokyo: [Dallas, HongKong]
LosAngeles: [HongKong, Aspen]
Dallas: [Tokyo, Aspen, HongKong]
Aspen: [Dallas, LosAngeles]

After removing vertex Aspen
HongKong: [Dallas, LosAngeles, Tokyo]
Tokyo: [Dallas, HongKong]
LosAngeles: [HongKong]
Dallas: [Tokyo, HongKong]
 */
