package initializer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    private static final List<Rate> ACTUAL_RATES = new ArrayList<>();


    private long balance;


    public CreditCard(long balance, Currency currency, List<Rate> rates) {
        ACTUAL_RATES.addAll(rates);
        this.balance = Math.round(balance * getConversionRate(currency));
    }

    public CreditCard(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public boolean payment(long amount) {
        boolean isEnoughBalance = false;

        long balanceCheck = balance - amount;
        if (balanceCheck > 0) {
            balance = balanceCheck;
            isEnoughBalance = true;
        }


        return isEnoughBalance;
    }

    public boolean payment(long amount, Currency currency) {
        boolean inEnoughBalance = false;
        long amountInHuf = 0;
        for (Rate r : ACTUAL_RATES) {
            if (currency == r.getCurrency()) {
                amountInHuf = Math.round(amount * r.getConversionFactor());
            }
        }


        long balanceCheck = balance - amountInHuf;
        if (balanceCheck > 0) {
            balance = balanceCheck;
            inEnoughBalance = true;
        }


        return inEnoughBalance;
    }

    private double getConversionRate(Currency currency) {
        for (Rate r : ACTUAL_RATES) {
            if (r.getCurrency() == currency) {
                return r.getConversionFactor();
            }
        }
        return 1.0;
    }
}
