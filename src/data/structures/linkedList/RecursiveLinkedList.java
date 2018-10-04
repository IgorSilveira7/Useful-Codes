package data.structures.linkedList;

public class RecursiveLinkedList<T> implements LinkedListInterface<T> {
	
	protected T data;
	protected RecursiveLinkedList<T> next;
	
	public RecursiveLinkedList() {
		
	}

	@Override
	public boolean isEmpty() {
		if(this.data == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		int size;
		
		if(this.data == null) {
			return 0;
		} else {
			size = 1 + this.next.size();
		}
		return size;
	}

	@Override
	public T search(T element) {
		if(this.isEmpty()) {
			return null;
		} else {
			if(this.data.equals(element)) {
				return element;
			} else {
				return this.next.search(element);
			}
		}
	}

	@Override
	public void insert(T element) {
		if(this.isEmpty()) {
			this.data = element;
			this.next = new RecursiveLinkedList<T>();
		} else {
			this.next.insert(element);
		}
		
	}

	@Override
	public void remove(T element) {
		if(this.isEmpty()) {
			
		}else {
			if(this.data.equals(element)) {
				this.data = this.next.data;
				this.next = this.next.next;
			} else {
				this.next.remove(element);
			}
		}
		
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[this.size()];
		this.toArray(result, this, 0);

		return result;
	}
	
	private void toArray(T[] array, RecursiveLinkedList<T> node, int i) {
		
		if(!node.isEmpty()) {
			array[i] = node.data;
			toArray(array, node.next, i+1);
		}
	}

}
