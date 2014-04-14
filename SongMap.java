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
        		
        		String fileName = file.getName()
        		//put lyrics in a string
        		String lyrics = "";
        		//while there is another line to read in the file 
        		while(scanner.hasNext()){
            		String line = scanner.nextLine();
            		lyrics = lyrics + line + "\n";
        		}	

        		SongRecord record = new SongRecord(filename, lyrics);
        		String artistAndSong = record.getArtist() + " - " + record.getSongName();
            	songCollection.put(artistAndSong, record);
            	scanner.close();
			}
		}
	}

	/* This method now searches the map for all keys containing the 
	* specified artist and places all of those values in a new map for the
	* given artist. This will allow us to compare a few artists or one instead
	* of computing wordcount for the entire collection
	*/
	public HashMap<String, SongRecord> songsByArtist(String artistName){
		HashMap<String, SongRecord> artistMap = new HashMap<String, SongRecord>();
		Set<String> songSet = songCollection.keySet();
		Iterator iter = songSet.iterator();
		while(iter.hasNext()){
			String next = iter.next();
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
	public static void print(HasMap<String, SongRecord> map){
		if(map.size() <= 0){
			System.out.println("There was no data in the map to be printed");
			Sytem.exit(1);
		}
		Set<String> songSet = map.keySet();
		Iterator iter = songSet.iterator();
		while(iter.hasNext()){
			String next = iter.next();
			if(next.contains(artistName)){
				SongRecord record = songCollection.get(next);				
				System.out.print("#" + record.getRank() + "  " + record.getSongName() +
				 	" by " + record.getArtist() + ": " + "\n" + record.getLyrics());
				System.out.println("----------------------------------------------------");

			}
		}
	}	
}



