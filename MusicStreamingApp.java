import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Song {
    private String artistName;
    private String songTitle;
    private int yearReleased;
    private int numPlays;

    public Song(String artistName, String songTitle, int yearReleased) {
        this.artistName = artistName;
        this.songTitle = songTitle;
        this.yearReleased = yearReleased;
        this.numPlays = 0;
    }

    public void play() {
        numPlays++;
    }

    public int getNumPlays() {
        return numPlays;
    }

    @Override
    public String toString() {
        return artistName + " - " + songTitle + " (" + yearReleased + ") - Plays: " + numPlays;
    }
}

class MusicPlayer {
    private List<Song> songList;

    public MusicPlayer() {
        songList = new ArrayList<>();
    }

    public void addSong(Song song) {
        songList.add(song);
    }

    public void removeSong(int index) {
        if (index >= 0 && index < songList.size()) {
            songList.remove(index);
        } else {
            System.out.println("Invalid index. Song not removed.");
        }
    }

    public void listAllSongs() {
        System.out.println("List of all songs:");
        for (int i = 0; i < songList.size(); i++) {
            System.out.println(i + ": " + songList.get(i));
        }
    }

    public void listSongsOverPlays(int minPlays) {
        System.out.println("List of songs with more than " + minPlays + " plays:");
        for (Song song : songList) {
            if (song.getNumPlays() > minPlays) {
                System.out.println(song);
            }
        }
    }
}

public class MusicStreamingApp {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a new song to the list of songs");
            System.out.println("2. Remove a song from list of songs");
            System.out.println("3. Print the list of all songs stored");
            System.out.println("4. List of songs over given number of plays");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter artist's name: ");
                    String artistName = scanner.nextLine();
                    System.out.print("Enter song title: ");
                    String songTitle = scanner.nextLine();
                    System.out.print("Enter year released: ");
                    int yearReleased = scanner.nextInt();
                    
                    scanner.nextLine(); // Consume the newline character

                    Song newSong = new Song(artistName, songTitle, yearReleased);
                    musicPlayer.addSong(newSong);
                    break;
                case 2:
                    System.out.print("Enter the index of the song to remove: ");
                    int indexToRemove = scanner.nextInt();
                    musicPlayer.removeSong(indexToRemove);
                    break;
                case 3:
                    musicPlayer.listAllSongs();
                    break;
                case 4:
                    System.out.print("Enter the minimum number of plays: ");
                    int minPlays = scanner.nextInt();
                    musicPlayer.listSongsOverPlays(minPlays);
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
