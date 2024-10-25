package greedy;

import java.util.*;

public class dijkstras {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));

        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(6, 5, 1));
    }

    public static class pair implements Comparable<pair>{ //interface 
        int node; int dist;
        public pair(int n,int d){
            node=n; dist=d;}
            @Override
            public int compareTo(pair p2){
                return this.dist - p2.dist;//ascending 
            }
    }
  
    public static void dijkstra(ArrayList<Edge> graph[], int src,int V){
        PriorityQueue<pair> pq= new PriorityQueue<>();
        int dist[]=new int[V];
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        boolean visited[]=new boolean[V];
        pq.add(new pair(0, 0) );
        // bfs
        while(!pq.isEmpty()){
            pair curr=pq.remove();//shortest
            if(!visited[curr.node]){
                visited[curr.node]=true;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    int u=e.src;
                    int v=e.dest;
                    if(dist[u]+e.wt<dist[v]){
                        dist[v]=dist[u]+e.wt;
                    }

                }
            }
        }   
























    }
    public static void main(String[] args){
        int V=6;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
    }
}
