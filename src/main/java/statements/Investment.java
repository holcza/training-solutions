package statements;

public class Investment {
    private double cost=0.003;
    private int fund;
    private int interestRate;
    private boolean active=true;

    public Investment(int fund, int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
    }

    public int getFund() {
        return fund;
    }

    public double getYield (int days){
        return this.fund*this.interestRate/100/365*days;
    }

    public double close(int days){
        double result = this.active==false ? 0 : (this.fund+ getYield(days))*0.97;
        this.active=false;
        return result;
    }
}
