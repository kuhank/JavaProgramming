package Assignment2;

//Circular Linked List Implementation
class CircularLinkedList {
 static class Node {
     int data;
     Node next;
     Node(int data) { this.data = data; this.next = null; }
 }

 Node head, tail;
 
 void insert(int data) {
     Node newNode = new Node(data);
     if (head == null) {
         head = tail = newNode;
         tail.next = head; // Circular link
         return;
     }
     tail.next = newNode;
     tail = newNode;
     tail.next = head; // Maintain circular link
 }
 
 void print() {
     if (head == null) return;
     Node temp = head;
     do {
         System.out.print(temp.data + " ");
         temp = temp.next;
     } while (temp != head);
 }

 public static void main(String[] args) {
     CircularLinkedList cll = new CircularLinkedList();
     cll.insert(1); cll.insert(2); cll.insert(3); cll.insert(4);
     System.out.print("Circular List: ");
     cll.print();
 }
}