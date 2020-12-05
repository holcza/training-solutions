package inheritancemethods;

public class DebitAccount {

    private final static double COST = -3.0;
    private final static long MIN_COST = -200;
    private String accountNumber;
    private long balance;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public final long costOfTransaction(long amount) {
        long costOfTransation = (long) (amount * COST / -100);
        return costOfTransation > -MIN_COST ? costOfTransation : -MIN_COST;
    }

    public boolean transaction(long amount) {
        if (amount + costOfTransaction(amount) > balance) {
            return false;
        } else {
            balance -= amount + costOfTransaction(amount);
            return true;
        }
    }

    public void balanceToZero() {
        balance = 0;
    }
}
