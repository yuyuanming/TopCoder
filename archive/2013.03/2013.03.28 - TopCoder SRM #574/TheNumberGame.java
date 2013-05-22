package curSRM;

import java.util.Arrays;

public class TheNumberGame {
    public String determineOutcome(int A, int B) {
        String a = ""+A;
        String b = ""+B;
        if (a.contains(b) || a.contains(new StringBuilder(b).reverse().toString()))
            return "Manao wins";
        return "Manao loses";
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os).toString());
    }
}
