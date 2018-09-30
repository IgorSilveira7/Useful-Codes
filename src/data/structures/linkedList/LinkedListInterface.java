package data.structures.linkedList;

public interface LinkedListInterface<T> {
	
	public boolean isEmpty();
	
	public int size();
	
	public T search(T element);
	
	public void insert(T element);
	
	public void remove(T element);
	
}
