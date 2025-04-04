package Tree;

import java.util.*;

public class BSTAssignment {

	public Node root;
	
	static class Node{
		public int value;
		public Node left;
		public Node right;
		
		private Node(int value) {
			this.value = value;
		}
		
	}
	
	
	public boolean contains(int val) {
		if(root==null) {
			return false;
		}
		Node temp = root;
		while(temp!= null) {
			if(val<temp.value) {
				temp=temp.left;
			}
			else if(val > temp.value) {
				temp = temp.right;
			}
			else {
				return true;
			}
		}
		return false;
	}
	public ArrayList<Integer> BFS(){
		Node currentNode= root;
		Queue<Node> queue = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList();
		queue.add(currentNode);
		
		int leftcount=-1;
		int rightcount=-1;
		
		while(queue.size() >0) {
			currentNode = queue.remove();
			result.add(currentNode.value);
			if(currentNode.left != null) {
				queue.add(currentNode.left);
				leftcount++;
			}
			if(currentNode.right != null) {
				queue.add(currentNode.right);
				rightcount++;
			}
		}
		if (leftcount > rightcount) {
			System.out.println("Height is: "+ leftcount);
		}
		else {
			System.out.println("Height is: "+rightcount);
		}
		return result;
	}
	public static void main(String[] args) {
		BSTAssignment bst = new BSTAssignment();
		System.out.println("ROOT :" + bst.root);
		bst.root=new Node(47);
		bst.root.left=new Node(21);
		bst.root.right=new Node(76);
		bst.root.left.left=new Node(18);
		bst.root.left.right=new Node(27);
		bst.root.right.left=new Node(52);
		bst.root.right.right=new Node(82);
		bst.root.right.right.right=new Node(100);
		bst.root.left.right=new Node(1);
		System.out.println(bst.contains(76));
		System.out.println(bst.contains(45));
		System.out.println(bst.BFS());
	}

}
