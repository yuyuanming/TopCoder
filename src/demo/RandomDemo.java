package demo;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Frank
 * Date: 13-3-20
 * Time: 下午12:04
 *
 * {@code (rand % n)} is far more biased than {@code rand(n)}, so use library API whenever possible
 */
public class RandomDemo {
    public static void main(String args[]) {
        Random rnd = new Random();

        int genSize = 40037;
        int rGenBlw = 0;

        for (int i=0; i<genSize; ++i)
            if (rnd.nextInt() % genSize <= genSize/2)
                ++rGenBlw;
        System.out.println(rGenBlw);

        rGenBlw = 0;
        for (int i=0; i<genSize; ++i)
            if (rnd.nextInt(genSize) <= genSize/2)
                ++rGenBlw;
        System.out.println(rGenBlw);
    }
}
