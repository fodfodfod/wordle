
import java.util.Scanner; 

public class Game {
	public String userWord; 

	public final String ANSI_RESET = "\\u001B[37m"; 
	public int[] numbers = {0,1,2,3,4,5,6,7,8,9}; 
	public boolean containsNums; 
	public String suf; 
	public String keyWord; 
	public char userChar; 
	public boolean gamePlay = true; 

	public void startGame() {
		WordGenerator wg = new WordGenerator(); 
		keyWord=wg.generateWord(); 
		printInstructions(); 
		System.out.println(keyWord); 
		askForGuesses(keyWord); 
	}

	public String obtainValidUserWord () {
		Scanner kb = new Scanner(System.in) ;
		System.out.println("Enter a word with 5 letters: "); 
		userWord = kb.nextLine(); 
		userWord= userWord.toLowerCase(); 
		containsNums = checkContainsNumbers(userWord); 

		while(userWord.length() != 5) {
			if(userWord.length() < 5) {
				System.out.println(userWord.length()); 
				System.out.println("Enter a word with 5 letters: "); 
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
		return userWord; 
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
		System.out.println("You have to guess the Wordle in six goes or less.\n"
				+ "Every word you enter must be in the word list. ...\n"
				+ "A correct letter turns green.\n"
				+ "A correct letter in the wrong place turns yellow.\n"
				+ "An incorrect letter turns gray.\n"
				+ "Letters can be used more than once.\n"
				+ "Answers are never plurals."); 
	}

	public String askForGuesses(String keyWord) {
		int cnt = 1; 
		while(gamePlay == true && cnt < 6) {
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
			System.out.print("Enter your " + cnt + suf + " guess. ");
			userWord =	obtainValidUserWord(); 

			printYellowGreen(userWord,keyWord); 
			cnt++; 
		} 
		return userWord; 
	}

	public void printYellowGreen(String userWord, String keyWord) {
		if(keyWord.contains(userWord)) {
			gamePlay = false; 
			System.out.println("You Won"); 
		}

		for(int cnt = 0; cnt < userWord.length(); cnt++) {
			userChar = userWord.charAt(cnt); 
			if (userChar == keyWord.charAt(cnt)) { 
				System.out.print(" Green: " + userChar );
			}
			if(userWord.charAt(cnt) != keyWord.charAt(cnt) && keyWord.indexOf(userChar) >= 0) {
				System.out.print(" Yellow: " + userChar);
			}
			else if (keyWord.indexOf(userChar)== -1){
				System.out.print(" Grey: " + userChar); 
			}
		}
		System.out.println(); 
	}
}