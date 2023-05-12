package com.learning.DataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphDS {
     static class Edge {
        int src;
        int dest;
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;

        }
    }
    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0;i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }
    public static void createGraphForCyclic(ArrayList<Edge>[] graph) {
         for(int i=0; i < graph.length; i++) {
             graph[i] = new ArrayList<>();
         }
         graph[0].add(new Edge(0,1));
         graph[0].add(new Edge(0,4));

         graph[1].add(new Edge(1,0));
         graph[1].add(new Edge(1,2));
         graph[1].add(new Edge(1,4));

         graph[2].add(new Edge(2,1));
         graph[2].add(new Edge(2,3));

         graph[3].add(new Edge(3,2));

         graph[4].add(new Edge(4,0));
         graph[4].add(new Edge(4,1));
         graph[4].add(new Edge(4,5));

         graph[5].add(new Edge(5,4));
     }
    public static void BFS(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[7];
        q.add(0);
        while(!q.isEmpty()) {
            int curr = q.remove();
            if(!visit[curr]) {
                System.out.print(curr + " ");
                visit[curr] = true;
                for(int i=0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void DFS(ArrayList<Edge>[] graph, int curr, boolean[] visit) {
        if(!visit[curr]) {
        System.out.print(curr + " ");
        visit[curr] = true;
        for(int i=0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            DFS(graph, e.dest, visit);
        }
        }
    }
    public static void allPaths(ArrayList<Edge>[] graph, int curr, boolean[] visit, int target, String path) {
        if(curr == target) {
            System.out.println(path);
            return;
        }
        for(int i=0; i < graph[curr].size();i++) {
            Edge e = graph[curr].get(i);
            if(!visit[e.dest]) {
                visit[curr] = true;
                allPaths(graph, e.dest, visit, target, path + e.dest);
                visit[curr] = false;
            }
        }
    }
    public static boolean isCyclic(ArrayList<Edge>[] graphForCyclic, int curr, boolean[] visit, int parent) {
         visit[curr] = true;
         for(int i=0; i < graphForCyclic[curr].size(); i++) {
             Edge e = graphForCyclic[curr].get(i);
             //Case 1
             if(visit[e.dest] && parent != e.dest) {
                 return true;
             }
             //Case 2 : do nothing if neighbour is visited and is parent
             //Case 3
             else if(!visit[e.dest]) {
                 if(isCyclic(graphForCyclic,e.dest,visit,curr)) {
                     return true;
                 }
             }
         }
         return false;
    }


    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        BFS(graph);
        System.out.println();
        boolean[] visit = new boolean[V];
        DFS(graph,0,visit);
        System.out.println();
        int src = 0;
        int target = 5;
        String path = "0";
        allPaths(graph,src,visit,target,path);

        ArrayList<Edge>[] graphForCyclic = new ArrayList[6];
        boolean[] visitForCyclic = new boolean[6];
        createGraphForCyclic(graphForCyclic);
        System.out.println(isCyclic(graphForCyclic,0,visitForCyclic,-1));

        //print neighbours of a vertex
//        for(int i =0; i<graph[2].size(); i++) {
//            Edge e = graph[2].get(i);
//            System.out.println(e.dest);
//        }
    }
}
