package com.learning.DataStructures;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgo {
    static class Edge {
        int src;
        int dest;
        int weight;
        public Edge(int src, int dest,int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void createGraphDA(ArrayList<Edge>[] graph) {
        for(int i=0; i < graph.length;i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }
    static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int node , int dist) {
            this.node = node;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair p1) {
            return this.dist - p1.dist;
        }
    }
    public static void DA(ArrayList<Edge>[] graphDA, boolean[] visit, int[] dist,int src) {
        PriorityQueue<Pair> PQ = new PriorityQueue<>();
        PQ.add(new Pair(0,0));
        for(int i =0; i < dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
            else {
                dist[i] = 0;
            }
        }
        while(!PQ.isEmpty()) {
            Pair curr = PQ.remove();
            if(!visit[curr.node]) {
                visit[curr.node] = true;
                for(int i=0; i < graphDA[curr.node].size(); i++) {
                    Edge e = graphDA[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    // Relaxation
                    if(dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight;
                        PQ.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
        for(int i=0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }

    }


    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graphDA = new ArrayList[V];
        createGraphDA(graphDA);
        boolean[] visit = new boolean[V];
        int[] dist = new int[V];
        DA(graphDA,visit,dist,0);

    }
}
