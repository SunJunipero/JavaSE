package bank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final Lock locker = new ReentrantLock();
    private final Condition condition = locker.newCondition();
    private long balance;

    public Account(){
        this(0L);
    }

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        locker.lock();
        try {
            return balance;
        }
        finally {
            locker.unlock();
        }
    }

    public void withDraw(long amount){
            locker.lock();
            try {
                if(balance < amount)
                    throw new IllegalArgumentException("don't have enough money");
                balance -= amount;
                System.out.println("Account - : Current balance = " + balance);
            } finally {
                locker.unlock();
            }
    }
    public void WaitAndwithDraw(long amount){
        locker.lock();
        try {
            while (balance < amount) {
                condition.await();
                System.out.println("wake");
            }
            balance -= amount;
            System.out.println("Account - : Current balance = " + balance);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            locker.unlock();
        }
    }

    public void deposit (long amount ){
        locker.lock();
        try {
            balance += amount;
            System.out.println("Account + : Current balance = " + balance);
            condition.signalAll();
        }
        finally {
            locker.unlock();
        }
    }

}
