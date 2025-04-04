package QueuePackg;

public class Queue {
	private int[] queue;
	private int front,rear,capacity,size;
	
	public Queue(int capacity) {
		this.capacity =capacity;
		queue = new int[capacity];
		front = 0;
		rear = -1;
		size = 0;
	}
	
	public void enqueue(int data) {
		if (isFull()) {
			System.out.println("Queue Overflow !!!");
			return;
		}
		rear = (rear+1) % capacity;
		queue[rear] = data;
		size++;
		System.out.println(data + " enqueue in the Q");
	}
	
	public int  dequeue() {
		if (isEmpty()) {
			System.out.println("Q is empty ..");
			return -1;
		}
		int removedElement =queue[front];
		front = (front + 1) % capacity;
		size--;
		
		return  removedElement;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Q is empty ..");
			return -1;
		}
		return queue[front];
	}
	
	public void displayQ() {
		if (isEmpty()) {
			System.out.println("Q is empty ..");
			return;
		}
		
		for(int i= 0; i< size ;i++) {
			System.out.println(queue[(front+i)  % capacity] );
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size ==  capacity;
	}
		
	public static void main(String[] args) {
		Queue q = new Queue(5);
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(40);
		q.enqueue(60);
		q.enqueue(90);
		q.displayQ();
		q.enqueue(100);
		q.displayQ();
		System.out.println("***********");
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue(100);
		q.enqueue(200);
		q.enqueue(300);
		q.enqueue(400);
		q.displayQ();
		
		System.out.println("Peek element: "+q.peek());
		
	}

}

