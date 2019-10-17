public class SavingsAccount extends Account {
    public static double MONTHLY_FEE = 30;
    public static int MAXIMUM_WITHDRAWALS = 30;
    private int withdrawals=0;
    private double monthlyFeeWaiveAmount=300;
    private boolean chargeMonthlyFee = true;

    SavingsAccount(String accountName, double amount) {
        super(accountName, amount);
    }

    @Override
    public void withdraw(double amount) {
        if (getWithdrawals() != MAXIMUM_WITHDRAWALS) {
            if (amount > getBalance()) {
                System.out.println("You can't pull $" + amount + ", you only have $" + getBalance());
            } else {
                super.withdraw(amount);
                addWithdrawal();
            }
        } else {
            System.out.println("You've reached the maximum number of withdrawals");
        }
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        decreaseMonthlyDepositAmt(amount);
    }

    public int getWithdrawals() {return withdrawals;}
    public void addWithdrawal() {withdrawals+=1;}
    public double getMonthlyFeeWaiveAmount(){ return monthlyFeeWaiveAmount;}
    private void waiveMonthlyFee() {chargeMonthlyFee=false;}

    private void decreaseMonthlyDepositAmt(double amount) {
        if (getMonthlyFeeWaiveAmount() > 0) {
            if (amount > getMonthlyFeeWaiveAmount()) {
                monthlyFeeWaiveAmount = 0;
                waiveMonthlyFee();
            } else {
                monthlyFeeWaiveAmount = getMonthlyFeeWaiveAmount() - amount;
            }
        }
    }

}
