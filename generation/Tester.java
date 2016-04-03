package generation;

import base.LinkedListMultiset;

public class Tester {
	
	static Integer basicCount = 3000000;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		testLinkedListSearch();
	    long end = System.currentTimeMillis();

	    System.out.println((end - start) + " ms");

	}
	
	public static void testLinkedListSearch() {
		LinkedListMultiset<String> myList = new LinkedListMultiset<String>();
		
		 for(int i=1; i<basicCount; i++){
			 myList.add("Doggg");
        }	
	}
	
	public static void testSortedListSearch() {
		LinkedListMultiset<String> myList = new LinkedListMultiset<String>();
		
		 for(int i=1; i<basicCount; i++){
			 myList.add("Doggg");
        }	
	}

}
