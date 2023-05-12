package com.learning.DataStructures;

import java.util.ArrayList;

public class BellmanFordAlgo {
    static class Edge {
        int src;
        int dest;
        int weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void createGraphBF(ArrayList<Edge>[] graphBF) {
        for(int i=0; i < graphBF.length; i++) {
            graphBF[i] = new ArrayList<>();
        }
        graphBF[0].add(new Edge(0,1,2));
        graphBF[0].add(new Edge(0,2,4));

        graphBF[1].add(new Edge(1,2,-4));

        graphBF[2].add(new Edge(2,3,2));

        graphBF[3].add(new Edge(3,4,4));

        graphBF[4].add(new Edge(4,1,-1));

    }
    public static void bellmanFord(ArrayList<Edge>[] graph,int V,int src) {
        int[] dist = new int[V];
        for(int i=0; i < dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
            else {
                dist[i] = 0;
            }
        }
        for(int k=0; k < V-1; k++) {
            for(int i=0; i < V ;i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight;
                    }
                }
            }
        }
        for(int i=0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graphBF = new ArrayList[V];
        createGraphBF(graphBF);
        bellmanFord(graphBF,V,0);
    }
}
