package demo;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: yuanming
 * Date: 19/3/13
 * Time: PM10:01
 * To change this template use File | Settings | File Templates.
 */
public class setDemo {
    public static void main(String args[]) {
        Set<Integer> treeSet = new TreeSet<Integer>();
        Set<String> lstSet = new LinkedHashSet<String>();
        Set<Double> dlbSet = new HashSet<Double>();

        treeSet.add(Integer.valueOf(100));
        lstSet.add("Hello");
        dlbSet.add(Double.valueOf(1.1/2));

        debug(treeSet);
        debug(lstSet);
        debug(dlbSet);
    }

    static void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }
}
