// Authors: Cody Frenzel & Megan DeLaunay

import java.util.*;
import java.io.*;

public class SongMap {
	private HashMap<String, SongRecord> songCollection;
	private String folderPath = "temp/file/path/";

	public SongMap(){
		songCollection = new HashMap<String, SongRecord>();
		read(folderPath);
	}

	public void read(String filePath){
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		for(File file : listOfFiles){
			if(file.isFile()){
				//check if you can read file
        		if (!file.canRead()) {
            		System.err.println("The file you requested is not readable.");
            		System.exit(1);
        		}

        		Scanner scanner = null;
        		try {
            		scanner = new Scanner(file);
        		} catch (FileNotFoundException e) {
            		System.err.println("The file you requested does not exist.");
            		System.exit(1);
        		}
        		
<<<<<<< HEAD
        		String filename = file.getName();
=======
        		String fileName = file.getName()
>>>>>>> FETCH_HEAD
        		//put lyrics in a string
        		String lyrics = "";
        		//while there is another line to read in the file 
        		while(scanner.hasNext()){
            		String line = scanner.nextLine();
            		lyrics = lyrics + line + "\n";
        		}	

<<<<<<< HEAD
        		SongRecord record = new SongRecord(file, lyrics);
=======
        		SongRecord record = new SongRecord(filename, lyrics);
>>>>>>> FETCH_HEAD
        		String artistAndSong = record.getArtist() + " - " + record.getSongName();
            	songCollection.put(artistAndSong, record);
            	scanner.close();
			}
		}
	}

<<<<<<< HEAD
	public void songsByArtist(String artistName){
		Set<String> songSet = songCollection.keySet();
		//Iterator<String> iter = songSet.iterator();
		int numSongs = 0;
		for(String next: songSet)
		{
			//String next = iter.next();
			if(next.contains(artistName)){
				numSongs++;
				SongRecord record = songCollection.get(next);

				System.out.print("#" + record.getRank() + ". " + record.getSongName() +
				 	" by " + record.getArtist() + ": " + "\n" + record.getLyrics());
				System.out.println("----------------------------------------------------");

=======
	/* This method now searches the map for all keys containing the 
	* specified artist and places all of those values in a new map for the
	* given artist. This will allow us to compare a few artists or one instead
	* of computing wordcount for the entire collection
	*/
	public HashMap<String, SongRecord> songsByArtist(String artistName){
		HashMap<String, SongRecord> artistMap = new HashMap<String, SongRecord>();
		Set<String> songSet = songCollection.keySet();
		for(String next : songSet){
			if(next.contains(artistName)){
				SongRecord record = songCollection.get(next);
				artistMap.put(next, record);
			}
		}

		if(artistMap.size() == 0){
			System.out.println("There were no results for: " + artistName);
			System.exit(1);
		}

		return artistMap;
	}

	// static method that prints the content of a specified map
	public static void print(HashMap<String, SongRecord> map){
		if(map.size() <= 0){
			System.out.println("There was no data in the map to be printed");
			Sytem.exit(1);
		}

		Set<String> songSet = map.keySet();
		for(String next : sonSet){
			if(next.contains(artistName)){
				SongRecord record = songCollection.get(next);				
				System.out.print("#" + record.getRank() + "  " + record.getSongName() +
				 	" by " + record.getArtist() + ": " + "\n" + record.getLyrics());
				System.out.println("----------------------------------------------------");

			}
		}
	}

	public String mostWords(){
		String most = "";
		int mostWords = 0;
		Set<String> songSet = songCollection.keySet();
		
		for(String next : songSet){
			int tmpMost = 0;
			SongRecord record = songCollection.get(next);
			Scanner scanner = new Scanner(record.getLyrics);
			while(scanner.hasNext()){
				String tmp = scanner.next();
				tmpMost++;
			}

			if(tmpMost > mostWords){
				mostWords = tmpMost;
				most = next;
>>>>>>> FETCH_HEAD
			}

			scanner.close;
		}

<<<<<<< HEAD
		if(numSongs == 0){
			System.out.println("There were no results that matched: " + artistName);
		}
	}

	public String topArtist()
	{
	    Collection<SongRecord> recordsTMP = songCollection.values();
	    Object[] recordsOBJ = recordsTMP.toArray();
	    SongRecord[] records = (SongRecord[]) recordsOBJ;
	    
	    
	    HashMap<String, Integer> artistCounts = new HashMap<String, Integer>();
	    
	    for(int i = 0; i < records.length; i++)
	    {
	        //for each song, find artist.
	        
	        SongRecord r = records[i];
	        String artistName = r.getArtist();
	        
	        if(artistCounts.containsKey(artistName))
	        {
	            int value = artistCounts.get(artistName);
	            artistCounts.remove(artistName);
	            
	            artistCounts.put(artistName, value++);
	        }
	        else
	        {
	            artistCounts.put(artistName, 1);	            
	        }
	        //if artist is novel, add to hashmap as artist, 1
	        //if artist is NOT novel, increase its value by 1
	    }
	    
	    //now, get values and find highest
	    Object[] artistsOBJ = (artistCounts.keySet()).toArray();
	    String[] artists = (String[]) artistsOBJ;
	    
	    Object[] countsOBJ = (artistCounts.values()).toArray();
	    Integer[] counts = (Integer[]) countsOBJ;
	    
	    Integer highest = counts[0];
	    
	    for(int i = 1; i < counts.length; i++)
	    {
	        Integer two = counts[i];
	        
	        if(two.compareTo(highest) >= 0)
	        {
	            highest = two;
	        }
	        else
	        {
	            continue;
	        }
	    }
	    
	    
	    return artists[highest];
	}


=======
		most = "The song with the most words is (" + most + ") with " + Integer.toString(mostWords) + " words!";
		return most;

	}

	public String leastWords(){
		String least = "";
		int leastWords = 0;
		int index = 1;
		Set<String> songSet = songCollection.keySet();
		
		for(String next : songSet){
			int tmpLeast = 0;
			SongRecord record = songCollection.get(next);
			Scanner scanner = new Scanner(record.getLyrics);
			while(scanner.hasNext()){
				String tmp = scanner.next();
				tmpLeast++;
			}
>>>>>>> FETCH_HEAD

			//only for first case to set this as the least
			if(index == 1){
				leastWords = tmpLeast;
				least = next;
			
			} else if(tmpLeast < leastWords){
				leastWords = tmpLeast;
				least = next;
			}

			index++;
			scanner.close;
		}

		most = "The song with the least words is (" + least + ") with " + Integer.toString(leastWords) + " words!";
		return least;

	}	
}



