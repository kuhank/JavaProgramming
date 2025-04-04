package LinkedList;

import LinkedList.LinkedList.Node;

class DoubleLinkedListEx {
	private Node head;
	private Node tail;
	private int length;

	class Node {
		int value;
		Node next;
		Node prev;

		public Node(int value) {
			this.value = value;
		}
	}

public DoubleLinkedListEx (int value) {
	Node newNode = new Node(value);
	newNode.next=null;
	newNode.prev=null;
	head = newNode;
	tail = newNode;
	
	length = 1;
}

public void gethead() {
	System.out.println("head: "+head.value);
}
public void gettail() {
	System.out.println("Tail: "+tail.value);
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
		newNode.prev = tail;
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
		head.prev = newNode;
		head = newNode;
	}
	length++;
}

public Node removeFirst() {
	if(length==0) {
		return null;
	}
	Node temp = head;
	
	if(length==1) {
		
		head=null;
		tail=null;
		return temp;
	}
	
	
	head = head.next;
	
	temp.next = null;
	head.prev = null;
			
	System.out.println("First Node value Removed is:"+temp.value);
	
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
	
	if(length==1) {
		Node temp1 = head;
		head=null;
		tail=null;
		return temp1;
	}
	Node temp = tail.prev;
	Node tempRemoved = tail;
	
	temp.next = null;
	tempRemoved.prev = null;
	tail = temp;
	
	System.out.println("Last Node value Removed is:"+tempRemoved.value);
	length--;
	return tempRemoved;
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
	Node beforeNode= get(index-1);
	Node AfterNode = beforeNode.next;
	newNode.next = AfterNode;
	beforeNode.next = newNode;
	newNode.prev = beforeNode;
	AfterNode.prev=newNode;
	
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
	
	Node beforenode= get(index-1);
	Node deletenode= get(index);
	Node afternode= deletenode.next;
	beforenode.next=afternode;
	afternode.prev=beforenode;
	deletenode.prev=null;
	deletenode.next=null;
	System.out.println("Node value Removed is:"+deletenode.value);
	length--;
	return true;
}




public void printLinkedListForward() {
	Node temp = head;
	gethead();
	gettail();
	getLength();
	System.out.println("Printing forward traversal:\n");
	while(temp != null) {
		System.out.print(" -->"  +temp.value + "\t");
		temp = temp.next;
	}
	System.out.println("\n");
}

public void printLinkedListReverse() {
	Node temp = tail;
//	gethead();
//	gettail();
//	getLength();
	System.out.println("Printing Reverse traversal:\n");
	while(temp != null) {
		System.out.print(" -->"  +temp.value + "\t");
		temp = temp.prev;
	}
	System.out.println("\n");
}

	public static void main(String[] args) {
		DoubleLinkedListEx mll = new DoubleLinkedListEx(2);
//		mll.gethead();
//		mll.gettail();
//		mll.getLength();
		mll.append(4);
		mll.prepend(30);

		mll.append(41);
		mll.prepend(20);
		mll.append(6);
		mll.prepend(90);
		
		mll.printLinkedListForward();
		mll.printLinkedListReverse();
		
		mll.removeFirst();
		mll.removeLast();
		mll.printLinkedListForward();
		mll.printLinkedListReverse();
		
		System.out.print("\nElement at index 2: "+mll.get(2).value+"\n");
		mll.set(1, 22);
		mll.printLinkedListForward();
		mll.insert(3, 300);
		mll.printLinkedListForward();
		mll.printLinkedListReverse();
		mll.remove(2);
		mll.printLinkedListForward();
		mll.printLinkedListReverse();
	
	}
}
