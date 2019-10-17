public class CheckingAccount extends Account {

    public static double OVERDRAFT_FEE = 35;

    CheckingAccount(String accountName, double balance) {
        super(accountName, balance);
    }

    @Override
    public void withdraw(double amount){
        super.withdraw(amount);
        if (getBalance()  < 0.0) {
            addFee(OVERDRAFT_FEE);
        }
    }

}
