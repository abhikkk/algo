import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;



public class Main {
//	private static LinkedListMultiset<Number> myList = new LinkedListMultiset<Number>();
	private static LinkedListMultiset<String> myList = new LinkedListMultiset<String>();
		
	public static void main(String[] args) throws IOException {
		
		File file = new File( "myOutput.txt" );
	    PrintStream  print = new PrintStream( file );

//		myList.add("robot");
//		myList.add("robot");
//		myList.add("fortune");
//		myList.add("macbook");
//		myList.search("robot");
//		System.out.println(myList.search("robot"));
//		myList.print(print);
	    
	    
//	    // test 1
		myList.add("robot");
		myList.add("fortune");
		myList.add("macbook");
		myList.add("robot");
		myList.search("robot");
		myList.search("book");
		myList.add("macbook");
		myList.add("macbook");
		myList.add("fortune");
		myList.removeOne("fortune");
		myList.print(print);
	    
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
