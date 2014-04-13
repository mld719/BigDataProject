// Authors: Cody Frenzel and Megan DeLaunay

import java.util.*;
import java.io.*;

public class WordCount {

  private HashMap<String, SongRecord> map;
  /*
  * Represents the data we need about a word:  the word and
  * the number of times it has been encountered.
  */
  private static class WordData { 
    String word;
    int count;
    WordData(String w) {
        // Constructor for creating a WordData object when
        // we encounter a new word.
        word = w;
        count = 1;  // The initial value of count is 1.
     }
  } // end class WordData


  /*
  * A comparator for comparing objects of type WordData according to 
  * their counts.  This is used for sorting the list of words by frequency.
  */
  private static class CountCompare implements Comparator<WordData> {
     public int compare(WordData data1, WordData data2) {
        return data2.count - data1.count;
            // The return value is positive if data2.count > data1.count.
            // I.E., data1 comes after data2 in the ordering if there
            // were more occurrences of data2.word than of data1.word.
            // The words are sorted according to decreasing counts.
     }
  } // end class CountCompare


  public WordCount(HashMap<String, SongRecord> _map) {
    if(_map.size() == 0){
      System.out.println("No data in the map. exit.");
      System.exit(1);
    }

    map = _map;
  }

  public void Count(){
  // Create a TreeMap to hold the data.  Read the lyrics and record
  // data in the map about the words that are found in the lyrics.
  TreeMap<String,WordData> words = new TreeMap<String,WordData>();
  Set<String> songSet = map.keySet();
  Iterator iter = songSet.iterator();
  while(iter.hasNext()){
    String nextKey = iter.next();
    SongRecord record = map.get(nextKey);  
    Scanner scanner = new Scanner(record.getLyrics());

    while(scanner.hasNext()){
      String word = scanner.next();
      word = word.toLowerCase();  // convert word to lower case
      wordData data = words.get(word);
      if (data == null){
        words.put( word, new WordData(word) );
      }else{
        data.count++;
      }
    }

    scanner.close();
  }
         
         
  // Copy the word data into an array list, and sort the list
  // into order of decreasing frequency.
         
  ArrayList<WordData> wordsByFrequency = new ArrayList<WordData>( words.values() );
  Collections.sort( wordsByFrequency, new CountCompare() );
         
  // Output the data from the map and from the list.
         
  System.out.println("List of words in alphabetical order" + " (with counts in parentheses): ");
  for ( WordData data : words.values()){
        System.out.println("   " + data.word + " (" + data.count + ")");
  }

  System.out.println("");
  System.out.println("List of words by frequency of occurence: ");
  for ( WordData data : wordsByFrequency ){
      System.out.println("   " + data.word + " (" + data.count + ")");
  }

  System.out.println("\n\nDone.\n\n");

  }
}