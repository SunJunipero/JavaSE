package AlmostReaLifeExample.AlbumRating;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainFlow {
    static Random random = new Random();
    /**
     * set counting ---> set rating
     */
    public static void main(String[] args) {

        long l = System.currentTimeMillis();

        List<Album> albums = getAlbums();

        albums.stream().peek(MainFlow::setCounting)
                .peek(album -> album.setRating(rating(album.getCountListening())))
        .forEach(System.out::println);

        System.out.println("Time = " + (System.currentTimeMillis() - l));



    }

    static float rating(int counting){
        try {
            delayRating();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("rating exception");
        }

        if (counting <= 33 )
            return 3.2f;
        else if(counting >= 66)
            return 9.4f;
        else return 6.5f;

    }



    static void setCounting(Album album){

        try {
            delayCounting();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("counting exception");
        }
        album.setCountListening(random.nextInt(100));

    }

    static void delayCounting() throws InterruptedException {
        Thread.sleep(5_000);
    }

    static void delayRating() throws InterruptedException {
        Thread.sleep(2_000);
    }

    static List<Album> getAlbums(){
        ArrayList<Album> albums = new ArrayList<>();

        albums.add(new Album("AM", "Arctic Monkeys", 2013));
        albums.add(new Album("It's all over", "Pional", 2014));
        albums.add(new Album("Undertow", "Warpaint", 2015));
        albums.add(new Album("Smote Reverser", "Thee Oh Sees", 2018));
        albums.add(new Album("fin", "John Talabot", 2012));
        albums.add(new Album("licensed ti Ill", "Beastie Boys", 1993));
        albums.add(new Album("Little Dark Age", "MGMT", 2017));

        return albums;
    }
}
