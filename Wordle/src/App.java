public class App {
    public static void main(String[] args) throws Exception {
    	WordGenerator wg = new WordGenerator(); 
    	System.out.println(wg.generateWord()); 
    	
       
        Game g = new Game();
        g.playGame();
    }
}
