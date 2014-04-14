import java.io.*;
import java.util.*;

public class SongRecord {
	private String artist;
	private String songName;
	private String lyrics;
	private int rank;

	public SongRecord(){
		artist = null;
		songName = null;
		lyrics = null;
		rank = 0;
	}

	public SongRecord(String filename, String _lyrics){
		//get key which is artist and song, get the rank
        String[] filenames = filename.split(" -- ");
        rank = Integer.parseInt(filenames[0]);
        // each file ends in "... song .txt" to end at the g is 6 spaces
        int fileEnding = 6; 
        String artistAndSong = filenames[1].substring(1, filenames[1].length() - fileEnding);
        String[] tmp = artistAndSong.split(" - ");
        artist = tmp[0];
        songName = tmp[1];
        lyrics = _lyrics;
	}

	public String getArtist(){
		return artist;
	}

	public String getSongName(){
		return songName;
	}

	public String getLyrics(){
		return lyrics;
	}

	public int getRank(){
		return rank;
	}


}