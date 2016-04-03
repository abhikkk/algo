package base;

public class BinaryNode<T> {

	private BinaryNode<T> left;
	private BinaryNode<T> right;
	private T value;
	
	public  BinaryNode(T node) {
		this.value = node;
	}

	public void setLeft(BinaryNode<T> node) {
		this.left = node;
	}

	public BinaryNode<T> getLeft(BinaryNode<T> node) {
		return this.left;
	}
	
	public void setRight(BinaryNode<T> node) {
		this.right = node;
	}

	public BinaryNode<T> getRight(BinaryNode<T> node) {
		return this.right;
	}
	
	public T getValue() {
		return this.value;
	}
	
	
}
