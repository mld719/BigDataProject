import java.io.*;
import java.util.*;


/**
 * CODY: I don't think we should create a SongMap. I think we should just use a HashMap<String, SongRecord>.
 * This way, we already have all the traveral methods and whatnot. I wrote this class as if SongMap did not
 * exist. Let me know what you think. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    private static HashMap<String, SongRecord> mapOfSongs;
    private static HashMap<String, Integer> mapOfWords;
    
    public static void main(String[] args)
    {
        //this is where we will actually do each step
        
        mapOfSongs = readFolder(args[0]);
        mapOfWords = createListandFrequenciesOfWords();
    }
    
    public static HashMap<String, SongRecord> readFolder(String folderPath)
    {
        HashMap<String, SongRecord> readInSong = new HashMap<String, SongRecord>();
        
        return readInSong;
    }
    
    public static HashMap<String, Integer> createListandFrequenciesOfWords()
    {
        //uses the HashMap "mapOfSongs" already read in, which replaces the previous SongMap shenanigans
        
        //need to traverse "mapOfSongs" and get the lyrics. Then, go through lyrics and add each novel
        //word to the mapOfWords. if the word is already present, up its value by one. 
        
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        
        return words;
    }
    
    public static String[] mostCommonWords(int numOfTopWords)
    {
        //specify how many of the top words you want
        // ex. top 5 words or top 1 word
      
        //uses mapOfWords to find the top words
        
        String[] topWords = new String[numOfTopWords];
        
        return topWords;
    }
    
    public static String[] leastCommonWords(int numOfBottomWords)
    {
        //exactly the same as above
        
        String[] botWords = new String[numOfBottomWords];
        
        return botWords;
    }
}
