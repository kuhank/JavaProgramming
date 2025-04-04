package LinkedList;


class LinkedList {
	private Node head;
	private Node tail;
	private int length;

	class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public LinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}

	public void getHead() {
		System.out.println("Head : " + head.value);
	}

	public void getTail() {
		System.out.println("Tail : " + tail.value);
	}

	public void getLength() {
		System.out.println("Length : " + length);
	}
public void append(int value) {
	Node newNode = new Node(value);
	if(length==0) {
		head = newNode;
		tail = newNode;
	}
	else {
		tail.next = newNode;
		tail = newNode;
	}
	length++;
}
public void prepend(int value) {
	Node newNode = new Node(value);
	if(length==0) {
		head = newNode;
		tail = newNode;
	}
	else {
		newNode.next = head;
		head = newNode;
	}
	length++;
}
public void printLinkedList() {
	Node temp = head;
	getHead();
	getTail();
	getLength();
	while(temp != null) {
		System.out.print(" -->"  +temp.value + "\t");
		temp = temp.next;
	}
	System.out.println("\n");
}

public Node removeFirst() {
	if(length==0) {
		return null;
	}
	Node temp = head;
	head = head.next;
	temp.next = null;
	System.out.println("Node value Removed is:"+temp.value);
	length --;
	if(length==0) {
		tail = null;
	}
	return temp;
}

public Node removeLast() {
	if(length==0) {
		return null;
	}
	Node temp = head;
	Node pre = head;
	while (temp.next!=null) {
		pre=temp;
		temp = temp.next;
	}
	tail=pre;
	tail.next=null;
	System.out.println("Node value Removed is:"+temp.value);
	length--;
	return temp;
}

public Node get(int index) {
	if (index<0 || index >= length) {
		return null;
	}
	Node temp = head;
	for(int i=0; i<index;i++) {
		temp = temp.next;
		
	}
	return temp;
}

public boolean set(int index, int value) {
	Node temp = get(index);
	if(temp!=null) {
		temp.value = value;
		return true;
	}
	return false;
}

public boolean insert(int index, int value) {
	if(index <0 || index >length) {
		return false;
	}
	if (index ==0) {
		prepend(value);
		return true;
	}
	if(index == length) {
		append(value);
		return true;
	}
	Node newNode = new Node(value);
	Node temp= get(index-1);
	newNode.next = temp.next;
	temp.next = newNode;
	length++;
	return true;
}

public boolean remove(int index) {
	if(index <0 || index >length) {
		return false;
	}
	if (index ==0) {
		removeFirst();
		return true;
	}
	if(index == length) {
		removeLast();
		return true;
	}
	
	Node temp= get(index-1);
	Node tempNext= get(index);
	temp.next = tempNext.next;
	tempNext.next = null;
	System.out.println("Node value Removed is:"+tempNext.value);
	length--;
	return true;
}
}

public class LinkedListEx {
	public static void main(String[] args) {
		LinkedList mll = new LinkedList(2);
		mll.getHead();
		mll.getTail();
		mll.getLength();
		mll.append(4);
		mll.printLinkedList();
		mll.prepend(1);
		mll.printLinkedList();
		System.out.print("\nremoved: "+mll.removeFirst().value+"\n");
		mll.printLinkedList();
		System.out.print("\nremoved last element: "+mll.removeLast().value+"\n");
		mll.printLinkedList();
		mll.append(7);
		mll.append(9);
		mll.append(12);
		System.out.print("\nElement at index 2: "+mll.get(2).value+"\n");
		mll.printLinkedList();
		mll.set(2, 100);
		mll.printLinkedList();
		mll.insert(1, 200);
		mll.printLinkedList();
		mll.insert(0, 10000);
		mll.printLinkedList();
		mll.insert(5, 200);
		mll.printLinkedList();
		mll.remove(0);
		mll.printLinkedList();
	}

}

