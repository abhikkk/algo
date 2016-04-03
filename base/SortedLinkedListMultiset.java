package base;
import java.io.PrintStream;
import java.util.*;

public class SortedLinkedListMultiset<T> extends Multiset<T> {

	/** Reference to head node. */
	protected Node<T> mHead;

	/** Length of list. */
	protected int mLength;

	public SortedLinkedListMultiset() {
		mHead = null;
		mLength = 0;
	} // end of LinkedListMultiset()

	/**
	 * Add a new value to the start of the list.
	 * 
	 * @param newValue
	 *            Value to add to list.
	 */
	public void add(T value) {
		Node<T> newNode = new Node<T>(value);

		// If head is empty, then list is empty and head reference need to be
		// initialised.
		if (mHead == null) {
			mHead = newNode;
		} else {

			String nextValue = (String) mHead.getValue();
			String newValue = (String) value;

			// does it go before the head item
			if (newValue.compareTo(nextValue) < 0) {
				newNode.setNext(mHead);
				mHead = newNode;
				// System.out.println(newValue);
				// System.out.println(nextValue);
			} else {

				Node<T> nextNode = mHead.getNext();
				Node<T> prevNode = mHead;
				while (nextNode != null) {
					nextValue = (String) nextNode.getValue();
					if (newValue.compareTo(nextValue) < 0)
						break;
					prevNode = nextNode;
					nextNode = nextNode.getNext();
				}
				// insert between prev node & next node
				newNode.setNext(prevNode.getNext());
				prevNode.setNext(newNode);

			}

		}

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
			String nodeVal = (String) currNode.getValue();

			// check if value is head node
			if ((nodeVal).equals(removeValue)) {
				mHead = currNode.getNext();
				currNode = null;
				currNode = mHead;
				mLength--;
			}

			while (currNode != null) {
				nodeVal = (String) currNode.getValue();
				
				if ((nodeVal).equals(removeValue)) {
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

			Map<String, Integer> orderedItems = new TreeMap<String, Integer>(
					hmap);
			for (Map.Entry<String, Integer> entry : orderedItems.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();
				streamValue += key + this.printDelim + value + "\n";
			}
			//
			// System.out.println(streamValue);

			out.println(streamValue);
			out.close();
		}
	} // end of print()

} // end of class SortedLinkedListMultiset