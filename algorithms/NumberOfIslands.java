public class NumberOfIslands {
    char[][] grid;
    boolean[][] visited;
    int m, n;

    public int numIslands(char[][] grid) {
        this.grid = grid;

        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        m = grid.length;
        n = grid[0].length;
        int islands = 0;

        visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    islands++;
                    dfs(i, j);
                }
            }
        }
        return islands;
    }

    public void dfs(int i, int j){
        visited[i][j] = true;
        if(i > 0 && !visited[i-1][j] && grid[i-1][j] == '1')
            dfs(i-1, j);

        if(j > 0 && !visited[i][j-1] && grid[i][j-1] == '1')
            dfs(i, j-1);

        if(i < m - 1 && !visited[i+1][j] && grid[i+1][j] == '1')
            dfs(i+1, j);

        if(j < n - 1 && !visited[i][j+1] && grid[i][j+1] == '1')
            dfs(i, j+1);

    }
}
