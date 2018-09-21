package AlmostReaLifeExample.AlbumRating;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CFMainFlow {
    static Random random = new Random();
    /**
     * set counting ---> set rating ---> upd album
     */
    public static void main(String[] args) {

        long l = System.currentTimeMillis();

        getAlbums().thenCompose(albums -> {
            List<CompletableFuture<Album>> upd = albums.stream().map(album ->
                            setCounting(album.getArtist()).thenApply(ctn -> {
                                album.setCountListening(ctn);
                                return album;
                            }).thenCompose(album1 -> rating(album1.getCountListening()).thenApply(rtn -> {
                                album1.setRating(rtn);
                                return album1;
                            }))).collect(Collectors.toList());

            CompletableFuture<Void> done = CompletableFuture.allOf(upd.toArray(new CompletableFuture[upd.size()]));

            return done.thenApply(aVoid -> upd.stream().map(CompletableFuture::join).collect(Collectors.toList()));

                }
        ).join().forEach(System.out::println);


        System.out.println("Time = " + (System.currentTimeMillis() - l));



    }

    static CompletableFuture<Float> rating(int counting){
        return CompletableFuture.supplyAsync(() -> {
            try {
                delayRating();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("rating exception");
            }

            if (counting <= 33 )
                return 3.1f;
            else if(counting >= 66)
                return 9.7f;
            else return 6.2f;

        }).exceptionally(throwable -> 666.666f);
    }

    static CompletableFuture<Integer> setCounting(String name){
        return CompletableFuture.supplyAsync(() -> {
            try {
                delayCounting();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("counting exception");
            }
            return random.nextInt(100);
        }).exceptionally(throwable -> -1);


    }

    static void delayCounting() throws InterruptedException {
        Thread.sleep(5_000);
    }

    static void delayRating() throws InterruptedException {
        Thread.sleep(2_000);
    }

    static CompletableFuture<List<Album>> getAlbums(){
        ArrayList<Album> albums = new ArrayList<>();

        albums.add(new Album("AM", "Arctic Monkeys", 2013));
        albums.add(new Album("It's all over", "Pional", 2014));
        albums.add(new Album("Undertow", "Warpaint", 2015));
        albums.add(new Album("Smote Reverser", "Thee Oh Sees", 2018));
        albums.add(new Album("fin", "John Talabot", 2012));
        albums.add(new Album("licensed ti Ill", "Beastie Boys", 1993));
        albums.add(new Album("Little Dark Age", "MGMT", 2017));

        return CompletableFuture.supplyAsync( () -> albums);
    }
}
