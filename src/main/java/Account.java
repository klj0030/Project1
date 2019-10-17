public class Account {
    private double balance;
    private String accountName;
    private double totalFee = 0;

    Account(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    Account() {
        balance = 0;
        accountName = "empty";
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("A negative amount is not allowed for withdraw");
        }
        balance -= amount;
    }

    public double getTotalFee() {return totalFee;}

    public double getBalance()  {return balance;}

    public String getOwner() {return accountName;}

    public void addFee(double amount) {
        totalFee+=amount;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("A negative amount is not allowed for deposit!");
        }
        balance += amount;
    }

    public String toString() {
        return "Account belonging to: " + accountName + " has a balance of: $" + balance;
    }
}
