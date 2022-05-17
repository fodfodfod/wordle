
import java.util.Scanner; 

public class Game {
	public String userWord; 
	public String[] greenLetters = new String[5]; 
	public String[] yellowLetters = new String[5]; 
	public String ANSI_YELLOW = "\\u001B[43m"; 
	public String ANSI_GREEN = "\\u001B[42m"; 
	public int[] numbers = {0,1,2,3,4,5,6,7,8,9}; 
	public boolean containsNums; 
	public String suf; 
 
	public void startGame() {
		WordGenerator wg = new WordGenerator(); 
		obtainValidUserWord(); 
		
		
		       //Call WordGenerator to Generate a word 

		        // Print out instructions 
		        this.printInstructions();

		        // ask the user for the first guess
		        this.askForFirstGuess();

		       // this.loopThroughSixGuesses();

		    


	}
	
	 public String obtainValidUserWord () {
		 Scanner kb = new Scanner(System.in) ;
		 System.out.println("Enter a word with 5 letters: "); 
		userWord = kb.nextLine(); 
		userWord= userWord.toLowerCase(); 
		containsNums = checkContainsNumbers(userWord); 
		
		while(userWord.length() != 5) {
			if(userWord.length() < 5) {
				System.out.println("Please enter a word with 5 letters: "); 
				userWord=kb.nextLine(); 
			}
			else if (containsNums == true) {
				System.out.println("Enter a word that has no numbers: "); 
				userWord=kb.nextLine(); 
			}
			else {
				System.out.println("Your inputed word: " + userWord + " is not contained in our word list, please enter a valid 5 letter word: ");
				userWord=kb.nextLine(); 
			}
			
		}
		return wordList; 
	 } 
	 public boolean checkContainsNumbers(String word) {
		 for(int cnt = 0; cnt < word.length(); cnt++) {
			 for(int i = 0; i < numbers.length; i++) {
				 if(word.charAt(cnt) == numbers[i]) {
					return true; 
				 }
			 }
		 }
		return false;
	 }
	 
	public void printInstructions() { 

	}


	public void askForFirstGuess() {
		
	}
	public void askForGuesses() {
		for(int cnt = 0; cnt < 6; cnt ++) {
			switch(cnt) {
			case 1: 
				suf = "st"; 
				break; 
			case 2: 
				suf = "nd"; 
				break; 
			case 3: 
				suf = "rd"; 
				break;
			case 4: case 5: case 6: 
				suf = "th"; 
			default:
				break; 
			}
			if(cnt==1) {
				suf = "st";
			}
			System.out.print("Enter your " + cnt + suf + " guess.");
		}
	
	}
}