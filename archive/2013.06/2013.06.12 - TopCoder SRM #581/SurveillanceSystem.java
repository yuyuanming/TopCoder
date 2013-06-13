package curSRM;

import java.util.*;

public class SurveillanceSystem {
    public String getContainerInfo(String containers, int[] reports, int L) {
        StringBuffer sb = new StringBuffer();
        Arrays.sort(reports);
        //debug(reports);
        for (int i=0; i<containers.length(); ++i) {
            if (allNotInclude(containers, i, reports, L)) sb.append('-');
            else if (someStillNeed(containers, i, reports, L)) sb.append('+');
            else sb.append('?');
        }
        return sb.toString();
    }

    private boolean someStillNeed(String containers, int i, int[] reports, int L) {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for (int j=0; j<=containers.length()-L; ++j)
            if ((j>i) || (j+L-1<i)) {
                int cnt = 0;
                for (int k=0; k<L; ++k) if (containers.charAt(k+j) == 'X') ++cnt;
                lst.add(cnt);
            }
        Collections.sort(lst);
        //debug(lst);
        int lo = 0;
        int hi = lst.size();
        for (int e : reports) {
            while ((lo<hi) && (lst.get(lo)<e)) ++lo;
            if ((lo >= hi) || (lst.get(lo) != e)) return true;
            ++lo;
        }
        return false;  //To change body of created methods use File | Settings | File Templates.
    }

    private boolean allNotInclude(String containers, int i, int[] reports, int L) {
        int low = Math.max(0, i-L+1);
        int hig = Math.min(i, containers.length()-L);
        for (int k=low; k<=hig; ++k) {
            int cnt = 0;
            for (int j=0; j<L; ++j) if (containers.charAt(k+j) == 'X') ++cnt;
            for (int j=0; j<reports.length; ++j)
                if (cnt == reports[j]) return false;
        }
        return true;  //To change body of created methods use File | Settings | File Templates.
    }

    private void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }
}
