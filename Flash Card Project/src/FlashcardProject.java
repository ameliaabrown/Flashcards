import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class FlashcardProject 
{
	
	static ArrayList<Flashcard> flashcards = new ArrayList<Flashcard>();
	
		public static void main(String[] args) throws IOException
		{
			
			Scanner userReply = new Scanner(System.in);
			System.out.println("Would you like to study?");
			String study = userReply.nextLine();
			
			if (study.equals("yes"))
			{
			readFile();
			askQuestions();	
			}
			else
			{
				System.out.println("Okay");
			}
		}
		
		public static void readFile() throws IOException
		{
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
						//		for (Flashcard f : flashcards)
						//		{
						//			System.out.println(f.getFront());
						//			System.out.println(f.getBack());
						//			System.out.println();
						//		}
		}
		
		public static void askQuestions()
		{
			
			int numberOfTries = 0;
			int numberOfQuestions = 0;
			for (int i = 0; i<flashcards.size(); i++)
			{
				boolean asking = true;
				Flashcard f = flashcards.get(i);
				System.out.println("What does " + f.getFront() + " translate to?");
				
				
				while (asking)
				{
					
					Scanner userInput = new Scanner (System.in);
					String userAnswer = userInput.nextLine().toUpperCase();
					
					
					if (userAnswer.equals(f.getBack().trim().toUpperCase()))
					{
						asking = false;
						System.out.println("Good Job! That is Correct!");
						numberOfTries++;
						numberOfQuestions++;
					}
					else 
					{
						System.out.println("That is incorrect, try again.");
							numberOfTries++;
				
					}
					
				}
				
				
			}
		System.out.println("It took you " + (numberOfTries++) + " tries to get all " + numberOfQuestions + " questions correct.");
		
		repeat();
		}	
		
		public static void repeat()
		{
			
				System.out.println("Would you like to play again? (yes or no)");
				Scanner userInput2 = new Scanner (System.in);
				String repeat = userInput2.nextLine();
				
				if (repeat.equals("yes"))
				{
					askQuestions();
				}
				else 
				{
					System.out.println("Thank you for studying. Good luck on your test!");
				}
		}	
}

