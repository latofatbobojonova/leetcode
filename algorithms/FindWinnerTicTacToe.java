//https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

public class FindWinnerTicTacToe {

    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];
        int len = moves.length;
        for (int i = 0; i < len; i += 2) {
            board[moves[i][0]][moves[i][1]] = 1;
        }

        for (int i = 1; i < len; i += 2) {
            board[moves[i][0]][moves[i][1]] = 2;
        }

        if (checkPlayer(board, 1))
            return "A";
        if (checkPlayer(board, 2))
            return "B";

        if (len == 9)
            return "Draw";
        return "Pending";
    }

    public boolean checkPlayer(int[][] board, int sign) {
        if (board[0][0] == sign && board[1][1] == sign && board[2][2] == sign)
            return true;
        if (board[0][0] == sign && board[0][1] == sign && board[0][2] == sign)
            return true;
        if (board[1][0] == sign && board[1][1] == sign && board[1][2] == sign)
            return true;
        if (board[2][0] == sign && board[2][1] == sign && board[2][2] == sign)
            return true;
        if (board[0][2] == sign && board[1][1] == sign && board[2][0] == sign)
            return true;
        if (board[0][0] == sign && board[1][0] == sign && board[2][0] == sign)
            return true;
        if (board[0][1] == sign && board[1][1] == sign && board[2][1] == sign)
            return true;
        if (board[0][2] == sign && board[1][2] == sign && board[2][2] == sign)
            return true;
        return false;
    }
}
