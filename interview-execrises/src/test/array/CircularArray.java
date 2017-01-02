package test.array;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {

	private T[] items;
	private int head = 0;

	public CircularArray(int size) {
		items = (T[]) new Object[size];
	}

	private int convert(int index) {
		while (index < 0) {
			index += items.length;
		}
		return (head + index) % items.length;
	}

	public void rotate(int shiftRight) {
		head = convert(shiftRight);
	}

	public T get(int i) {
		if (i < 0 || i >= items.length) {
			throw new IndexOutOfBoundsException("");
		}
		return items[convert(i)];
	}

	public void set(int i, T item) {
		items[convert(i)] = item;
	}

	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIterator<T>(this);
	}

	private class CircularArrayIterator<TI> implements Iterator<TI> {
		private int _current = -1;
		private TI[] _items;

		public CircularArrayIterator(CircularArray<TI> array) {
			_items = array.items;
		}

		@Override
		public boolean hasNext() {
			return _current < items.length - 1;
		}

		@Override
		public TI next() {
			_current++;
			TI item = (TI) _items[convert(_current)];
			return item;
		}
	}

	public static void main(String[] args) {
		CircularArray<String> array = new CircularArray<String>(4);
		array.set(0, "A");
		array.set(1, "B");
		array.set(2, "C");
		array.set(3, "D");
		printArray(array);

		array.rotate(2);
		printArray(array);

		array.rotate(-3);
		printArray(array);

		array.rotate(-12);
		printArray(array);
	}

	private static void printArray(CircularArray array) {
		Iterator i = array.iterator();
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		System.out.println();
	}
}
