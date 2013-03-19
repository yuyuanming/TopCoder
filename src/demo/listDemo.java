package demo;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Frank
 * Date: 13-3-19
 * Time: 下午6:43
 * To change this template use File | Settings | File Templates.
 */
public class listDemo {
    public static void main(String args[]) {
        List<Integer> intLst = new ArrayList<Integer>();
        Random rnd = new Random();
        for (int i=0; i<10; ++i)
            intLst.add(Integer.valueOf(rnd.nextInt(100)));
        debug(intLst);
        Collections.sort(intLst);
        debug(intLst);
    }

    static void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }
}
