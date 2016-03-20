import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;



public class Main {
	private static LinkedListMultiset<String> myList = new LinkedListMultiset<String>();
		
	public static void main(String[] args) throws IOException {
		myList.add("One");
		myList.add("Two");
		myList.add("Three");
		myList.add("Four");
		myList.add("Four");
		
		File tempFile = File.createTempFile("myfile", ".tmp");
		FileOutputStream fout = new FileOutputStream(tempFile);
		PrintStream out = new PrintStream(fout);
		
		myList.print(out);
		
		System.out.println(myList.search("Four"));
		
		//myList.print(out);
		
		
	}
}
