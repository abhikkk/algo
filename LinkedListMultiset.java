import java.io.PrintStream;
import java.util.*;





public class LinkedListMultiset<T> extends Multiset<T> {
	
	/** Reference to head node. */
    protected Node mHead;

    /** Length of list. */
    protected int mLength;


    public LinkedListMultiset() {
        mHead = null; 
        mLength = 0;
    } // end of LinkedListMultiset()

	

    /**
     * Add a new value to the start of the list.
     * 
     * @param newValue Value to add to list.
     */
    public void add(T newValue) {
        Node newNode = new Node(newValue);
             
        // If head is empty, then list is empty and head reference need to be initialised.
        if (mHead == null) {
            mHead = newNode;
        }
        // otherwise, add node to the head of list.
        else {
            newNode.setNext(mHead);
            mHead = newNode;  
        }
//        System.out.print(newNode.getValue());
        mLength++;
    } // end of add()
	
	public int search(T searchItem) {
		int counter = 0;
		Node currNode = mHead;
        for (int i = 0; i < mLength; ++i) {
        	if (currNode.getValue() == searchItem) {
        		counter++;
        	}
            currNode = currNode.getNext();
        }

        return counter;
        
    } // end of search()
		// default return, please override when you implement this method
	 // end of add()
	
	
	public Boolean removeOne(T removeValue) {
		// YOUR IMPLEMENTATION
    	if (mLength == 0) {
    		return false;
    	}
    	
    	
        Node currNode = mHead;
        Node prevNode = null;

        // check if value is head node
        if (currNode.getValue() == removeValue) {
            mHead = currNode.getNext();
            mLength--;
            return true;
        }

        prevNode = currNode;
        currNode = currNode.getNext();

        while (currNode != null) {
            if (currNode.getValue() == removeValue) {
                prevNode.setNext(currNode.getNext());
                currNode = null;
                mLength--;
                return true;
            }
            prevNode = currNode;
            currNode = currNode.getNext();
        }		


        return false;
	} // end of removeOne()
	
	
	public void removeAll(T removeValue) {
		// YOUR IMPLEMENTATION
    	if (mLength != 0) {
    	
            Node currNode = mHead;
            Node nextNode;
            Node prevNode = null;

        	
            // check if value is head node
            if (currNode.getValue() == removeValue) {
                mHead = currNode.getNext();
                currNode = null;
                currNode = mHead;
                mLength--;
            }


            while (currNode != null) {

                
                if (currNode.getValue() == removeValue) {
                    mLength--;
//
                    nextNode = currNode.getNext();
                    prevNode.setNext(nextNode);
                    currNode = null;
                    currNode = nextNode;
                } else {
                    prevNode = currNode;
                    currNode = currNode.getNext();
                }
                
            }	
	
    	}
        
	} // end of removeAll()
		
	
	@SuppressWarnings("static-access")
	public void print(PrintStream out) {
		String streamValue;
		if(mHead != null) {
			streamValue = "";
			Node currNode = mHead;
			Node localNode;
			String currentValue;
			String values = "";
//			
			while(currNode != null){
				currentValue = (currNode.getValue()).toString();
				localNode = mHead;
				int counter = 0;
	        	if(values.contains(currentValue) == false) {
	        		values += currentValue;
	        		for (int i = 0; i < mLength; ++i) {
	        			
			        	if(currentValue == localNode.getValue()) {
			        		counter++;
			        		
			        	}
			        	localNode = localNode.getNext();
		        	}
	        		streamValue += currentValue + this.printDelim + counter + "\n";
		        	
		        }


		        currNode = currNode.getNext();
		        
			}
			
			out.println(streamValue);
			out.close();

			
		}
	} // end of print()
	
} // end of class LinkedListMultiset