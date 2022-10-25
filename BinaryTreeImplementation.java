package tree;

import java.util.ArrayList;

public class BinaryTreeImplementation {
	
	class Node {
		int value;
		Node LeftNode = null;
		Node RightNode = null;
		Node(int value){
			this.value = value;
		}
		@Override
		public String toString() {
			return "Node [value=" + value + ", LeftNode=" + LeftNode + ", RightNode=" + RightNode + "]";
		}
	}
	
	public Node root;
	
	public void insert(int value) {
		Node node = new Node(value);
		if(root == null) {
			root = node ;
			return ;
		}
		Node current = root;
		while(true) {
			if(current.value > value){
				if(current.LeftNode == null) {
					current.LeftNode = node;
					break;
				}else {
					current = current.LeftNode;
				}
			}else {
				if(current.RightNode == null) {
					current.RightNode = node;
					break;
				}else {
					current = current.RightNode;
				}
			}	
		}
	}
	
	public boolean findValue(int value) {
		if(root.value == value) return true;
		Node current = root;
		while(current != null) {
			if(current.value > value){
				current = current.LeftNode;
			}else if(current.value < value){
				current = current.RightNode;
			}else {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Integer> traversePreOrder(Node node , ArrayList<Integer> list) {
		if(node == null) return list;
		if(node != null) {
			list.add(node.value);
			traversePreOrder(node.LeftNode , list);
			traversePreOrder(node.RightNode , list);
		}
		return list;
	}
	
	public ArrayList<Integer> traverseInOrder(Node node , ArrayList<Integer> list) {
		if(node == null) return list ;
		if(node != null) {
			traversePreOrder(node.LeftNode , list);
			list.add(node.value);
			traversePreOrder(node.RightNode , list);
		}
		return list;
	}
	
	public ArrayList<Integer> traversePostOrder(Node node , ArrayList<Integer> list) {
		if(node == null) return list;
		if(node != null) {
			traversePreOrder(node.LeftNode , list);
			traversePreOrder(node.RightNode , list);
			System.out.println(node.value);
		}
		return list;
	}
	
	public int height(Node node) {
		if(node == null) return -1;
		if(node.LeftNode == null && node.RightNode == null) return 0 ;
		return 1 + Math.max(height(node.LeftNode), height(node.RightNode));
	}
	
	public int min(Node root) {
		if(root == null) return -1;
		Node prev = root;
		while(root != null) {
			prev = root;
			root = root.LeftNode;
		}
		return prev.value;
	}
	
	public boolean eqauls(Node tree) {
		return eqauls(this.root , tree);
	}
	 private boolean eqauls(Node first , Node second) {
		 if(first == null && second == null) return true;
//		 if(first != null && second == null || first == null && second != null) return false;
		 if(first != null && second != null) {
		 return first.value == second.value && eqauls(first.LeftNode , second.LeftNode) && eqauls(first.RightNode , second.RightNode);
		 }
		 return false;
	 }
	 
	 
	 public boolean validity(Node node) {
		 if(node == null || node.LeftNode == null && node.RightNode == null )return true;
		 if(node.LeftNode != null && node.RightNode != null) {
			 return node.LeftNode.value < node.value && node.RightNode.value > node.value && validity(node.LeftNode) && validity(node.RightNode); 
		 }else if(node.LeftNode != null) {
			 return node.LeftNode.value < node.value  && validity(node.LeftNode);
		 }else {
			 return node.RightNode.value > node.value && validity(node.RightNode);
		 }
	 }
	 
	 public void level(Node node , int n ) {
		 if(node == null) return ;
		 if(n == 0) {
			 System.out.println(node.value);
		 }else {
			 level(node.LeftNode , n-1);
			 level(node.RightNode , n-1);
		 }
	 }
	 
	 public void swapvalue(Node node) {
		 Node temp = node.LeftNode;
		 node.LeftNode = node.RightNode;
		 node.RightNode = temp;
	 }
	 
	 public int size() {
		 if(root == null) return 0;
		 ArrayList<Integer> list = new ArrayList<>();
		 list= traversePreOrder(root,list);
		 return list.size();
	 }

	@Override
	public String toString() {
		return "BinaryTreeImplementation [root=" + root + "]";
	}

}
