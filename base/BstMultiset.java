package base;
import java.io.PrintStream;

public class BstMultiset<T> extends Multiset<T>
{ 
	
	private BinaryNode<T> mHead;  
	/** height of set */
	protected int height;
	
	protected String printString;
	
	public BstMultiset() {
		mHead = null;
		height = 0;
	}

	public void add(T value) {
		
		BinaryNode<T> newNode = new BinaryNode<T>(value);
		if(mHead == null){
			mHead = newNode;
			return;
		}
		BinaryNode<T> current = mHead;
		BinaryNode<T> parent = null;
		
		while(true){
			parent = current;
			if(((String)value).compareTo((String) current.getValue()) < 0){
				// left
				current = current.getLeftNode();
				if(current == null){
					parent.setLeftNode(newNode);
					return;
				}
				
			} else if (((String)value).compareTo((String) current.getValue()) > 0) {
				// right
				current = current.getRightNode();
				if(current == null){
					parent.setRightNode(newNode);
					return;
				}
			} else {
				current.incrementCount();
				return;
			}
			
		}
		
	} // end of add()

	public void display(){
		display(mHead);
	}
	
	public void display(BinaryNode<T> node){
		if(node != null){
			display(node.getLeftNode());
			int nodeCount = node.getCount();
			for(int i=1; i<=nodeCount; i++){
				System.out.print(" " + node.getValue());
			}
			display(node.getRightNode());
		}
	}
	
	public int search(T item) {
		BinaryNode<T> current = mHead;
		int count = 0;
		while(current != null){
			String currentValue = (String) current.getValue();
			if(currentValue.equals(item)){
				count++;
				current = null;
			} else if(currentValue.compareTo((String) item) >= 0){
				current = current.getLeftNode();
			} else {
				current = current.getRightNode();
			}
		}
		
		return count;
		
	} // end of search()
	
	
	public void removeOne(T item){
		BinaryNode<T> parent = mHead;
		BinaryNode<T> current = mHead;
		String removeValue = (String) item;
		String currentValue = (String) current.getValue();
		int nodeCount;
		
		boolean isLeftChild = false;
		while(!currentValue.equals(removeValue) && current != null){
			parent = current;
			
			if((currentValue).compareTo(removeValue) > 0){
				isLeftChild = true;
				current = current.getLeftNode();
				if (current != null) {
					currentValue = (String) current.getValue();
				}
			} else {
				isLeftChild = false;
				current = current.getRightNode();
				if (current != null) {
					currentValue = (String) current.getValue();
				}
			}
		
		}
		// node found...
		nodeCount = current.getCount();
		
		if(nodeCount > 1) {
			// decrease the count
			current.decrementCount();
			// no need to carry on 
			return;
		}
		
		//Case 1: no children
		if(current.getLeftNode() == null && current.getRightNode() == null){
			if(current == mHead){
				mHead = null;
			}
			if(isLeftChild == true){
				parent.setLeftNode(null);
			}else{
				parent.setRightNode(null);
			}
		}
		
		//Case 2 : only one child
		else if(current.getRightNode() == null){
			if(current == mHead){
				mHead = current.getLeftNode();
			} else if(isLeftChild){
				parent.setLeftNode(current.getLeftNode());
			}else{
				parent.setRightNode(current.getLeftNode());
			}
		}
		else if(current.getLeftNode() == null){
			if(current == mHead) {
				mHead = current.getRightNode();
			} else if(isLeftChild) {
				parent.setLeftNode(current.getRightNode());
			} else {
				parent.setRightNode(current.getRightNode());
			}
		} else if(current.getLeftNode() !=null && current.getRightNode() !=null){
			
			BinaryNode<T> previousNode	 = getPreviousNode(current);
			if(current == mHead){
				mHead = previousNode;
			} else if (isLeftChild){
				parent.setLeftNode(previousNode);
			}else{
				parent.setRightNode(previousNode);
			}			
			previousNode.setLeftNode(current.getLeftNode());
		}		
		
	}
	
	/**
	 * Get the previous/parent node from the tree
	 */
	public BinaryNode<T> getPreviousNode(BinaryNode<T> deleleNode){
		BinaryNode<T> previousNode = null;
		BinaryNode<T> previousNodeParent = null;
		BinaryNode<T> current = deleleNode.getRightNode();
		
		while(current != null){
			previousNodeParent = previousNode;
			previousNode = current;
			current = current.getLeftNode();
		}
		
		if(previousNode!=deleleNode.getRightNode()){
			previousNodeParent.setLeftNode(previousNode.getRightNode());
			previousNode.setRightNode(deleleNode.getRightNode());
		}
		return previousNode;
	}
	
	public void removeAll(T item){
		BinaryNode<T> parent = mHead;
		BinaryNode<T> current = mHead;
		String removeValue = (String) item;
		String currentValue = (String) current.getValue();
		
		boolean isLeftChild = false;
		while(!currentValue.equals(removeValue) && current != null){
			parent = current;
			
			if((currentValue).compareTo(removeValue) > 0){
				isLeftChild = true;
				if (current.getLeftNode() != null) {
					current = current.getLeftNode();
					currentValue = (String) current.getValue();
				} else {
					return;
				}
				
			} else {
				isLeftChild = false;
				if (current.getRightNode() != null) {
					current = current.getRightNode();
					currentValue = (String) current.getValue();
				} else {
					return;
				}
			}
		
		}
		// node found...
		
		//Case 1: no children
		if(current.getLeftNode() == null && current.getRightNode() == null){
			if(current == mHead){
				mHead = null;
			}
			if(isLeftChild == true){
				parent.setLeftNode(null);
			}else{
				parent.setRightNode(null);
			}
		}
		
		//Case 2 : only one child
		else if(current.getRightNode() == null){
			if(current == mHead){
				mHead = current.getLeftNode();
			} else if(isLeftChild) {
				parent.setLeftNode(current.getLeftNode());
			} else {
				parent.setRightNode(current.getLeftNode());
			}
		}
		else if(current.getLeftNode() == null){
			if(current == mHead) {
				mHead = current.getRightNode();
			} else if(isLeftChild) {
				parent.setLeftNode(current.getRightNode());
			} else {
				parent.setRightNode(current.getRightNode());
			}
		} else if(current.getLeftNode() !=null && current.getRightNode() !=null){
			
			BinaryNode<T> previousNode	 = getPreviousNode(current);
			if(current == mHead){
				mHead = previousNode;
			} else if (isLeftChild){
				parent.setLeftNode(previousNode);
			}else{
				parent.setRightNode(previousNode);
			}			
			previousNode.setLeftNode(current.getLeftNode());
		}		
		
	}
	
	public void printDisplay(BinaryNode<T> node){
		if(node != null){
			printDisplay(node.getLeftNode());
			int nodeCount = node.getCount();
			this.printString += node.getValue() + BstMultiset.printDelim + nodeCount + "\n";
			printDisplay(node.getRightNode());
		}
	}
	
	public void print(PrintStream out) {
		this.printString = "";
		printDisplay(mHead);
		System.out.println(this.printString);

		out.println(this.printString);
		out.close();
	}


} // end of class BstMultiset