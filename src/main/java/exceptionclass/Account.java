package exceptionclass;

public class Account {
    private String accountNumber;
    private double balance;
    private double maxSubstract;

    public Account(String accountNumber, double balance) throws IllegalArgumentException{
        if (accountNumber==null||accountNumber.isBlank()){
            throw new IllegalArgumentException();
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        maxSubstract = 100_000;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubstract;
    }

    public void setMaxSubtract(double maxSubstract) throws InvalidBankOperationException {
        if (-maxSubstract<=balance) {
            this.maxSubstract = maxSubstract;
        } else {
            throw new InvalidBankOperationException("",ErrorCode.INVALID_AMOUNT);
        }
    }

    public double deposit (double amount) throws InvalidBankOperationException{
        if(amount<0){
            throw new InvalidBankOperationException("",ErrorCode.INVALID_AMOUNT);
        }
        balance +=amount;
        return balance;
    }

    public double subtract(double amount) throws InvalidBankOperationException{
        if (amount<=maxSubstract&&amount>0) {
            if (balance>=amount) {
                balance -= amount;
                return balance;
            } else {
                throw new InvalidBankOperationException("",ErrorCode.LOW_BALANCE);
            }
        } else {
            throw new InvalidBankOperationException("",ErrorCode.INVALID_AMOUNT);
        }
    }
}
