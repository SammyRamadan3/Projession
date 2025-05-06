/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Doubly;

/*

Name Sammy Ramadan

CIT130

Date 11/5/24

Purpose of file Re edit Doubly class to implement toString and outputBackward method

*/
class DoublyLinkedList {

    // Node class to represent each element in the list
    static class Node {
        int data;
        Node prev;
        Node next;

        // Constructor to create a new node
        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Method to insert a node in sorted order
    public void insertSorted(int value) {
        Node newNode = new Node(value);

        // If the list is empty, the new node is both head and tail
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        // If the new value is smaller than the head, insert at the beginning
        if (value < head.data) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }

        // Traverse the list to find the correct position
        Node current = head;
        while (current != null && current.data < value) {
            current = current.next;
        }

        // If we've reached the end, insert at the tail
        if (current == null) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            // Insert the new node before the current node
            newNode.next = current;
            newNode.prev = current.prev;
            if (current.prev != null) {
                current.prev.next = newNode;
            }
            current.prev = newNode;
        }
    }

    // Method to display the list in forward direction
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to display the list in reverse direction (proving the doubly linked nature)
    public void outputBackwards() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // toString method to represent the list as a string (replacing outputList)
    @Override
    public String toString() {
        if (head == null) {
            return "List is empty.";
        }

        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }
}
