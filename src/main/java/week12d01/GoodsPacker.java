package week12d01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GoodsPacker {
    public int packGoods(int[][] types, int capacity) {
        List<Good> goods = new ArrayList<>();
        for (int[] t : types) {
            goods.add(new Good(t[0], t[1]));
        }
        Collections.sort(goods);
        Collections.reverse(goods);

        int sumWeight = 0;
        int sumValue = 0;
        for (Good g : goods) {

            while (g.getWeight() + sumWeight <= capacity) {
                sumWeight = sumWeight+g.getWeight();
                sumValue = sumValue+g.getValue();
            }
        }
        return sumValue;
    }

    public static void main(String[] args) {
        GoodsPacker goodsPacker = new GoodsPacker();
        int [][] types = {{7, 160}, {3, 90}, {2, 15}};
        System.out.println(goodsPacker.packGoods(types,20));
    }
}
