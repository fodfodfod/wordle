import java.nio.file.Path;
import java.util.Scanner;

import javax.xml.validation.Validator;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;


public class WordValidator {
    private String[] validAnswers;
    
    public WordValidator(){
        validAnswers = new String[12942];
        File file = new File("src/wordle_guesses.txt");
        Scanner input = null;
        try{
            input = new Scanner(file);
            for(int i = 0; i<validAnswers.length;i++){
                validAnswers[i] = input.nextLine().trim().toLowerCase();
                
            }
        }
        catch (FileNotFoundException ex){
            System.out.println("cant open file");
        }
        
    }
    
    
    /**NOT DONE 0 is not 5 letters or is not valid answer, 1 is 5 letters and valid answer but not correct, 2 is correct word */
    public int validWord(String word, String correctWord){
        //is the word 5 letters
        if(word.length()!=5){
            return 0;
        }

        //is the word in the list
        boolean isValidWord = false;
        for(int i = 0; i < validAnswers.length; i++){
            if(validAnswers[i].equals(word)){
                isValidWord = true;
                break;
            }
        }
        if(!isValidWord){
            return 0;
        }

        //is the word correct
        if(!word.equals(correctWord)){
            return 1;
        }
        else{
            return 2;
        }
    }
    //source for words https://github.com/techtribeyt/Wordle 
    
}
