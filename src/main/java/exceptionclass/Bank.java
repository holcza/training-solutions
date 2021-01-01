package exceptionclass;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public Bank(List<Account> accounts) throws IllegalArgumentException{
        if (accounts==null||accounts.size()==0){
            throw new IllegalArgumentException();
        }
        this.accounts = accounts;
    }

    public void deposit (String accountNumber, double amount) throws InvalidBankOperationException{
        for (Account a: accounts){
            if (a.getAccountNumber().equals(accountNumber)){
                a.deposit(amount);
                return;
            }
        }
        throw new InvalidBankOperationException("",ErrorCode.INVALID_ACCOUNTNUMBER);
    }

    public void payment (String accountNumber, double amount) throws InvalidBankOperationException{
        for (Account a: accounts){
            if (a.getAccountNumber().equals(accountNumber)){
                a.subtract(amount);
                return;
            }
        }
        throw new InvalidBankOperationException("",ErrorCode.INVALID_ACCOUNTNUMBER);
    }
}
