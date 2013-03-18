package curSRM;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TeamContest {
    public int worstRank(int[] strength) {
        int myScore = Math.max(strength[0], Math.max(strength[1], strength[2]))
                + Math.min(strength[0], Math.min(strength[1], strength[2]));

        List<Integer> Q = new ArrayList<Integer>();
        for (int i=3; i<strength.length; ++i)
            Q.add(Integer.valueOf(strength[i]));
        Collections.sort(Q);

        int ret = 0;
        while (!Q.isEmpty()) {
            int first = Q.get(Q.size()-1); Q.remove(Q.size()-1);

            boolean found = false;
            for (int i=0; i<Q.size()-1; ++i)
                if (first + Q.get(i) > myScore) {
                    ++ret;
                    Q.remove(i);
                    Q.remove(i);
                    found = true;
                    break;
                }
            if (!found) break;
        }

        return 1 + ret;
    }
}


