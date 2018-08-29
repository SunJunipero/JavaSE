package waitnotify.bankExample;

public class Demo {
    static class DepositThread extends Thread{
        private Bank bank;
        private long amount;

        public DepositThread(Bank bank, long amount) {
            this.bank = bank;
            this.amount = amount;
        }

        @Override
        public void run() {
            for (int i = 1; i <= amount; i++) {
                bank.deposit(1);
            }
        }
    }

    static class WithDrawThread extends Thread{
        private Bank bank;
        private long amount;

        public WithDrawThread(Bank bank, long amount) {
            this.bank = bank;
            this.amount = amount;
        }

        @Override
        public void run() {
//            for (int i = 0; i < amount; i++) {
//                //bank.withDraw(1);
//                bank.withDrawWithAwait(1);
//            }
            bank.withDrawWithAwait(amount);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank(25);

        DepositThread depositThread = new DepositThread(bank, 20);
        WithDrawThread withDrawThread = new WithDrawThread(bank, 40);


        withDrawThread.start();
        depositThread.start();



        withDrawThread.join();
        depositThread.join();



        System.out.println("balance !!! - " + bank.getBalance());


    }

}
