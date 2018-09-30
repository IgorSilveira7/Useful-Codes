package data.structures.linkedList;

public class LinkedListNode<T> {
	
	protected T  data;
	protected LinkedListNode<T> next;
	
	public LinkedListNode() {
		
	}
	
	public LinkedListNode(T data, LinkedListNode<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public T getData() {
		return this.data;
	}
	
	public LinkedListNode<T> getNext() {
		return this.next;
	}
	
	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}
	
	public boolean isNull() {
		return (this.data == null);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinkedListNode<T> other = (LinkedListNode<T>) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
	
	
	
	

}
