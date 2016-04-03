package base;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;



public class Main {
//	private static LinkedListMultiset<Number> myList = new LinkedListMultiset<Number>();
	private static LinkedListMultiset<String> myList = new LinkedListMultiset<String>();
	private static SortedLinkedListMultiset<String> mySortedList = new SortedLinkedListMultiset<String>();
		
	public static void main(String[] args) throws IOException {
		
		File file = new File( "myOutput.txt" );
	    PrintStream  print = new PrintStream( file );

		myList.add("robot");
		myList.add("robot");
		myList.add("fortune");
		myList.add("macbook");
		myList.removeAll("robot");
//		System.out.println(myList.search("robot"));
		myList.print(print);
	    
	    
//	    // test 1
//	    mySortedList.add("celine");
//	    mySortedList.add("celine");
//	    mySortedList.add("dogg");
//	    mySortedList.add("abhi");
//	    mySortedList.add("aa");
//	    mySortedList.add("zz");
//	    mySortedList.add("yy");
//	    mySortedList.testPrintoutall();
	    
	    mySortedList.print(print);
	    
	    
	    // test 2
//		myList.add("hello");
//		myList.add("bye");
//		myList.add("hello");
//		myList.search("bye");
//		myList.search("up");
//		myList.search("hello");
//		myList.print(print);
		
	}
}
