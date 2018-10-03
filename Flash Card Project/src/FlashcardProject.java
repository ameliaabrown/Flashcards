import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
public class FlashcardProject {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Flashcard> flashcards = new ArrayList<Flashcard>();
		
		//reads the file
		Scanner info = new Scanner(new File ("SpanishWords.txt"));
		while(info.hasNext())
		{
			String f = info.nextLine();
			String b = info.nextLine();
			//test to make sure it is reading the file below
			//System.out.println(info.next());
			
			flashcards.add( new Flashcard (f, b));
		}
		for (Flashcard f : flashcards)
		{
			System.out.println(f.getFront());
			System.out.println(f.getBack());
			System.out.println();
		}
	}

}
