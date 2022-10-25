package Queue;

import java.util.Arrays;

public class PriorityQueue {
	
	private int[] arr;
	private int count;
	PriorityQueue(int capacity){
		arr= new int[capacity];
		count = -1;
	}
	
	public boolean  isEmpty() {
		return count==-1;
	}
	
	public boolean enqueue(int item) {
		if(isEmpty() || arr[count]<=item)
			arr[++count] = item;
		else {
			int[] arrCpy = new int[count+1];
			boolean flag = true;
			for(int index = count-1 ; index >=0 ; index--) {
				if(arr[index] > item) {
					arrCpy[index+1] = arr[index];
				}else if(arr[index] <= item && flag == true) {
					arrCpy[index+1] = item;
					flag = !flag;
					index++;
				}else {
					arrCpy[index] = arr[index];
				}
			}
			arr= arrCpy;
		}
		return false;
	}


	@Override
	public String toString() {
		return "PriorityQueue [arr=" + Arrays.toString(arr) + "]";
	}

}
