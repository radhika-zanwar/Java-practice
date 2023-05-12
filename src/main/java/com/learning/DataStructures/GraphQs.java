package com.learning.DataStructures;

import java.util.ArrayList;
import java.util.Stack;

public class GraphQs {
     static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;

        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
            //graph[0].add(new Edge(0,2));
            //graph[1].add(new Edge(1,0));
            graph[2].add(new Edge(2,3));
            graph[3].add(new Edge(3,1));
            graph[4].add(new Edge(4,0));
            graph[4].add(new Edge(4,1));
            graph[5].add(new Edge(5,0));
            graph[5].add(new Edge(5,2));
        }

    public static boolean isCyclic(ArrayList<Edge> graph[], int curr, boolean[] visit, boolean[] rec) {
        visit[curr] = true;
        rec[curr] = true;
        for(int i=0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(rec[e.dest] == true) {
                return true;
            }
            else if(visit[e.dest] == false){
                if(isCyclic(graph,e.dest,visit,rec)) {
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }
    public static void topSort(ArrayList<Edge> graph[], int curr, boolean[] visitedForTopo, Stack<Integer> stc) {
        visitedForTopo[curr] = true;
         for(int i=0; i < graph[curr].size(); i++) {
             Edge e = graph[curr].get(i);
             if(!visitedForTopo[e.dest]) {
                 topSort(graph, e.dest, visitedForTopo, stc);
             }
         }
        stc.push(curr);
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean[] visit = new boolean[V];
        boolean[] visitedForTopo = new boolean[V];
        boolean[] rec = new boolean[V];
        for(int i=0; i < V; i++) {
            if(!visit[i]) {
                isCyclic(graph,i,visit,rec);
            }
        }
        Stack<Integer> stc = new Stack<>();
        for(int i=0; i < V; i++) {
            if(!visitedForTopo[i]) {
                topSort(graph, i, visit, stc);
            }
        }
        while(!stc.isEmpty()) {
            System.out.print(stc.pop() + " ");
        }

     }
}
