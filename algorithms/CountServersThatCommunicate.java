//https://leetcode.com/problems/count-servers-that-communicate/

import java.util.HashSet;
import java.util.Set;

class CountServersThatCommunicate {

    public int countServers(int[][] grid) {
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;

        Set<MyPair> communicatingServersSet = new HashSet<>();

        int[] serverNumInRow = new int[numberOfRows];
        int[] serverNumInColumn = new int[numberOfColumns];

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (grid[i][j] == 1) {
                    serverNumInRow[i]++;
                    serverNumInColumn[j]++;
                }
            }
        }

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (grid[i][j] == 1 && (serverNumInRow[i] > 1 || serverNumInColumn[j] > 1)) {
                    communicatingServersSet.add(new MyPair(i, j));
                }
            }
        }

        return communicatingServersSet.size();
    }

    class MyPair {
        int p1;
        int p2;

        MyPair(int p1, int p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }
}