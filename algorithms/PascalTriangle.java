//https://leetcode.com/problems/pascals-triangle/

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascal = new ArrayList<>();

        if (numRows == 0) {
            return pascal;
        }

        pascal.add(new ArrayList<>());
        pascal.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            pascal.add(new ArrayList<>());

            pascal.get(i).add(1);

            for (int j = 1; j < i; j++) {
                pascal.get(i).add(
                        pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j)
                );
            }

            pascal.get(i).add(1);
        }

        return pascal;
    }
}
