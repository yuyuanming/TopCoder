package curSRM;

import java.util.Arrays;

public class YetAnotherBoardGame {
    private int R, C, ret;
    private int A[][], occupied[], mType[];
    private String[] board;

    public int minimumMoves(String[] board) {
        this.board = board;
        R = board.length;
        C = board[0].length();
        A = new int[R+1][C];
        occupied = new int[C];
        Arrays.fill(occupied, -1);
        mType = new int[R+1];
        ret = R * C + 1;

        dfs(0);
        return ret <= (R * C) ? ret : -1;
    }

    private void dfs(int j) {
        if (j >= C) {
            int tmp = 0;
            for (int e : A[0]) if (e!=0) tmp++;

            mType[0] = 0;
            solve(0, tmp);

            mType[0] = 1;
            solve(0, tmp);
            return;
        }
        A[0][j] = 0; dfs(j+1);

        A[0][j] = 1;
        occupied[j] = 0;
        dfs(j + 1);
        occupied[j] = -1;
    }

    private void solve(int i, int cur) {
        if (cur >= ret) return;
        if (i >= R) {
            ret = cur;
            return;
        }

        int delta = 0;
        mType[i+1] = -1;
        boolean valid = true;
        for (int j=0; j<C; ++j) {
            int x = 0;
            if ((i>0) && (A[i-1][j] > 0)) x = 1 - x;
            if ((j>0) && (A[i][j-1] > 0)) x = 1 - x;
            if ((j+1<C) && (A[i][j+1] > 0)) x = 1 - x;
            if ((mType[i] == 1) && (A[i][j] > 0)) x = 1 - x;

            if (board[i].charAt(j) == 'W') {
                x = 1 - x;
            }
            A[i+1][j] = x;

            if (x > 0) {
                if (i+1 == R) {
                    valid = false;
                    break;
                }
                ++delta;
                if (occupied[j] == -1) {
                    occupied[j] = i + 1;
                }
                else {
                    if (mType[i+1] == -1) {
                        mType[i+1] = mType[occupied[j]];
                    }
                    else if (mType[i+1] != mType[occupied[j]]) {
                        valid = false;
                        break;
                    }
                }
            }
        }

        if (valid) {
            if (mType[i+1] != -1) {
                solve(i+1, cur+delta);
            }
            else {
                mType[i+1] = 0;
                solve(i+1, cur+delta);

                mType[i+1] = 1;
                solve(i+1, cur+delta);
            }
        }
        for (int j=0; j<C; ++j) if (occupied[j] == (i+1)) occupied[j] = -1;
    }

    private void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }
}