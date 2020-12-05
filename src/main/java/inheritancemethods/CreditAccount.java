package inheritancemethods;

public class CreditAccount extends DebitAccount{

    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public boolean transaction(long amount) {
        if (amount + costOfTransaction(amount) > getBalance() + overdraftLimit) {
            return false;
        } else if (amount + costOfTransaction(amount) > getBalance()) {
            overdraftLimit -= amount + costOfTransaction(amount) - getBalance();
            setBalance(0);
            return true;
        } else {
            setBalance(getBalance() - amount - costOfTransaction(amount));
            return true;
        }
    }
}
