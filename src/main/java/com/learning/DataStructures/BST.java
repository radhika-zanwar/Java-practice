package com.learning.DataStructures;

import java.util.ArrayList;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node buildTree(Node root,int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }
        if(root.data > val) {
            root.left = buildTree(root.left,val);
        }
        else {
            root.right = buildTree(root.right, val);
        }
        return root;
    }
    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static boolean search(Node root,int key) {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(root.data > key) {
           return search(root.left,key);
        }
        else {
            return search(root.right, key);
        }

    }
    public static void printInRange(Node root, int x, int y) {
        if(root == null) {
            return;
        }
        if(x <= root.data && root.data <= y) {
            printInRange(root.left,x,y);
            System.out.print(root.data + " ");
            printInRange(root.right,x,y);
        }
        if(x > root.data) {
            printInRange(root.right,x,y);
        }
        if(y < root.data) {
            printInRange(root.left,x,y);
        }
    }
    public static void printPath(ArrayList<Integer> path) {
        for (int i : path) {
            System.out.print(i + " > ");
        }
        System.out.println();
    }
    public static void root2leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null) {
            printPath(path);
        }
        root2leaf(root.left,path);
        root2leaf(root.right,path);
        path.remove(path.size()-1);

    }
    public static Node deleteNode(Node root,int val) {
        if(root.data > val) {
            root.left = deleteNode(root.left,val);
        }
        else if (root.data < val){
            root.right = deleteNode(root.right, val);
        }
        else{
            //Case 1 - 0 child
            if(root.left == null && root.right == null) {
                return null;
            }
            //Case 2 - 1 child
            if(root.left == null ) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }
            else {
                Node IS = inOrderSuccessor(root.right);
                root.data = IS.data;
                root.right = deleteNode(root.right, IS.data);
            }
        }
       return root;
    }
    public static Node inOrderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] nodes = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int i : nodes) {
            root = buildTree(root,i);
        }
        inOrder(root);
        System.out.println();
        if(search(root,4)) {
            System.out.println("key found");
        }
        else {
            System.out.println("key not found");
        }
        printInRange(root,3,8);
        System.out.println();
        root2leaf(root, new ArrayList<>());
        deleteNode(root,4);
        inOrder(root);


    }
}
