package Udemy.CompleteJavaMasterclass.MusicDB;

import Udemy.CompleteJavaMasterclass.MusicDB.model.Artist;
import Udemy.CompleteJavaMasterclass.MusicDB.model.DataSource;
import Udemy.CompleteJavaMasterclass.MusicDB.model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()){
            System.out.println("Cant open datasource");
            return;
        }
        List<Artist> artists = dataSource.queryArtists(DataSource.ORDER_BY_ASC);
        if (artists == null) {
            System.out.println("No artists!");
            return;
        }
        for (Artist artist : artists){
            System.out.println("ID= " + artist.getId() + ", Name = " + artist.getName());
        }
        List<String> albumsForArtists = dataSource.queryAlbumsForArtist("Carole King", DataSource.ORDER_BY_ASC);
        for(String album : albumsForArtists){
            System.out.println(album);
        }

        List<SongArtist> songArtists = dataSource.queryArtistsForSong("Go Your Own Way", DataSource.ORDER_BY_ASC);
        if (songArtists == null){
            System.out.println("Could not return query");
            return;
        }
        for (SongArtist artist : songArtists) {
            System.out.println("Artist name = " + artist.getAlbumName() + " Track = " + artist.getTrack());
        }
        dataSource.querySongsMetadata();
        int count = dataSource.getCount(DataSource.TABLE_SONGS);

        System.out.println("Number of songs is: " + count);
        dataSource.createViewForSongArtists();

//        Scanner s = new Scanner(System.in);
//        System.out.println("Enter a song title: ");
//        String title = s.nextLine();
//        songArtists = dataSource.querySongInfoView(title);
//        if(songArtists.isEmpty()){
//            System.out.println("Could not find artists for this song");
//            return;
//        }
//        for (SongArtist artist : songArtists) {
//            System.out.println("FROM VIEW - Artist name = " + artist.getArtistName() + " Album name = " +
//            artist.getAlbumName() + " Track number = " + artist.getTrack());
//        }ccg
        dataSource.insertSong("Touch of Grey", "Grateful Dead", "In The Dark",1);

        dataSource.close();
    }
}
