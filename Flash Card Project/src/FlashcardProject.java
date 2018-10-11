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
			System.out.println("Would you like to study basic math, Spanish or English?");
			String subject = userReply.nextLine();
			
			if (subject.equals("spanish"))
			{
			readSpanishFile();
			askSpanishQuestions();	
			}
			if (subject.equals("math"))
			{
			readMathFile();
			askMathQuestions();
			}
			if (subject.equals("english"))
			{
				readEnglishFile();
				askEnglishQuestions();
			}
		}
		
		public static void readSpanishFile() throws IOException
		{
			flashcards.clear();
			Scanner info = new Scanner(new File ("SpanishWords.txt"));
			while(info.hasNext())
			{
				String f = info.nextLine();
				String b = info.nextLine();
				//test to make sure it is reading the file below
				//System.out.println(info.next());
				
				flashcards.add( new Flashcard (f, b));
			}
				
		}
		
		public static void readMathFile() throws IOException
		{
			flashcards.clear();
			Scanner info = new Scanner(new File ("MathSymbols.txt"));
			while(info.hasNext())
			{
				String f = info.nextLine();
				String b = info.nextLine();
				//test to make sure it is reading the file below
				//System.out.println(info.next());
				
				flashcards.add( new Flashcard (f, b));
			}
		}

		public static void readEnglishFile() throws IOException
		{
			flashcards.clear();
			Scanner info = new Scanner(new File ("EnglishTerms.txt"));
			while(info.hasNext())
			{
				String f = info.nextLine();
				String b = info.nextLine();
				//test to make sure it is reading the file below
				//System.out.println(info.next());
				
				flashcards.add( new Flashcard (f, b));
			}
		}
		
		public static void askSpanishQuestions() throws IOException
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
		
		repeatSpanish();
		}	
		
		public static void askMathQuestions() throws IOException
		{
			int numberOfTries = 0;
			int numberOfQuestions = 0;
			for (int i = 0; i<flashcards.size(); i++)
			{
				boolean asking = true;
				Flashcard f = flashcards.get(i);
				System.out.println("What does " + f.getFront() + " represent?");
				
				
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
		
			repeatMath();
		}
	
		public static void askEnglishQuestions() throws IOException
		{
			int numberOfTries = 0;
			int numberOfQuestions = 0;
			for (int i = 0; i<flashcards.size(); i++)
			{
				boolean asking = true;
				Flashcard f = flashcards.get(i);
				System.out.println("What is the word for " + f.getFront() + "?");
				
				
				while (asking)
				{
					
					Scanner userInput = new Scanner (System.in);
					String userAnswer = userInput.nextLine().toUpperCase();
					
					
					if (userAnswer.equals(f.getBack().trim().toUpperCase()))
					{
						asking = false;
						System.out.println("Good job! That is correct!");
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
		
			repeatEnglish();
		}

		public static void repeatMath () throws IOException
		{
			System.out.println("Would you like to study math again? (yes or no)");
			Scanner userInput2 = new Scanner (System.in);
			String repeat = userInput2.nextLine();
			
			if (repeat.equals("yes"))
			{
				readMathFile();
				askMathQuestions();
			}
			else 
			{
				Scanner again = new Scanner (System.in);
				System.out.println("Would you like to study Spanish, English or neither?");
				String studyAgain = again.nextLine();
				
				if (studyAgain.equals("spanish"))
				{
					readSpanishFile();
					askSpanishQuestions();
				}
				if (studyAgain.equals("english"))
				{
					readEnglishFile();
					askEnglishQuestions();
				}
				if (studyAgain.equals("neither"))
				{
					System.out.println("Okay, thank you for studying! Good luck on your test!");
				}
			}
		}
		
		public static void repeatSpanish() throws IOException
		{
			System.out.println("Would you like to stuy Spanish again? (yes or no)");
			Scanner userInput2 = new Scanner (System.in);
			String repeat = userInput2.nextLine();
			
			if (repeat.equals("yes"))
			{
				readSpanishFile();
				askSpanishQuestions();
			}
			else 
			{
				Scanner again = new Scanner (System.in);
				System.out.println("Would you like to study English, math or neither?");
				String studyAgain = again.nextLine();
				
				if (studyAgain.equals("english"))
				{
					readEnglishFile();
					askEnglishQuestions();
				}
				if (studyAgain.equals("math"))
				{
					readMathFile();
					askMathQuestions();
				}
				else 
				{
					System.out.println("Thank you for studying, Good luck on your test!");
				}
			}
			}
			
		public static void repeatEnglish() throws IOException
		{
			System.out.println("Would you like to stuy English again? (yes or no)");
			Scanner userInput2 = new Scanner (System.in);
			String repeat = userInput2.nextLine();
			
			if (repeat.equals("yes"))
			{
				readEnglishFile();
				askEnglishQuestions();
			}
			else 
			{
				Scanner again = new Scanner (System.in);
				System.out.println("Would you like to study Spanish, math or neither?");
				String studyAgain = again.nextLine();
				
				if (studyAgain.equals("spanish"))
				{
					readSpanishFile();
					askSpanishQuestions();
				}
				if (studyAgain.equals("math"))
				{
					readMathFile();
					askMathQuestions();
				}
				else 
				{
					System.out.println("Thank you for studying! Good luck on your test!");
				}
			}
		}

}

