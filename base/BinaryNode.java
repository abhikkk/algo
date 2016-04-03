package base;

public class BinaryNode<T> {

	private BinaryNode<T> left;
	private BinaryNode<T> right;
	private T value;
	private int count;
	
	public  BinaryNode(T node) {
		this.value = node;
		this.count = 1;
	}

	public void setLeftNode(BinaryNode<T> node) {
		this.left = node;
	}

	public BinaryNode<T> getLeftNode() {
		return this.left;
	}
	
	public void setRightNode(BinaryNode<T> node) {
		this.right = node;
	}

	public BinaryNode<T> getRightNode() {
		return this.right;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return this.count;
	}

	public void incrementCount() {
		 this.count = this.count + 1;
	}
	
	public void decrementCount() {
		 this.count = this.count - 1;
	}	
	
	
}
