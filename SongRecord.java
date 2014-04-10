// Authors: Cody Frenzel & Megan DeLaunay

import java.util.*;
import java.io.*;

public class SongRecord {
    private String artist;
    private String lyrics;
    private int rank;

    public SongRecord(){
        artist = null;
        lyrics = null;
        rank = 0;
    }

    public SongRecord(File file){
        //get key which is artist and song, get the rank
        String[] filename = file.getName().split(" -- ");
        String strRank = filename[0];
        // each file ends in "... song .txt" to end at the g is 6 spaces
        int fileEnding = 6; 
        String artistAndSong = filename[1].substring(1, filename[1].length() - fileEnding);
        String[] tmp = artistAndSong.split(" - ");
        arti    st = tmp[0];
        lyrics = tmp[1];
    }

    public string getArtist()
    {
        return artist;
    }
    
    public string getSongName()
    {
        return lyrics;
    }
    
    public string getLyrics()
    {
        return lyrics();
    }
    
}