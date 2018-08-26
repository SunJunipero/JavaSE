package Synchronized.accumulator;

public class Client implements Runnable{
    Resource resource;
    String name;

    public Client(Resource resource, String name){
        this.resource = resource;
        this.name = name;
    }

    @Override
    public void run() {
            resource.changeI();
    }
}
