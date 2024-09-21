public class DBBLTransaction implements Runnable{

    private DBBLAccount dbblAccount;
    private String paymentType;
    public double amount;

    public DBBLTransaction(DBBLAccount dbblAccount, String paymentType, double amount) {
        this.dbblAccount = dbblAccount;
        this.paymentType = paymentType;
        this.amount = amount;
    }


    public void run() {
        try {
            switch (paymentType) {
                case Constants.DEPOSIT:
                    dbblAccount.deposit(amount);
                    break;
                case Constants.WITHDRAW:
                    dbblAccount.withdraw(amount);
                    break;
                default:
                    System.out.println(Constants.INVALID_PAYMENT_TYPE);
                    break;
            }
        } catch (Exception e) {
            System.out.println(Constants.SOMETHING_WENT_WRONG + e.getMessage());
        }
    }


}
