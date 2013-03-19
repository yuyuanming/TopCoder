package demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Frank
 * Date: 13-3-19
 * Time: 下午6:22
 * To change this template use File | Settings | File Templates.
 */
public class sortingDemo {
    public static void main(String args[]) {
        int[] num2sort = new int[100];
        Random rnd = new Random();
        for (int i=0; i<num2sort.length; ++i)
            num2sort[i] = rnd.nextInt() % 100;
        debug(num2sort);
        final Integer[] sorted = new Integer[num2sort.length];
        for (int i=0; i<num2sort.length; ++i)
            sorted[i] = num2sort[i];
        Arrays.sort(sorted);
        debug(sorted);

        Arrays.sort(sorted, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2);
            }
        });

        debug(sorted);
    }

    static void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }
}
