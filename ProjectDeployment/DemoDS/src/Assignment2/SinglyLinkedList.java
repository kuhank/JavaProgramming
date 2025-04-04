package Assignment2;

class SinglyLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; this.next = null; }
    }

    Node head;
    
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    void printNormal() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    void printReverse(Node node) {
        if (node == null) return;
        printReverse(node.next);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insert(1); sll.insert(2); sll.insert(3); sll.insert(4);
        
        System.out.print("Singly Normal: ");
        sll.printNormal();
        System.out.println();
        
        System.out.print("Singly Reverse: ");
        sll.printReverse(sll.head);
    }
}