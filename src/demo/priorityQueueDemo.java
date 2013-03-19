package demo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Frank
 * Date: 13-3-19
 * Time: 下午6:07
 * To change this template use File | Settings | File Templates.
 */
public class priorityQueueDemo {
    public static void main(String args[]) {
        //PriorityQueue<Integer> Q = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        PriorityQueue<Integer> Q = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1.intValue() - o2.intValue());
            }
        });

        Q.add(Integer.valueOf(100));
        Q.add(Integer.valueOf(20));
        System.out.println(Q.poll());
        System.out.println(Q.poll());
        System.out.println(Q.size());
    }
}
