package curSRM;

import java.util.Arrays;
import java.util.StringTokenizer;

public class WolfInZooDivOne {
    private int MODULE = (int)1e9 + 7;
    private int nearest[][], F[][];

    public int count(int N, String[] L, String[] R) {
        StringTokenizer stL = new StringTokenizer(parser(L));
        StringTokenizer stR = new StringTokenizer(parser(R));
        nearest = new int [N][N];
        for (int i=0; i<N; ++i) for (int j=i+1; j<N; ++j) nearest[i][j] = i - 1;
        while (stL.hasMoreTokens()) {
            int l = Integer.parseInt(stL.nextToken());
            int r = Integer.parseInt(stR.nextToken());
            for (int i=l; i<=r; ++i) for (int j=i+1; j<=r; ++j)
                nearest[i][j] = Math.min(nearest[i][j], l - 1);
        }

        F = new int[N][N];
        for (int[] v : F) Arrays.fill(v, -1);
        int ret = 1 + N;   // case only 0 or 1 wolf
        // enumerate the last 2 wolves' positions
        for (int i=0; i<N; ++i) for (int j=i+1; j<N; ++j) {
            ret += dp(i, j);
            if (ret >= MODULE) ret -= MODULE;
        }

        return ret;
    }

    private int dp(int i, int j) {
        if (F[i][j] >= 0) return F[i][j];
        int tmp = 1;
        for (int k=nearest[i][j]; k>=0; --k) {
            tmp += dp(k, i);
            if (tmp >= MODULE) tmp -= MODULE;
        }
        return F[i][j] = tmp;
    }

    private String parser(String[] str) {
        StringBuilder sb = new StringBuilder("");
        for (String s : str) sb.append(s);
        return sb.toString();
    }

    private void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }
}