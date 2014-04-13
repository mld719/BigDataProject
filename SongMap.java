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

	public void songsByArtist(String artistName){
		Set<String> songSet = songCollection.keySet();
		Iterator iter = songSet.iterator();
		int numSongs = 0;
		while(iter.hasNext()){
			String next = iter.next();
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


	


}



