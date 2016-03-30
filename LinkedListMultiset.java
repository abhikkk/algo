import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T> {

	/** Reference to head node. */
	protected Node<T> mHead;

	/** Length of list. */
	protected int mLength;

	public LinkedListMultiset() {
		mHead = null;
		mLength = 0;
	} // end of LinkedListMultiset()

	/**
	 * Add a new value to the start of the list.
	 * 
	 * @param newValue
	 *            Value to add to list.
	 */
	public void add(T newValue) {
		Node<T> newNode = new Node<T>(newValue);

		// If head is empty, then list is empty and head reference need to be
		// initialised.
		if (mHead == null) {
			mHead = newNode;
		}
		// otherwise, add node to the head of list.
		else {
			newNode.setNext(mHead);
			mHead = newNode;
		}
		// System.out.print(newNode.getValue());
		mLength++;
	} // end of add()

	public int search(T searchItem) {
		int counter = 0;
		Node<T> currNode = mHead;
		String searchVal = (String) searchItem;
		while (mHead != null && currNode != null) {
			String nodeVal = (String) currNode.getValue();
			if ((nodeVal).equals(searchVal)) {
				counter++;
			}
			currNode = currNode.getNext();
		}

		return counter;

	} // end of search()

	public void removeOne(T item) {
		// YOUR IMPLEMENTATION
		if (mHead != null) {

			Node<T> currNode = mHead;
			Node<T> prevNode = null;
			String removeValue = (String) item;
			String nodeVal = (String) currNode.getValue();

			// check if value is head node
			if ((nodeVal).equals(removeValue)) {
				mHead = currNode.getNext();
				mLength--;
			} else {

				prevNode = currNode;
				currNode = currNode.getNext();

				while (currNode != null) {
					nodeVal = (String) currNode.getValue();
					if ((nodeVal).equals(removeValue)) {
						prevNode.setNext(currNode.getNext());
						currNode = null;
						mLength--;
					} else {
						prevNode = currNode;
						currNode = currNode.getNext();
					}
				}
			}

		}

	} // end of removeOne()

	public void removeAll(T removeValue) {
		// YOUR IMPLEMENTATION
		if (mHead != null) {

			Node<T> currNode = mHead;
			Node<T> nextNode;
			Node<T> prevNode = null;

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

	@SuppressWarnings("unchecked")
	public void print(PrintStream out) {
		String streamValue;
		if (mHead != null) {
			streamValue = "";

			HashMap<String, Integer> hmap = new HashMap<String, Integer>();
			Node<T> currNode = mHead;
			String nodeValue;
			int count;

			while (currNode != null) {
				nodeValue = (String) currNode.getValue();
				count = search((T) nodeValue);
				hmap.put(nodeValue, count);
				currNode = currNode.getNext();
			}

			for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();
				streamValue += key + this.printDelim + value + "\n";
			}

			out.println(streamValue);
			out.close();
		}
	} // end of print()

} // end of class LinkedListMultiset