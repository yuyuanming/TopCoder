package curSRM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeUnion {
    public double expectedCycles(String[] tree1, String[] tree2, int K) {
        int A[] = distOfTree(tree1);
        int B[] = distOfTree(tree2);

        double ret = 0;
        int N = A.length;
        for (int l1=1; l1<=K-3; ++l1) {
            int l2 = K - 2 - l1;
            if ((l1>=N) || (l2<1) || (l2>=N)) continue;
            ret += 2.0 * A[l1] * B[l2] / N / (N-1);
        }

        return ret;
    }

    private int[] distOfTree(String[] tree) {
        StringBuffer sb = new StringBuffer();
        for (String s : tree) sb.append(s);
        StringTokenizer st = new StringTokenizer(sb.toString());
        ArrayList<Integer> A = new ArrayList<Integer>();
        while (st.hasMoreTokens()) {
            int i = Integer.parseInt(st.nextToken());
            A.add(i);
        }

        int N = A.size() + 1;
        int dist[][] = new int[N][N];

        for (int[] elem : dist) Arrays.fill(elem, N+1);
        for (int i=0; i<N; ++i) dist[i][i] = 0;
        for (int i=1; i<N; ++i) {
            int j = A.get(i-1);
            dist[i][j] = dist[j][i] = 1;
        }
        for (int k=0; k<N; ++k)
            for (int i=0; i<N; ++i) for (int j=0; j<N; ++j) {
                int tmp = dist[i][k] + dist[k][j];
                if (tmp < dist[i][j]) dist[i][j] = tmp;
            }

        int D[] = new int[N];
        for (int i=0; i<N; ++i) for (int j=i+1; j<N; ++j) {
            D[dist[i][j]]++;
        }

        return D;  //To change body of created methods use File | Settings | File Templates.
    }

    private void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }
}
