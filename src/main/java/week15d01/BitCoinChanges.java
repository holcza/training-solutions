package week15d01;

import java.util.ArrayList;
import java.util.List;

public class BitCoinChanges {

    public BitcoinOpt getBitcoinOpt(List<Integer> bitcoinCurrencies){
        BitcoinOpt bc = new BitcoinOpt(-1,-1);
        int maxDiff = Integer.MIN_VALUE;

        for (int i =0; i<bitcoinCurrencies.size()-1;i++){
            for (int j = i+1;j<bitcoinCurrencies.size();j++){
                int actualDiff = bitcoinCurrencies.get(j)-bitcoinCurrencies.get(i);
                if (actualDiff>maxDiff){
                    maxDiff = actualDiff;
                    bc = new BitcoinOpt(i+1,j+1);
                }
            }
        }

        return bc;
    }

    public static void main(String[] args) {
        List<Integer> currencies = List.of(120,1,20,40,100,2);
        BitcoinOpt bitcoinOpt = new BitCoinChanges().getBitcoinOpt(currencies);
        System.out.println(bitcoinOpt.getEnter());
        System.out.println(bitcoinOpt.getExit());
    }


}
