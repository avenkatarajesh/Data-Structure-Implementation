package linkedList;

import java.util.NoSuchElementException;


public class LinkedListImplementation <T> {
	private class NodeImplementation {
		private T value;
		private NodeImplementation next;

		public NodeImplementation() {

		}

		public NodeImplementation(T value) {
			this.value = value;
		}

		public NodeImplementation(T value, NodeImplementation next) {
			this.value = value;
			this.next = next;
		}
	}

	private NodeImplementation first;
	private NodeImplementation last;
	int size = 0;

	private boolean isEmpty() {
		if (first == null) {
			return true;
		}
		return false;
	}

	public void addLast(T value) {
		var newNode = new NodeImplementation(value);
		if (isEmpty()) {
			last = first = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
		size++;
	}

	public void addFirst(T value) {
		var newNode = new NodeImplementation(value);
		if (isEmpty()) {
			last = first = newNode;
		} else {
			newNode.next = first;
			first = newNode;
		}

		size++;
	}

	public int indexOf(T value) {
		var oldNode = first;
		int count = 0;
		while (oldNode != null) {
			if (oldNode.value == value)
				return count;

			count++;
			oldNode = oldNode.next;
		}
		return -1;
	}

	public boolean contains(T value) {
		if (indexOf(value) == -1)
			return false;
		return true;
	}

	public void removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		if (first == last) {
			first = last = null;
			return;
		}
		first = first.next;
		size--;
	}

	public void removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		if (first == last) {
			first = last = null;
			return;
		}
		var previous = getPrevious(last);
		last = previous;
		last.next = null;
		size--;
	}

	public NodeImplementation getPrevious(NodeImplementation node) {
		var curr = first;
		while (curr != null) {
			if (curr.next == node)
				return curr;
			curr = curr.next;
		}
		return null;
	}

//	public int[] toArray() {
//		int[] array = new int[this.size];
//		var curr = first;
//		int index = 0;
//		while (curr != null) {
//			array[index++] = curr.value;
//			curr = curr.next;
//		}
//
//		return array;
//	}

	public void reverse() {
		if (isEmpty())
			return;
		var prev = first;
		var curr = first.next;
		while (curr != null) {
			var next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		last = first;
		last.next = null;
		first = prev;
	}

//	public int findKthIndex(int k) {
//		if (isEmpty())
//			return 0;
//		
//		reverse();
//
//		var s = first;
//		var f = first;
//		for (int i = 0; i < k-1; i++) {
//			f = f.next;
//		}
//		while(f.next == null) {
//			f = f.next;
//			s = s.next;
//		}
//		return s.value;
//	}

}
