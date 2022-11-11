import java.util.Objects;

// Base class
// Abstract
public abstract class Account {
    //private String Name;
    // account number
    private int accountNumber;

    // Balance
    protected double balance;

    // Default constructor
    public Account( ) {

        //this.Name = Name;
    }

   // public String getName() {
  //      return Name;
  //  }

   // public void setName(String lName) {
     //   this.Name = lName;
    //}

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;

    }

    // Getter methods
    public double getBalance() {

        return this.balance;
    }

    public int getAccountNumber() {

        return this.accountNumber;
    }

    // Abstract
    /**
     * Function to deposit funds into the account as long as
     * the amount parameter is > 0
     *
     * Apply Transaction fee for the CheckingAccount
     *
     */
    public abstract void deposit(double amount);

    /**
     * Function to withdraw funds from the Account as long as
     *  1. Amount to withdraw must be > 0
     *  2. Amount to withdraw must be <= balance
     */
    public abstract void withdraw(double amount);

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber == account.accountNumber && Double.compare(account.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance);
    }
}
