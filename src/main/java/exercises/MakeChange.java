package exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tonycheung on 16/02/2017.
 */
public class MakeChange {

    Map<String, Integer> map = new HashMap<>();

    public static void main(String args[]) {
        int[] coins = {20,10,5,2,1};
        MakeChange makeChange = new MakeChange();
        int no = makeChange.makeChange(47, coins, 0);
        System.out.print(no);
    }

    private int makeChange(int money, int[] coins, int index) {

        if (money == 0) {
            return 1;
        }

        if (coins.length <= index) {
            return 0;
        }

        String key = money + "." + index;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int moneyInCoin = 0;
        int count = 0;

        while (moneyInCoin <= money) {
            int remaining = money - moneyInCoin;
            count += makeChange(remaining, coins, index+1);
            moneyInCoin += coins[index];
        }

        map.put(key,count);

        return count;
    }
}
