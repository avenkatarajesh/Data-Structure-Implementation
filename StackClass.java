package stack;

import java.util.ArrayList;

public class StackClass<T> {
	ArrayList<T> stackArray = new ArrayList<>();
	int index = -1;
	
	void push(T add){
		stackArray.add(add);
		index++;
	}
	
	T pop() {
		if(!isEmpty())throw new IllegalStateException();
		return stackArray.get(index--);
	}
	
	T peek() {
		if(!isEmpty())throw new IllegalStateException();
		return stackArray.get(index);
	}
	
	boolean isEmpty() {
		if(index < 0)return false;
		return true;
	}

}
