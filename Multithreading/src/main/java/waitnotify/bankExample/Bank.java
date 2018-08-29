package waitnotify.bankExample;

public class Bank {
    private long balance;

    public Bank(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public synchronized void deposit (long amount){
        checkAmount(amount);
            balance += amount;
        System.out.println("deposit- " + Thread.currentThread().getName());
//        try {
////            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("balance -  " + balance);
        notifyAll();
    }

    public void withDraw (long amount){
        if(balance < amount)
            throw new IllegalArgumentException("money is not enough");
        balance -= amount;
    }

    public synchronized void withDrawWithAwait (long amount){
        System.out.println("init balance withdraw  - " + balance + " amount - " + amount);
        try {
            while (balance < amount){
                System.out.println("withDraw - "+Thread.currentThread().getName());
                wait();
                System.out.println("Still waiting " + balance);
                //Thread.sleep(100);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        balance -= amount;
        System.out.println("withdraw balance - " + balance);

    }

    private boolean checkAmount(long amount){
        if (amount < 0)
            throw new IllegalArgumentException("amount is negative");
        return true;
    }
}
