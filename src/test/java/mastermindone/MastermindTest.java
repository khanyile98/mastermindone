package mastermindone;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;

public class MastermindTest {
    Mastermind mastermind = new Mastermind();
    ArrayList<String> words = mastermind.readFileContents("test_words.txt");

    @Test
    public void testFileExistsTrue(){
        File file = new File("short_words.txt");
        assertTrue(file.exists());
    }

    @Test
    public void testFileExistsFalse(){
        File file = new File("filename.txt");
        assertFalse(file.exists());
    }

    @Test
    public void testReadFileContents(){
        String contents = String.valueOf(mastermind.readFileContents("short_words.txt"));
        assertEquals("[harry, babe, love, them, people, truth, believe, faith, hope, car]",
        contents);
    }

    @Test
    public void testSomething(){
        String word = mastermind.randomWord(words);
        assertEquals("brain", word);
    }

}
