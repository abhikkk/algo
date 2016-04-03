package base;

public class Node<T> {
	
	private Node<T> next;
	private T value;
	
	public  Node(T node) {
		this.value = node;
	}
	
	public void setNext(Node<T> nextNode) {
		this.next = nextNode;
	}
	
	public Node<T> getNext() {
		return this.next;
	}
	
	public T getValue() {
		return this.value;
	}
	
	
}
