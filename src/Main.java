
public class Main {
    public static void main(String[] args) {

        DBBLAccount dbblAccount = new DBBLAccount(Constants.NAME, Constants.ACCOUNT_NUMBER, (int) Constants.TOTAL_AMOUNT);
        DBBLTransaction depositThread = new DBBLTransaction(dbblAccount, Constants.DEPOSIT, Constants.DEPOSIT_AMOUNT);
        DBBLTransaction withdrawThread = new DBBLTransaction(dbblAccount, Constants.WITHDRAW, Constants.WITHDRAW_AMOUNT);

        System.out.println(Constants.START_BALANCE + dbblAccount.getBank_account_balance());

        Thread withdrawThreadThread = new Thread(withdrawThread);
        Thread depositThreadThread = new Thread(depositThread);
        depositThreadThread.start();
        withdrawThreadThread.start();

        try {
            depositThreadThread.join();
            withdrawThreadThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Constants.TOTAL_BALANCE + dbblAccount.getBank_account_balance());


    }
}