public class DBBLAccount {

    private final String account_holder_name;
    private final String bank_account_number;
    private double bank_account_balance;

    public DBBLAccount(String account_holder_name, String bank_account_number, int bank_account_balance) {
        this.account_holder_name = account_holder_name;
        this.bank_account_number = bank_account_number;
        this.bank_account_balance = bank_account_balance;
    }

    synchronized void deposit(double amount) {
        if (amount > 0) {
            this.bank_account_balance += amount;
            System.out.println(Constants.ACCOUNT_HOLDER_NAME + account_holder_name + Constants.DEPOSIT + amount + Constants.BDT_TO + bank_account_number + Constants.NEW_BALANCE + bank_account_balance);
        } else {
            System.out.println(Constants.NO_DEPOSIT);
        }
    }

    synchronized void withdraw(double amount) {
        if (amount > 0) {
            this.bank_account_balance -= amount;
            System.out.println(Constants.ACCOUNT_HOLDER_NAME + account_holder_name + Constants.WITHDRAW + amount + Constants.BDT_FROM + bank_account_number + Constants.NEW_BALANCE + bank_account_balance);
        } else {
            System.out.println(Constants.INSUFFICIENT_BALANCE);
        }
    }

    public double getBank_account_balance() {
        return bank_account_balance;
    }
}
