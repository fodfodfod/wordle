import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class WordGenerator {
    private String[] validWords;
    private Random r;
    public WordGenerator(){
        r = new Random();
        validWords = new String[2315];
        File file = new File("src/wordle_answers.txt");
        Scanner input = null;
        try{
            input = new Scanner(file);
            for(int i = 0; i<validWords.length;i++){
                validWords[i] = input.nextLine().trim().toLowerCase();
            }
        }
        catch (FileNotFoundException ex){
            System.out.println("cant open file");
        }
    }
    public String generateWord(){
        return validWords[r.nextInt(2314)];
    }

    //source for words https://github.com/techtribeyt/Wordle 
    
}
