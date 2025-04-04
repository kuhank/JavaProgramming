package QueuePackg;

import java.util.*;

class printerJob{
	int priorityid;
	String documentname;
	
	public printerJob(int id, String doc) {
		this.priorityid = id;
		this.documentname = doc;
	}
	
	public String toString() {
		return "[Document: " + documentname + ", Priority: " + priorityid + "]";
	}
}
//
//class printerjobComparator implements Comparator<printerJob>{
//	public int compare(printerJob j1, printerJob j2) {
//		return Integer.compare(j1.priorityid, j2.priorityid);
//	}
//}

class priorityQueue{
	private printerJob[] queue;
	private int size=0;
	private int capacity;
	private PriorityQueue<printerJob> priorityQueuePrinterjob;
	
	public priorityQueue(int capacity){
		this.capacity = capacity;
		this.queue = new printerJob[capacity];
		//this.priorityQueuePrinterjob = new PriorityQueue<>((job1,job2) -> Integer.compare(job1.priorityid, job2.priorityid));
		
		 Comparator<printerJob> comparator = new Comparator<printerJob>() {
	            @Override
	            public int compare(printerJob job1, printerJob job2) {
	                return job2.priorityid - job1.priorityid; // Descending order
	            }
	        };

	        this.priorityQueuePrinterjob = new PriorityQueue<>(comparator);
	        
	}
	public boolean isEmpty() {
		return size==0;
		}
	public void enqueue(printerJob job) {
		if (size==capacity) {
			System.out.println("Queue is full");
			return;
		}
		queue[size] = job;
		size++;
		priorityQueuePrinterjob.add(job);
		System.out.println("Data entered");
	}
	
	public printerJob dequeue() {
		if(size==0) {
			System.out.println("Queue is empty");
			return null;
		}
		printerJob job = priorityQueuePrinterjob.poll();
		size--;
		return job;
	}
	
}
public class PriorityQueueEx{
	
	public static void main(String[] args) {
		priorityQueue printerJob = new priorityQueue(5);

		printerJob.enqueue(new printerJob(2,"Document1"));
		printerJob.enqueue(new printerJob(1, "Document2"));
		printerJob.enqueue(new printerJob(3, "Document3"));
		
		while(!printerJob.isEmpty()) {
			System.out.println(printerJob.dequeue());
		}
        
		
	}


}
