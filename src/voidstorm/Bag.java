package voidstorm;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
	
	
	private T[] array;
	private int count;
	
	public Bag()
	{
		array = (T[]) new Object[4];
	}
	
	public void put(T el)
	{
		if(count == array.length) resize(2*array.length);
		array[count++] = el;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	
	private void resize(int i) {
		T[] temp = (T[]) new Object[i];
		if (i > array.length)
		for (int j = 0; j < count; j++)
			temp[j] = array[j];
		else
			for (int j = 0; j < i; j++)
				temp[j] = array[j];
			
		array = temp;
	}
	
	public boolean isEmpty()
	{
		return count==0;
	}
	
	private class ReverseArrayIterator implements Iterator<T>{

		private int i=count;
		@Override
		public boolean hasNext() {
			return i>0;
		}

		@Override
		public T next() {
			return array[--i];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

	
}
