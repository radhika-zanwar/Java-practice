package com.learning.DataStructures;

import java.util.LinkedList;

  class LL {
      Node head;
      class Node {
          String data;
        Node next;
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
       LL list = new LL();
       list.addFirst("5");
       list.addFirst("4");
       list.addFirst("3");
       list.addFirst("2");
       list.addFirst("1");
       //list.reverseItr();
       list.printList();
       list.removeNth(2);
       list.printList();


    }
    public void addFirst(String data) {
        Node new1 = new Node(data);
          if(head == null) {
              head = new1;
              return;
          }
          new1.next = head;
          head = new1;
    }
    public void addLast(String data) {
          Node new2 = new Node(data);
          if(head == null) {
              head = new2;
              return;
          }
          Node current = head;
          while(current.next != null) {
              current = current.next;
          }
          current.next = new2;

    }
    public void printList() {
          Node current = head;
          while(current != null) {
              System.out.print(current.data + " - ");
              current = current.next;
          }
        System.out.print("null");
    }
    public void deleteFirst() {
          if(head == null) {
              return;
          }
          head = head.next;
    }
    public void deleteLast() {
        if(head == null) {
            return;
        }
        Node secondLast = head;
        Node last = head.next;
        while(last.next != null) {
            secondLast = secondLast.next;
            last = last.next;
        }
        secondLast.next = null;

    }
    public void reverseItr() {
          if(head == null) {
              return;
          }
          Node previous = head;
          Node current = head.next;
          while(current != null) {
              Node newNode = current.next;
              current.next = previous;
              previous = current;
              current = newNode;
          }
          head.next = null;
          head = previous;
    }
    public Node removeNth(int n) {
          Node current = head;
          if(head.next == null) {
              return null;
          }
          int size = 0;
          while(current != null) {
              size += 1;
              current = current.next;
          }
          if(n == size) {
              return head.next;
          }
          int index = size - n;
          Node previous = head;
          int i = 1;
          while(i < index) {
              previous = previous.next;
              i++;
          }
          previous.next = previous.next.next;
          return head;

    }
}
