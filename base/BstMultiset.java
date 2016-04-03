package base;
import java.io.PrintStream;
import java.util.*;

public class BstMultiset<T> extends Multiset<T>
{ 
	
	private BinaryNode<T> mHead;  
	/** height of set */
	protected int height;
	
	public BstMultiset() {
		mHead = null;
		height = 0;
	}

	public void add(T value) {
		
		BinaryNode<T> newNode = new BinaryNode(value);
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
	
	public BinaryNode<T> getPreviousNode(BinaryNode<T> deleleNode){
		BinaryNode<T> previousNode = null;
		BinaryNode<T> previousNodeParent = null;
		BinaryNode<T> current = deleleNode.getRightNode();
		
		while(current != null){
			previousNodeParent = previousNode;
			previousNode = current;
			current = current.getLeftNode();
		}
		//check if previousNode has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of previousNodeParent.
//		successsorParent
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
		int nodeCount;
		
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
		nodeCount = current.getCount();
		
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
	
	public void print(PrintStream out) {
		
	}


} // end of class BstMultiset