//https://leetcode.com/problems/pascals-triangle-ii/

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int n) {
        List<Integer> pascalRow = new ArrayList<>();

        pascalRow.add(1);

        if (n == 0) {
            return pascalRow;
        }

        for (int i = 1; i <= n / 2; i++) {
            double prod = pascalRow.get(i - 1);
            prod = prod * (n - i + 1) / i;
            pascalRow.add((int) prod);
        }

        for (int i = n / 2 + 1; i <= n; i++) {
            pascalRow.add(pascalRow.get(n - i));
        }

        return pascalRow;
    }
}
