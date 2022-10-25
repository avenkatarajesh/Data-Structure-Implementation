package arrays;

import java.util.Iterator;

public class ArrayImplementation<T> implements Iterable<T>
{
	private T[] arr = (T[]) new Object[10];
	int count = 0;
	

	public ArrayImplementation(int length) {
		arr = (T[]) new Object[length];
	}

	public void insert(T in) {
		if (count == arr.length) {
			T[] newArr = (T[]) new Object[count * 2];
			for (int index = 0; index < arr.length; index++) {
				newArr[index] = arr[index];
			}
			arr = newArr;
		}
		arr[count++] = in;
	}
	
	public void removeAt(int index) {
		if(index < 0 && index >= count)
			throw new IllegalArgumentException();
		
		if(count == index)
			count--;
		
		for(int i = index ; i < count-1 ; i++) {
				arr[i] = arr[i+1];
		}
		count--;
	}
	
	public int indexOf(T item) {
		for(int i = 0 ; i < count ; i++) {
			if(item == arr[i]) {
				return i;
			}
		}
		return -1;
	}

	public void print() {
		for (int index = 0; index < count; index++) {
			System.out.print(arr[index]+" ");
		}
		System.out.println();
	}

	@Override
	public Iterator<T> iterator() {
		
		return new  ListIterator(this);
	}
	
	private class ListIterator<T> implements Iterator<T>
	{
		private ArrayImplementation<T>list ;
		private int index;
		
		public ListIterator (ArrayImplementation<T>list){
			this.list = list;
		}

		@Override
		public boolean hasNext() {
			return (index < list.count);
		}

		@Override
		public T next() {
			return (list.arr[index++]);
		}
		
	}
	
	public int getCount() {
		return count;
	}
}
