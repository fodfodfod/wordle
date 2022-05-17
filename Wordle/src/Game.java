
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class Game {
	public String userWord; 
	public List<Character> greenLetters = new ArrayList<>(); 
	public List<Character> YellowLetters = new ArrayList<>(); 
	public final String ANSI_YELLOW = "\\u001B[43m"; 
	public final String ANSI_GREEN = "\\u001B[42m"; 
	public final String ANSI_RESET = "\\u001B[37m"; 
	public int[] numbers = {0,1,2,3,4,5,6,7,8,9}; 
	public boolean containsNums; 
	public String suf; 
	public String keyWord; 
	public int valid; 
	public char userChar; 
 
	public void startGame() {
		WordGenerator wg = new WordGenerator(); 
		keyWord=wg.generateWord(); 
		printInstructions(); 
		System.out.println(keyWord); 
		askForGuesses(keyWord); 
	}
	
	 public String obtainValidUserWord () {
		 Scanner kb = new Scanner(System.in) ;
		 System.out.println("Enter a word with 5 letters__: "); 
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
		for(int cnt = 1; cnt < 6; cnt ++) {
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
			obtainValidUserWord(); 
			userWord = obtainValidUserWord(); 
			checkWord(userWord,keyWord); 
		}
		return userWord; 
	}
	
	public void checkWord(String userWord, String keyWord) {
		WordValidator wv = new WordValidator(); 
		valid = wv.validWord(userWord, keyWord); 
		if (valid == 1) {
			System.out.println(ANSI_GREEN + userWord + ANSI_RESET);
			System.out.println("You Won!"); 
		}
		else{
			printYellowGreen(userWord,keyWord); 
		}
	}
	public void printYellowGreen(String userWord, String keyWord) {
		for(int cnt = 0; cnt < userWord.length(); cnt++) {
			userChar = userWord.charAt(cnt); 
			if (userWord.charAt(cnt) == keyWord.charAt(cnt)) { 
				System.out.print(ANSI_GREEN + userChar + ANSI_RESET);
				if(keyWord.indexOf(userChar)!= -1) {
					System.out.print(ANSI_YELLOW +userChar + ANSI_RESET);
				}
				
			}
			else {
				System.out.print(userChar); 
			}
		}
		System.out.println(); 
	}
}