package curSRM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GooseInZooDivOne {
    private boolean used[][];
    private int N, M;
    private String[] field;
    private int dist;
    private static int Module = (int)(1e9)+7;

    private int dfs(int n, int m) {
        int count = 1;
        used[n][m] = true;

        for (int r=0; r<N; ++r) for (int w=0; w<M; ++w)
            if ((!used[r][w]) && (field[r].charAt(w) == 'v')){
                if ((Math.abs(r-n) + Math.abs(w-m) > dist)) continue;
                count += dfs(r, w);
            }

        return count;
    }

    public int count(String[] _field, int _dist) {
        field = _field;
        dist = _dist;

        List<Integer> geese = new ArrayList<Integer>();
        N = field.length;
        M = field[0].length();
        used = new boolean[N+1][M+1];

        for (int i=0; i<N; ++i) for (int j=0; j<M; ++j)
            if ((!used[i][j]) && (field[i].charAt(j) == 'v')) {
                geese.add(dfs(i, j));
            }

        int F[] = new int[3000];
        F[0] = 1;
        int maxVal = 0;
        for (Integer goose : geese) {
            for (int val = maxVal; val>=0; --val) {
                int nval = val + goose;
                F[nval] += F[val];
                if (F[nval] >= Module) F[nval] -= Module;
            }
            maxVal += goose;
        }


        int ret = 0;
        for (int i=2; i<=maxVal; i+=2) {
            ret += F[i];
            if (ret >= Module) ret -= Module;
        }
        return ret;
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }
}
