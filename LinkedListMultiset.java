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
    } // end of SimpleList()

	

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


//    /**
//     * Add value (and corresponding node) at position 'index'.  Indices start at 0.
//     * 
//     * @param index Position in list to add new value to.
//     * @param newValue Value to add to list.
//     * 
//     * @throws IndexOutOfBoundsException In index are out of bounds.
//     */
//    public void add(int index, int newValue) throws IndexOutOfBoundsException {
//        if (index >= mLength || index < 0) {
//            throw new IndexOutOfBoundsException("Supplied index is invalid.");
//        }
//
//        Node newNode = new Node(newValue); 
//
//        if (mHead == null) {			
//            mHead = newNode;
//        }
//        // list is not empty
//        else {
//            Node currNode = mHead;
//            for (int i = 0; i < index-1; ++i) {
//                currNode = currNode.getNext();
//            }
//
//            newNode.setNext(currNode.getNext());
//            currNode.setNext(newNode);            
//        }
//
//        mLength += 1;
//    } // end of add()

	
	
	public int search(T item) {
		// Implement me!		
		
		// default return, please override when you implement this method
		return 0;
	} // end of add()
	
	
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
            Node prevNode = null;

            // check if value is head node
            if (currNode.getValue() == removeValue) {
                mHead = currNode.getNext();
                mLength--;
            }


            while (currNode != null) {
//            for (int i=0;i<mLength;i++) {
                if (currNode.getValue() == removeValue) {
                    prevNode.setNext(currNode.getNext());
                    mLength--;
                    
                    currNode = currNode.getNext();
                    
                } else {
                    prevNode = currNode;
                    currNode = currNode.getNext();
                }
                
                System.out.print("\n" + currNode.getValue());
            }	
	
    	}
        
	} // end of removeAll()
	
	public Boolean remove() {
		
		return true;
	}
	
	
	public void print(PrintStream out) {
		String streamValue;
		if(mHead != null) {
			streamValue = "";
			Node localNode = mHead;
			
			while(localNode !=null){
				streamValue += (String) localNode.getValue();
				localNode = localNode.getNext();
			}

			out.println(streamValue);
			// for testing
			System.out.print("\n" + streamValue);
			// end for testing
		}
	} // end of print()
	
} // end of class LinkedListMultiset