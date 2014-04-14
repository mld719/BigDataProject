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
        		
        		String filename = file.getName();
        		//put lyrics in a string
        		String lyrics = "";
        		//while there is another line to read in the file 
        		while(scanner.hasNext()){
            		String line = scanner.nextLine();
            		lyrics = lyrics + line + "\n";
        		}	

        		SongRecord record = new SongRecord(file, lyrics);
        		String artistAndSong = record.getArtist() + " - " + record.getSongName();
            	songCollection.put(artistAndSong, record);
            	scanner.close();
			}
		}
	}

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

			}
		}

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



}
