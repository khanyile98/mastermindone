package mastermindone;
import java.util.*;
import java.io.*;


public class Mastermind {
    private Random random = new Random();
    public int randomIndex;

    public ArrayList<String> readFileContents(String fileName){
        ArrayList<String> words = new ArrayList<String>();

        try{
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()){
                words.add(reader.nextLine());
            }
            reader.close();

        }catch (FileNotFoundException e){ 
            System.out.println("The file does not exist.");
        }
        return words;
    }

    public String randomWord(ArrayList<String> words){
        this.randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }

    public String hideRandomCharacter(String word){
        this.randomIndex = random.nextInt(word.length());
        StringBuilder newWord = new StringBuilder();

        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == word.charAt(randomIndex)){
                newWord.append("_");
            }else{
                newWord.append(word.charAt(i));
            }
        }

        return String.valueOf(newWord);
    }

    public void handle(String word, String guess){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess the word: " + guess);
        System.out.print("Guess the missing letter: ");

        scanner.nextLine();
        System.out.println("The word was: " + word);
        scanner.close();
    }

    public static void main(String[] args) {
        Mastermind mastermind = new Mastermind();
        ArrayList<String> words = mastermind.readFileContents("short_words.txt");

        String word = mastermind.randomWord(words);
        String guess = mastermind.hideRandomCharacter(word);
        mastermind.handle(word, guess);

    }
    
}
