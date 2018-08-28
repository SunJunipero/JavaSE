package waitnotify.store;

public class Store {
    private int goods = 0;

    public synchronized void put(){

        while (goods >= 3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        goods++;
        System.out.println("\t\tSupplier add item ");
        System.out.println("\t\tGoods on storage - " + goods);
        notify();
    }

    public synchronized void get(){
        while (goods < 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        goods--;
        System.out.println("Customer bought one item");
        System.out.println("Goods on storage - " + goods);
        notify();
    }
}
