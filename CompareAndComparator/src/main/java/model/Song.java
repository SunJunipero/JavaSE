package model;

import java.util.Comparator;

public class Song implements Comparable<Song> {

    private Integer length;
    private String name;

    public Song(Integer lenght, String name) {
        this.length = lenght;
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Song song) {
        if (this.length < song.length)
            return -1;
        else if(this.length.equals(song.length)){
            if (this.name.length() < song.name.length()) {
                return -1;
            }
            else return 1;
        }
        else return 1;
    }

    @Override
    public String toString() {
        return "Song{" +
                "length=" + length +
                ", name='" + name + '\'' +
                '}';
    }
}
