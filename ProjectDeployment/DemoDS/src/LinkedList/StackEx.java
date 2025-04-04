package LinkedList;

class Stack {
	
	private Node top;
	private int height;

	class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}
	}
	
	public Stack(int value) {
		Node newNode = new Node(value);
		top=newNode;
		height =1;
	}
	
	public void getTop() {
		System.out.println("Top : " + top.value);
	}

	public void getHeight() {
		System.out.println("Height :" + height);
	}
	
	
	public void printStack() {
		Node temp = top;
		getHeight();
		getTop();
		while (temp != null) {
			System.out.println(" -->" + temp.value );
			temp = temp.next;
		}
	}
	
	public void push(int value) {
		Node newNode = new Node(value);
		if(height == 0) {
			top = newNode;
			
		}else {
			newNode.next=top;
			top=newNode;
		}
	}

public Node pop() {
    if (height == 0) {
        return null;
    }

    Node temp = top;
    top = top.next;
    temp.next = null;
    height--;
    return temp;
}

public int peek() {
    if (top == null) {
        System.out.println("Stack is Empty");
        return -1;
    }
    return top.value;
}
public boolean isempty() {
	if(height==0) {
		System.out.println("Stack is Empty");
		return true;
	}
	return false;
}
}
public class StackEx {

	public static void main(String[] args) {
		Stack st = new Stack(2);
		st.getTop();
		st.getHeight();
		st.printStack();
		
		st.push(3);
		st.printStack();
		
		st.push(5);
		st.printStack();
		st.pop();
		st.peek();
		
		st.isempty();
	}

}
