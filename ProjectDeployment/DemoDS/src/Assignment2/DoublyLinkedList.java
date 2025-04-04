package Assignment2;

//Doubly Linked List - Print in Reverse
class DoublyLinkedList {
 static class Node {
     int data;
     Node next, prev;
     Node(int data) { this.data = data; this.next = this.prev = null; }
 }

 Node head, tail;
 
 void insert(int data) {
     Node newNode = new Node(data);
     if (head == null) {
         head = tail = newNode;
         return;
     }
     tail.next = newNode;
     newNode.prev = tail;
     tail = newNode;
 }
 
 void printReverse() {
     Node temp = tail;
     while (temp != null) {
         System.out.print(temp.data + " ");
         temp = temp.prev;
     }
 }

 public static void main(String[] args) {
     DoublyLinkedList dll = new DoublyLinkedList();
     dll.insert(1); dll.insert(2); dll.insert(3); dll.insert(4);
     System.out.print("Doubly Reverse: ");
     dll.printReverse();
 }
}