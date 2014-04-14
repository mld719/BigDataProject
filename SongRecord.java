<<<<<<< HEAD
import java.io.*;
import java.util.*;
=======
// Authors: Cody Frenzel & Megan DeLaunay
>>>>>>> FETCH_HEAD

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

<<<<<<< HEAD
	public SongRecord(File file, String _lyrics){
		//get key which is artist and song, get the rank
        String[] filename = file.getName().split(" -- ");
=======
	public SongRecord(String file, String _lyrics){
		//get key which is artist and song, get the rank
        String[] fileName = file.getName().split(" -- ");
>>>>>>> FETCH_HEAD
        rank = Integer.parseInt(filename[0]);
        // each file ends in "... song .txt" to end at the g is 6 spaces
        int fileEnding = 6; 
        String artistAndSong = filename[1].substring(1, filename[1].length() - fileEnding);
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

<<<<<<< HEAD
	public int getRank(){
=======
	public String getRank(){
>>>>>>> FETCH_HEAD
		return rank;
	}


}