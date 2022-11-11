import java.io.File;
import java.io.FileNotFoundException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manage Bank Accounts
 *
 */
public class Bank {
    // Account Number creator
    private static int accountCounter = 1000;
    private static double FEE = 2.5;
    private static double IR = 0.05; // 5% assumption

    // collection of Accounts
    private ArrayList<Account> accounts;

    public Bank() throws FileNotFoundException {
        accounts = new ArrayList<>();
        readBankAccount();
    }

    /**
     * Add New Accounts
     */
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    /**
     * Find an account with given account numbers.
     */
   public Account getAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    /**
     * Deposit amount to an account.
     */
    public boolean deposit(int accountNumber, double amount) {
        Account account = this.getAccount(accountNumber);

        if (account == null) {
            return false;
        }

        if (amount > 0) {
            account.deposit(amount);
            return true;
        }

        return false;
    }

    /**
     * Withdraw an amount
     */
    public boolean withdraw(int accountNumber, double amount) {
        Account account = this.getAccount(accountNumber);

        if (account == null) {
            return false;
        }

        if (amount <= 0 || account.getBalance() < amount) {
            return false;
        }

        account.withdraw(amount);
        return true;
    }

    public static int getNextAccountNumber() {
        accountCounter++;
        return accountCounter;
    }

    public static double getFee() {
        return FEE;
    }

    public static double getIR() {

        return IR;
    }

    public void readBankAccount() throws FileNotFoundException {
        Scanner in = new Scanner(new File("D:\\BankAccountFile.txt"));
        while (in.hasNextLine()) {
            int i = in.nextInt();
            double b = in.nextDouble();
            //addAccount(i,b);
        }
        in.close();
    }
    public  void writBankAccount() throws FileNotFoundException {
        PrintWriter w=new PrintWriter(new File("D:\\BankAccountFile.txt"));
        for (int i = 0; i < accountCounter; i++) {


            w.write(accounts.get(i).getBalance()+" "+ accounts.get(i).getAccountNumber()+"\n");
        }
    }
}