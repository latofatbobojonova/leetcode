//https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/

import java.util.ArrayList;
import java.util.List;

public class NumBurgersNoWasteIngredients {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int totalJumbo = 0;
        int totalSmall = 0;
        List<Integer> burgerNum = new ArrayList<>();

        if (tomatoSlices % 2 != 0)
            return burgerNum;

        if (tomatoSlices < cheeseSlices)
            return burgerNum;

        int remainder = tomatoSlices % 4;
        int k = tomatoSlices / 4;

        if (!(cheeseSlices >= k + remainder / 2 && cheeseSlices <= 2 * k + remainder / 2))
            return burgerNum;

        for (int i = 0; i <= cheeseSlices; i++) {
            if (2 * i + 4 * (cheeseSlices - i) == tomatoSlices) {
                totalSmall = i;
                totalJumbo = cheeseSlices - i;
                break;
            }
        }
        burgerNum.add(totalJumbo);
        burgerNum.add(totalSmall);

        return burgerNum;
    }
}
