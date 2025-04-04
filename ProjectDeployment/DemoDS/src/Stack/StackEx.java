package Stack;


public class StackEx {

	private int[] stack;
	private int top;
	private int capacity;

	public StackEx(int capacity) {
		this.capacity = capacity;
		stack = new int[capacity];
		top = -1;
	}

	public void push(int data) {
		if (isFull()) {
			System.out.println("Stack Overflow !!!");
			return;
		}
		stack[++top] = data;
		System.out.println(data + " has been pushed");
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack Underflow :(((");
			return -1;
		}
		
		return stack[top--];
	}
	
	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty !!!");
			return -1;
		}
		return stack[top];
	}

	public boolean isFull() {
		return top == capacity - 1;
	}

	public void printStack() {
		if (isEmpty()) {
			System.out.println("Stack is empty ..");
			return;
		}
		for(int i = top; i>=0 ; i--) {
			System.out.println(stack[i] + " ");
		}
	}

	private boolean isEmpty() {
		return top == -1;
	}

	public static void main(String[] args) {
		StackEx st = new StackEx(5);
		st.push(10);
		st.push(20);
		st.push(30);
		
		st.push(40);
		st.push(50);
		st.printStack();
		st.push(60);
		System.out.println("Pop element: "+st.pop());
		System.out.println("**********");
		st.printStack();
		System.out.println("Peek Element: " + st.peek());
	}

}
