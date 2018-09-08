package bank;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();

        Thread clientDec = new Thread(new ClientDec(account, 100), "ClientDec");
        Thread clientInc = new Thread(new ClientInc(account, 150), "ClientInc");


        clientDec.start();
        clientInc.start();

        clientDec.join();
        clientInc.join();

        System.out.println(" FINISHED ");
        System.out.println("Current balance - " + account.getBalance());

    }

    static class ClientInc implements Runnable{
        Account account;
        long amount;

        public ClientInc(Account account, long amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
            for (int i = 1; i <= amount; i++) {
                account.deposit(1);
            }
        }
    }

    static class ClientDec implements Runnable{
        Account account;
        long amount;

        public ClientDec(Account account, long amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
//            for (int i = 1; i <= amount; i++) {
//                //account.withDraw(1);
//                account.WaitAndwithDraw(1);
//            }
            account.WaitAndwithDraw(amount);
        }
    }
}
