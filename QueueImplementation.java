package Queue;

import java.util.Stack;

public class QueueImplementation<E> {

	private Stack<E> stack1 = new Stack<>();
	private Stack<E> stack2 = new Stack<>();

	public Boolean isEmpty() {
		return stack1.isEmpty();
	}

	public E peek() {
		if (isEmpty()){
		while (!stack1.isEmpty()) {
			stack2.add(stack1.pop());
		}
		}
		E obj = stack2.peek();
		return obj;
	}
	
	public boolean enqueue(E item) {
		stack1.add(item);
		return true;
	}
	
	public E dequeue() {
		E obj = peek();
		stack2.pop();
		return obj;
	}

	@Override
	public String toString() {
		return "["+ stack1 + "]";
	}
	
	
	
	

//	private ArrayList<E> arr ;
//	private int front = -1;
//	private int rear = front;

//	public QueueImplementation(int capacity) {
//		arr = new ArrayList<>(capacity);
//	}
//	
//	public Boolean isEmpty() {
//		if(arr.size() == 0)return true;
//		return false;
//	}
//	
//	public boolean enqueue(E item) {
//		this.arr.add(item);
//		front++;
//		rear++;
//		return true;
//	}
//	
//	public E dequeue() {
//		E obj = peek();
//		if(arr.size() == 0)return null;
//		arr.remove(obj);
//		front++;
//		return obj;
//	}
//
//	public E peek() {
//		if(isEmpty())return null;
//		E obj = arr.get(front++);
//		return obj;
//	}
//	
//	@Override
//	public String toString() {
//		return "[" + arr + "]";
//	}
//	

}
