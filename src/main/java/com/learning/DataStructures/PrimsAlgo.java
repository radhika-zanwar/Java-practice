package com.learning.DataStructures;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
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
    public static void createGrpahPA(ArrayList<Edge>[] graphPA) {
        for(int i=0; i < graphPA.length; i++) {
            graphPA[i] = new ArrayList<>();
        }
        graphPA[0].add(new Edge(0,1,10));
        graphPA[0].add(new Edge(0,2,15));
        graphPA[0].add(new Edge(0,3,30));

        graphPA[1].add(new Edge(1,3,40));
        graphPA[1].add(new Edge(1,0,10));

        graphPA[2].add(new Edge(2,0,15));
        graphPA[2].add(new Edge(2,3,50));

        graphPA[3].add(new Edge(3,0,30));
        graphPA[3].add(new Edge(3,1,40));
        graphPA[3].add(new Edge(3,2,50));
    }
    static class Pair implements Comparable<Pair>{
        int cost;
        int node;
        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p1) {
            return this.cost - p1.cost;
        }
    }
    public static void primAlgo(ArrayList<Edge>[] graphPA, int src, int V) {
        boolean[] visit = new boolean[V]; // mst set
        int mstCost = 0;
        PriorityQueue<Pair> PQ = new PriorityQueue<>(); // non-mst set
        PQ.add(new Pair(0,0));
        while(!PQ.isEmpty()) {
            Pair curr = PQ.remove();
            if(!visit[curr.node]) {
                visit[curr.node] = true;
                mstCost = mstCost + curr.cost;
                for(int i =0; i < graphPA[curr.node].size(); i++) {
                    Edge e = graphPA[curr.node].get(i);
                    if(!visit[e.dest]) {
                        PQ.add(new Pair(e.dest,e.weight));
                    }
                }

            }
        }
        System.out.println("Min cost of mst is " + mstCost);
    }


    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graphPA = new ArrayList[V];
        createGrpahPA(graphPA);
        primAlgo(graphPA,0,V);

    }
}
