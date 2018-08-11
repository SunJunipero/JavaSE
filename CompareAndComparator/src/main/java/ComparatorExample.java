import model.Song;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExample {
    public static void main(String[] args) {
        TreeSet<Song> songs = new TreeSet<>();
        songs.add(new Song(341, "Suck it and see"));
        songs.add(new Song(302, "Black treacle"));
        songs.add(new Song(312, "Brick by brick"));
        songs.add(new Song(322, "Love is a laser quest"));
        songs.add(new Song(322, "Piledriver waltz"));

        System.out.println(songs);





    }
}
