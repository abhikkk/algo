import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;



public class Main {
//	private static LinkedListMultiset<Number> myList = new LinkedListMultiset<Number>();
	private static LinkedListMultiset<String> myList = new LinkedListMultiset<String>();
		
	public static void main(String[] args) throws IOException {
		myList.add("One");
		myList.add("Two");
		myList.add("Three");
		myList.add("Three");
		myList.add("Four");
		myList.add("Four");

//		myList.add(1);
//		myList.add(2);
//		myList.add(2);
//		myList.add(3);
		
		File file = new File( "myOutput.txt" );
	    PrintStream  print = new PrintStream( file );

		myList.print(print);
		
//		System.out.println(myList.search(2));
//		System.out.println(myList.search(2));
//	    myList.removeAll(2);
		
//		myList.print(print);
		
		
	}
}
