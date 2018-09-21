package AlmostReaLifeExample.AlbumRating;

public class Album {
    private String name;
    private String artist;
    private int year;
    private int countListening;
    private float rating;

    public Album(String name, String artist, int year) {
        this.name = name;
        this.artist = artist;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public float getRating() {
        return rating;
    }

    public int getCountListening() {
        return countListening;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setCountListening(int countListening) {
        this.countListening = countListening;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", year=" + year +
                ", countListening=" + countListening +
                ", rating=" + rating +
                '}';
    }
}
