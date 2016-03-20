
public class Node {
	
	private Node next;
	private Object value;
	
	public <T> Node(T node) {
		this.value = node;
	}
	
	public void setNext(Node nextNode) {
		this.next = nextNode;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public Object getValue() {
		return this.value;
	}
	
	
}
