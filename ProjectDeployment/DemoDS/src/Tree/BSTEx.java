package Tree;

import java.util.*;

public class BSTEx {

    public Node root;
    
    static class Node {
        public int value;
        public Node left;
        public Node right;
        
        private Node(int value) {
            this.value = value;
        }
    }
    
    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) {
                return false;    
            }
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }
    
    public boolean contains(int val) {
        if (root == null) {
            return false;
        }
        Node temp = root;
        while (temp != null) {
            if (val < temp.value) {
                temp = temp.left;
            } else if (val > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }
    
    public Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.value) {
            root.left = delete(root.left, key);
        } else if (key > root.value) {
            root.right = delete(root.right, key);
        } else {
            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            else {
                Node minNode = findMin(root.right);
                root.value = minNode.value;
                root.right = delete(root.right, minNode.value);
            }
        }
        return root;
    }
    
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    public void delete(int key) {
        root = delete(root, key);
    }
    
    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(currentNode);
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            result.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return result;
    }
    
    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                result.add(currentNode.value);
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }                
            }
        }
        new Traverse(root);
        return result;        
    }
    
    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                result.add(currentNode.value);
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }                
            }
        }
        new Traverse(root);
        return result;        
    }
    
    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }    
                result.add(currentNode.value);
            }
        }
        new Traverse(root);
        return result;        
    }
    
    public static void main(String[] args) {
        BSTEx bst = new BSTEx();
        System.out.println("ROOT :" + bst.root);
        bst.insert(47);
        System.out.println("ROOT :" + bst.root.value);
        bst.insert(21);
        bst.insert(76);
        System.out.println("root.left.value :" + bst.root.left.value);
        System.out.println("root.right.value :" + bst.root.right.value);
        bst.insert(44);
        bst.insert(99);
        System.out.println("root.left.right.value:" + bst.root.left.right.value);
        System.out.println("root.right.right.value :" + bst.root.right.right.value);
        System.out.println(bst.contains(44));
        System.out.println(bst.contains(45));
        System.out.println("BFS: " + bst.BFS());
        
        System.out.println("Inorder traversal: " + bst.DFSInOrder());
        System.out.println("Preorder traversal: " + bst.DFSPreOrder());
        System.out.println("Postorder traversal: " + bst.DFSPostOrder());
        
        System.out.println("Deleting node 44...");
        bst.delete(44);
        System.out.println("Inorder traversal after deletion: " + bst.DFSInOrder());
    }
}
