package com.learning.DataStructures;

import java.util.ArrayList;

public class TarjanAlgo {
    static class Edge {
        int src;
        int dest;
        public Edge(int src, int dest) {
            this.src = src;
            this.dest =dest;
        }
    }
    public static void createGraphTA(ArrayList<Edge>[] graphTA) {
        for(int i=0; i < graphTA.length; i++) {
            graphTA[i] = new ArrayList<>();
        }
        graphTA[0].add(new Edge(0,1));
        graphTA[0].add(new Edge(0,2));
        graphTA[0].add(new Edge(0,3));

        graphTA[1].add(new Edge(1,0));
        graphTA[1].add(new Edge(1,2));

        graphTA[2].add(new Edge(2,0));
        graphTA[2].add(new Edge(2,1));

        graphTA[3].add(new Edge(3,0));
        graphTA[3].add(new Edge(3,4));
        //graphTA[3].add(new Edge(3,5));

        graphTA[4].add(new Edge(4,3));
        //graphTA[4].add(new Edge(4,5));

        //graphTA[5].add(new Edge(5,3));
        //graphTA[5].add(new Edge(5,4));
    }
    public static void dfs(ArrayList<Edge>[] graphTA, int parent, int[] low, int[] dt, boolean[] visit, int curr, int time) {
        visit[curr] = true;
        dt[curr] = low[curr] = ++time;
        for(int i=0; i < graphTA[curr].size(); i++) {
            Edge e = graphTA[curr].get(i);
            if(e.dest == parent) {
                continue;
            }
            else if(!visit[e.dest]) {
                dfs(graphTA,curr,low,dt,visit,e.dest,time);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if(dt[curr] < low[e.dest]) {
                    System.out.println("Bridge is from " + curr + " to " + e.dest);
                }
            }
            else {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }
    public static void bridgeInGraph(ArrayList<Edge>[] graphTA,int V) {
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean[] visit = new boolean[V];
        for(int i=0; i < V; i++) {
            if(!visit[i]) {
                dfs(graphTA,-1, low, dt, visit, i, time);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graphTA = new ArrayList[V];
        createGraphTA(graphTA);
        bridgeInGraph(graphTA,V);
    }
}
