package com.learning.DataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
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
    public static int idx = -1;

    public static Node BuildTree(int[] nodes) {
         idx++;
           if(nodes[idx] == -1) {
               return null;
           }
           Node n = new Node(nodes[idx]);
           n.left = BuildTree(nodes);
           n.right = BuildTree(nodes);
           return n;
       }
       public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
           System.out.print(root.data + " ");
           preOrder(root.left);
           preOrder(root.right);
       }
       public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
       }
       public static void levelOrder(Node root) {
        if(root == null) {
            return;
        }
           Queue<Node> queue = new LinkedList<>();
           queue.add(root);
           queue.add(null);
          while(!queue.isEmpty()) {
              Node curr = queue.remove();
              if(curr == null) {
                  System.out.println();
                  if(queue.isEmpty()) {
                      break;
                  }
                  else {
                      queue.add(null);
                  }
              }
              else {
                  System.out.print(curr.data + " ");
                  if(curr.left != null) {
                      queue.add(curr.left);
                  }
                  if(curr.right != null) {
                      queue.add(curr.right);
                  }
              }

          }

       }
       public static int countOfNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int left = countOfNodes(root.left);
        int right= countOfNodes(root.right);
        return left + right + 1;
       }
       public static void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
       }
       public static int sumOfNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);
        return left + right + root.data;
       }
       public static int heightOfTree(Node root) {
        if(root == null) {
            return 0;
        }
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        return Math.max(left , right) + 1;
       }
       public static int diameter(Node root) {
        if(root == null) {
            return 0;
        }
        int dia1 = diameter(root.left);
        int dia2 = diameter(root.right);
        int dia3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;
        int dia = Math.max(Math.max(dia1 ,dia2),dia3);
        return dia;
       }
       public static boolean subTree(Node root, Node subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if(root == null || subRoot == null) {
            return false;
        }
        if(root.data == subRoot.data) {
           boolean left = subTree(root.left,subRoot.left);
           boolean right = subTree(root.right,subRoot.right);
           if(left && right) {
               return true;
           }
        }
        return subTree(root.left,subRoot) || subTree(root.right, subRoot);
       }

       public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int[] n = {2,4,-1,-1,5,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.BuildTree(nodes);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println(countOfNodes(root));
        System.out.println(sumOfNodes(root));
        System.out.println(heightOfTree(root));
        System.out.println(diameter(root));
        idx=-1;
        BinaryTree tr2 = new BinaryTree();
        Node subRoot = tr2.BuildTree(n);
        preOrder(subRoot);
        System.out.println(subTree(root,subRoot));
    }
}
