package data.structures.linkedList;


public class LinkedList<T> implements LinkedListInterface<T> {
	
	protected LinkedListNode<T> head;
	
	public LinkedList() {
		this.head = new LinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return (this.head.isNull());
	}

	@Override
	public int size() {
		Integer result = 0;
		
		if(!isEmpty()) {
			LinkedListNode<T> node = this.head;
			
			while(!node.isNull()) {
				result++;
				node = node.getNext();
			}
		}
		
		return result;
	}

	@Override
	public T search(T element) {
		LinkedListNode<T> node = this.head;
		
		while(!node.isNull() && !node.getData().equals(element)) {
			node = node.getNext();
		}
		
		return node.getData();
	}

	@Override
	public void insert(T element) {
		if(this.head.isNull()) {
			LinkedListNode<T> newHead = new LinkedListNode<T>(element, this.head);
			this.head = newHead;
			return;
		}
		
		LinkedListNode<T> node = this.head;
		
		while(!node.getNext().isNull()) {
			node = node.getNext();
		}
		
		LinkedListNode<T> newNode = new LinkedListNode<T>(element, node.getNext());
		node.setNext(newNode);
		
		
	}

	@Override
	public void remove(T element) {
		
		if(this.head.isNull()) return;
		if(this.head.getData().equals(element)) {
			this.head = this.head.getNext();
			return;
		}
		LinkedListNode<T> node = this.head;
		
		
		while(node.getNext() != null) {
			if(node.getNext().getData().equals(element)) {
				node.setNext(node.getNext().getNext());
				return;
			}
			
			node = node.getNext();
		}
		
	}
	
	public void removeFirst() {
		if(!this.isEmpty()) {
			this.head = this.head.getNext();
		}
	}
	
	public void insertFirst(T element) {
		LinkedListNode<T> newHead = new LinkedListNode<T>(element, this.head);
		this.head = newHead;
		
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		
		LinkedListNode<T> aux = this.head;
		
		int i = 0;
		
		while(!aux.isNull()) {
			array[i] = aux.getData();
			aux = aux.getNext();
			i++;
		}
		
		return array;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		LinkedListNode<T> aux = this.head;
		
		while(!aux.isNull()) {
			result += aux.getData() + " ";
			aux = aux.getNext();
		}
		
		return result;
		
	}
	
	public void reverseList() {
		
		LinkedListNode<T> prev = new LinkedListNode<>();
		LinkedListNode<T> current = this.head;
		LinkedListNode<T> next;
		
		while(!current.isNull()) {
			
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		
		this.head = prev;
	}
	
	public void reverseListRecursive() {
		this.reverseStep(this.head);
		
	}
	
	private void reverseStep(LinkedListNode<T> node) {
		if(!node.next.isNull()) {
			T data = node.getData();
			this.removeFirst();
			this.reverseStep(this.head);
			this.insert(data);
		}
	}
	
	
	
	public int maxElement() {
		int max = 0;
		
		LinkedListNode<T> aux = this.head;
		
		while(!aux.isNull()) {
			if((int) aux.getData() > max) {
				max = (int) aux.getData();
			}
			
			aux = aux.getNext();
		}
		
		return max;
	}
	
	public int indexOf(T element) {
		int index = -1;
		
		if(!this.isEmpty()) {
			
			LinkedListNode<T> aux = this.head;
			
			while(!aux.isNull() && aux.getData() != element) {
				aux = aux.getNext();
				index++;
			}
			
			if(aux.isNull()) {
				index = -1;
			} else {
				index++;
			}
			
			
		}
		
		return index;
	}
	
	public void insertOrdered(T element) {
		if(this.head.isNull() || (int) element < (int) this.head.getData()) {
			LinkedListNode<T> newHead = new LinkedListNode<T>(element, this.head);
			this.head = newHead;
			return;
		} 
		
		LinkedListNode<T> aux = this.head;
		
		while(!aux.getNext().isNull() && (int) element > (int) aux.getNext().getData()) {
			aux = aux.getNext();
		}
		
		LinkedListNode<T> newNode = new LinkedListNode<T>(element, aux.getNext());
		aux.setNext(newNode);
		
		
	}
	
	public LinkedListNode<T> getHead() {
		return this.head;
	}
	
	
	public void merge(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		
		LinkedListNode<Integer> aux1;
		LinkedListNode<Integer> aux2 = l2.head;
		
		while(!aux2.isNull()) {
			if(aux2.getData() < l1.head.getData()) {
				l1.insertFirst(aux2.getData());
				aux2 = aux2.getNext();
			} else {
				aux1 = l1.head;
				
				while(!aux1.getNext().isNull()) {
					if(aux1.getNext().getData() > aux2.getData()) {
						LinkedListNode<Integer> temp = aux2;
						temp.next = aux1.next;
						aux1.next = temp;
					}
					
					aux1 = aux1.getNext();
				}
				
				if(aux1.getData() < aux2.getData()) {
					LinkedListNode<Integer> temp = aux2;
					temp.next = aux1.next;
					aux1.next = temp;
				}
			}
			
			aux2 = aux2.getNext();
		}
		
	}
	
	
	
	
	
	

}
